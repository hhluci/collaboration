package nuc.crowdsys.aspect;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import nuc.crowdsys.annotation.SystemLog;
import nuc.crowdsys.entity.SysLog;
import nuc.crowdsys.entity.SysUser;
import nuc.crowdsys.service.SysLogService;
import nuc.crowdsys.utils.IpUtil;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Aspect
@Component
public class LogAopAction {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ObjectMapper objectMapper;

    //注入service,用来将日志信息保存在数据库
    @Autowired
    private SysLogService logservice;

    //配置接入点,如果不知道怎么配置,可以百度一下规则
    @Pointcut("execution(public * nuc.crowdsys.controller..*.*(..))")
    private void controllerAspect() {
    }//定义一个切入点

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //常见日志实体对象
        SysLog log = new SysLog();
        //获取登录用户账户
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            logger.info(System.getProperty("line.separator") + "===>操作用户===>" + user.getUsername());
            log.setUsername(user.getUsername());
        } else {
            logger.info(System.getProperty("line.separator") + "===>操作用户===>" + "即将登陆用户");
            log.setUsername(null);
        }
        log.setLogid(null);
        //获取系统时间
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        logger.info(System.getProperty("line.separator") + "===>操作时间===>" + time);
        log.setData(time);

        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
        String ip = IpUtil.getLocalIP();
        logger.info(System.getProperty("line.separator") + "===>操作地址ip===>" + ip);
        log.setIp(ip);

        // 请求的类名
        String className = pjp.getTarget().getClass().getName();
        // 请求的方法名
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getName();
        logger.info(System.getProperty("line.separator") + "===>请求方法名===>" + className + "." + methodName + "()");
        log.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = pjp.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        Method method = signature.getMethod();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            logger.info(System.getProperty("line.separator") + "===>方法参数===>" + params.toString());
            log.setParams(params.toString());
        }

        //方法通知前获取时间,为计算模块执行时间
        long start = System.currentTimeMillis();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        Object object = null;

        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            if (method.isAnnotationPresent(SystemLog.class)) {
                SystemLog systemlog = method.getAnnotation(SystemLog.class);
                logger.info(System.getProperty("line.separator") + "===>操作模块===>" + systemlog.module());
                log.setModule(systemlog.module());
                logger.info(System.getProperty("line.separator") + "===>操作方法描述===>" + systemlog.methods());
                log.setMethoddescription(systemlog.methods());
                try {
                    object = pjp.proceed();
                    long end = System.currentTimeMillis();
                    //将计算好的时间保存在实体中
                    logger.info(System.getProperty("line.separator") + "===>响应时间===>" + (end - start));
                    log.setResponsedata("" + (end - start));
                    logger.info(System.getProperty("line.separator") + "===>操作描述===>" + "执行成功！");
                    log.setDescription("执行成功！");
                    //保存进数据库
                    logservice.saveLog(log);
                } catch (Throwable e) {
                    // TODO Auto-generated catch block
                    long end = System.currentTimeMillis();
                    logger.info(System.getProperty("line.separator") + "===>响应时间===>" + (end - start));
                    log.setResponsedata("" + (end - start));
                    logger.info(System.getProperty("line.separator") + "===>操作描述===>");
                    log.setDescription("执行失败");
                    logservice.saveLog(log);
                }
            } else {//没有包含注解
                object = pjp.proceed();
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }

    private StringBuilder handleParams(StringBuilder params, Object[] args, List paramNames) throws IOException {
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Map) {
                Set set = ((Map) args[i]).keySet();
                List list = new ArrayList();
                List paramList = new ArrayList<>();
                for (Object key : set) {
                    list.add(((Map) args[i]).get(key));
                    paramList.add(key);
                }
                return handleParams(params, list.toArray(), paramList);

            } else {
                if (args[i] instanceof Serializable) {
                    Class<?> aClass = args[i].getClass();
                    try {
                        aClass.getDeclaredMethod("toString", new Class[]{null});
                        // 如果不抛出 NoSuchMethodException 异常则存在 toString 方法 ，安全的 writeValueAsString ，否则 走 Object的 toString方法
                        params.append("  ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
                    } catch (NoSuchMethodException e) {
                        params.append("  ").append(paramNames.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
                    }

                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    params.append("  ").append(paramNames.get(i)).append(": ").append(file.getName());
                } else {
                    params.append("  ").append(paramNames.get(i)).append(": ").append(args[i]);
                }
            }
        }
        return params;
    }
}
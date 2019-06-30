package nuc.crowdsys.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import nuc.crowdsys.entity.SysDict;
import nuc.crowdsys.entity.SysLog;
import nuc.crowdsys.mapper.SysLogMapper;
import nuc.crowdsys.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("logService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysLogServiceImpl extends BaseService<SysLog> implements SysLogService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    public List<SysLog> findAllLogs(SysLog log) {
        try {
            Example example = new Example(SysLog.class);
            Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(log.getUsername())) {
                criteria.andCondition("username=", log.getUsername().toLowerCase());
            }
            if (StringUtils.isNotBlank(log.getDescription())) {
                criteria.andCondition("description like", "%" + log.getDescription() + "%");
            }
            if (StringUtils.isNotBlank(log.getData())) {
                String[] timeArr = log.getData().split("~");
                criteria.andCondition("date_format(data,'%Y-%m-%d') >=", timeArr[0]);
                criteria.andCondition("date_format(data,'%Y-%m-%d') <=", timeArr[1]);
            }
            example.setOrderByClause("logid desc");
            return this.selectByExample(example);
        } catch (Exception e) {
            logger.error("获取系统日志失败", e);
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public void deleteLogs(String logIds) {
        List<String> list = Arrays.asList(logIds.split(","));
        //List<Long> ids = list.stream().map(a -> Long.parseLong(a)).collect(Collectors.toList());
        this.batchDelete(list, "logid", SysLog.class);
    }

    @Override
    public void saveLog(SysLog log) {
        sysLogMapper.saveLog(log);
    }
}



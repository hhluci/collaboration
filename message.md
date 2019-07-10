**mybatis和activiti集成时报错**
版本信息：springboot 2.0，mybatis 3.4.6 , tkmybatis 2.0 ,activiti 6.0

今天在集成项目的时候，发现mybatis和activiti集成时不会报错，但是mapper和activiti集成到一起时启动就会报错，错误信息如下：

Parameter 1 of method springProcessEngineConfiguration in org.activiti.spring.boot.JpaProcessEngineAutoConfiguration$JpaConfiguration required a bean of type 'javax.persistence.EntityManagerFactory' that could not be found.
于是查看了一下JpaProcessEngineAutoConfiguration类，部分代码如下：

public class JpaProcessEngineAutoConfiguration {
    public JpaProcessEngineAutoConfiguration() {
    }
 
    @Configuration
    @ConditionalOnClass(
        name = {"javax.persistence.EntityManagerFactory"}
    )
    @EnableConfigurationProperties({ActivitiProperties.class})
    public static class JpaConfiguration extends AbstractProcessEngineAutoConfiguration {
        public JpaConfiguration() {
        }
    }
}
可以看到EntityManagerFactory是被@ConditionlOnClass所注解的。而EntityManagerFactory是来自于JPA相关的接口。其实这里是Activiti所做的判断，如果项目使用了JPA，那走JPA，如果没有，则走Mybatis。所以只引入Mybatis和Activiti的话项目不会报错，那为什么引入了Mapper就会报错呢？

继续看mapper的源码就能知道原因，其实mapper并没有实现EntityManagerFactory接口，而是自己写了一套，而在Activiti中则认为当前项目使用的是JPA，找不到EntityManagerFactory的实现类。所以报错。解决方法就是在mapper中移除对persistence-api依赖，在activiti中加上jpa的依赖。这样的话，项目启动不会报错，并且能正常使用tkmybatis，省去了公共的增删改查代码。

修改后的pom.xml如下：

        <!-- 集成tk-mapper -->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
            <version>${tk.mapper.version}</version>
            <exclusions>
                <exclusion>
                    <artifactId>persistence-api</artifactId>
                    <groupId>javax.persistence</groupId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- activiti -->
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-spring-boot-starter-basic</artifactId>
            <version>${activiti.version}</version>
        </dependency>
        <dependency>
            <groupId>org.activiti</groupId>
            <artifactId>activiti-spring-boot-starter-jpa</artifactId>
            <version>${activiti.version}</version>
        </dependency>
package org.curd.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.curd.datesource.DataSourceType;
import org.curd.datesource.DataSourceTypeHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(org.curd.aspect.TargetDataSource)")
    public void method(){}

//    @Pointcut("@within(org.curd.aspect.TargetDataSource)")
//    public void type(){
//    }

    @Before("method() && @annotation(td)")
    public void before(TargetDataSource td){
        logger.info("选择数据源.....");
        DataSourceType dataSourceType = td.value();
        DataSourceTypeHolder.setDataSourceType(dataSourceType);
    }

//
    @After("method()")
    public void aType(){
//        System.out.println(td.value());
//        DataSourceTypeHolder.clear();
        DataSourceTypeHolder.setDataSourceType(DataSourceType.READ);
    }


//    @After("method() && @annotations(td)")
//    public void after(TargetDataSource td){
//        DataSourceTypeHolder.clear();
//    }



}

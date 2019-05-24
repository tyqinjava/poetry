package org.curd.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.curd.datesource.DataSourceType;
import org.curd.datesource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean("read")
    @ConfigurationProperties("read.datasource")
    public DruidDataSource master(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("write")
    @ConfigurationProperties("write.datasource")
    public DruidDataSource cluster(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean("primaryDataSource")
    public DataSource dataSource(@Qualifier("read")DataSource master,
                                 @Qualifier("write")DataSource cluster){
        DynamicDataSource dynamicDataSource =  new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DataSourceType.READ, cluster);
        targetDataSources.put(DataSourceType.WRITE, master);
        dynamicDataSource.setDefaultTargetDataSource(master);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        return dynamicDataSource;
    }

}

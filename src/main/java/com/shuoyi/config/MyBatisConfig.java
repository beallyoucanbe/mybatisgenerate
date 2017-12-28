package com.shuoyi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by sidney on 20/03/2017.
 */
@Configuration
@MapperScan(basePackages = "com.shuoyi.mapper.user", sqlSessionTemplateRef = "userSqlSessionTemplate")
public class MyBatisConfig {

    @Resource(name = "userDataSource")
    private DataSource userDataSource;

    @Bean(name = "userSqlSessionFactory")
    @Primary
    public SqlSessionFactory createSqlSessionFactory(@Qualifier("userDataSource") DataSource userDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(userDataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "userTransactionManager")
    @Primary
    public DataSourceTransactionManager createTransactionManager(@Qualifier("userDataSource") DataSource userDataSource) {
        return new DataSourceTransactionManager(userDataSource);
    }

    @Bean(name = "userSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate createSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory userSqlSessionFactory) {
        return new SqlSessionTemplate(userSqlSessionFactory);
    }
}

package com.shuoyi.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zhaosy-c on 2017/12/28.
 */
@Configuration
public class CompanyDataSourceConfig extends AbstractDataSourceConfig implements EnvironmentAware {

    private RelaxedPropertyResolver relaxedPropertyResolver;

    @Bean(name = "companyDataSource")
    public DataSource getCompanyDatasource() throws SQLException {
        return getDataSource(relaxedPropertyResolver);
    }

    @Bean(name = "companySqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("companyDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "companyTransactionManager")
    public DataSourceTransactionManager getTransactionManager(@Qualifier("companyDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);

    }

    @Bean(name = "companySqlSessionTemplate")
    public SqlSession getSqlSession(@Qualifier("companySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    public void setEnvironment(Environment environment) {
        relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.user.datasource.");
    }
}

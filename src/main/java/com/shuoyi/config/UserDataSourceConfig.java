package com.shuoyi.config;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zhangxy-j on 17/05/2017 9:26 AM.
 */
@Configuration
public class UserDataSourceConfig extends AbstractDataSourceConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Bean(name = "userDataSource")
    @Primary
    public DataSource createDataSource() throws SQLException {
        return getDataSource(propertyResolver);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.user.datasource.");
    }

}

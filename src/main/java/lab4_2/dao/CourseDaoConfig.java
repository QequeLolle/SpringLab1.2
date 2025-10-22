package lab4_2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan("lab4_2.dao")
public class CourseDaoConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource webDataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        ds.setUrl(env.getRequiredProperty("jdbc.url"));
        ds.setUsername(env.getRequiredProperty("jdbc.username"));
        ds.setPassword(env.getRequiredProperty("jdbc.password"));

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(webDataSource());
    }

//    @Bean





}

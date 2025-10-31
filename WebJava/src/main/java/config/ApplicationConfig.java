package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "controllers", "models", "services"/*, "dao"*/ })
@EnableWebMvc  // IMPORTANT
public class ApplicationConfig {


}

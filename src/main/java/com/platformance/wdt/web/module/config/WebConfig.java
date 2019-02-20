package com.platformance.wdt.web.module.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@MapperScan(value={"com.**.mapper"})
public class WebConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*")
                        .allowedOrigins("*")
                        .allowedMethods(HttpMethod.GET.name())
                        .allowCredentials(false)
                        .maxAge(3600);
            }
        };
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] arrResource = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/**/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(arrResource);
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

//  => webflux 사용시 작성법
//
//    @Bean
//    public WebFluxConfigurer webFluxConfigurer() {
//        return new WebFluxConfigurerComposite() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/message/**")
//                        .allowedOrigins("*")
//                        .allowedMethods(HttpMethod.POST.name())
//                        .allowCredentials(false)
//                        .maxAge(3600);
//            }
//        };
//    }
}
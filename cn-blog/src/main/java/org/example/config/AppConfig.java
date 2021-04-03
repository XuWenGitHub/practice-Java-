package org.example.config;

import org.example.config.web.RedirectLoginInterceptor;
import org.example.config.web.UnauthorizedInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api",c->true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //后端敏感接口拦截器：后端接口排除登录，注册，注销的其他接口都是敏感资源
//        registry.addInterceptor(new UnauthorizedInterceptor())
//                .addPathPatterns("/api/**")
//                .excludePathPatterns("/api/user/login")
//                .excludePathPatterns("/api/user/register")
//                .excludePathPatterns("/api/user/logout");

        //前端敏感资源拦截器
        registry.addInterceptor(new RedirectLoginInterceptor())
                .addPathPatterns("/views/my_articles.html")
                .addPathPatterns("/views/article.html");
    }
}

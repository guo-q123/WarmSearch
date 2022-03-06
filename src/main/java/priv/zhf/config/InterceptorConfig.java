package priv.zhf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import priv.zhf.utils.JWTInterceptor;

/**
 * JWT拦截器配置类
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                //设置拦截的路劲  其他接口保护
                .addPathPatterns("/p1111/**")
                //排除用户相关的路径  放行所有用户请求
                .excludePathPatterns("/pcuser/login")
                .excludePathPatterns("/pcuser/add")
                .excludePathPatterns("/pcuser/validate");
    }
}

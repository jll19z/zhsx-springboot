package com.ljl.zhsx.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author L.J.L
 * @QQ 963314043
 * @date 2022/7/13 13:02
 */
@Configuration
public class RequestInterceptor implements WebMvcConfigurer {

@Autowired
private StringRedisTemplate redisTemplate;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

                String token = request.getHeader("token");

                if(token != null &&redisTemplate.opsForValue().get(token) != null){
                    System.out.println("redis更新token时间");
                    redisTemplate.expire(token,30, TimeUnit.MINUTES);
                return true;
                }
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               // return false;
                return true; //测试接口时设置true
            }
        }).excludePathPatterns("/login").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");;
    }
}

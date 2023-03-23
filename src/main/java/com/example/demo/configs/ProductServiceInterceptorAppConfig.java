package com.example.demo.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ProductServiceInterceptorAppConfig implements WebMvcConfigurer {
   @Autowired
   LoggerInterceptor loggerInterceptor;
   @Autowired
   AuthorizeInterceptor authorizeInterceptor;
   @Autowired
   private GlobalInterceptor globalInterceptor;
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      String[] listPath = {"/user/logoff**","/user/change**","/user/edit**","/order/**"};
      registry.addInterceptor(loggerInterceptor
      
      )
      .addPathPatterns("/home/**")
      .excludePathPatterns("/home/contact")
      ;
      registry.addInterceptor(authorizeInterceptor)
      .addPathPatterns(Arrays.asList(listPath))
      ;
      registry.addInterceptor(globalInterceptor);
   }
}

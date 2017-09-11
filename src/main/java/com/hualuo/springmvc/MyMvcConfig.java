package com.hualuo.springmvc;

import com.hualuo.springmvc.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.hualuo.springmvc.interceptor.DemoInterceptor;

import java.util.List;

/**
 * @author Joseph
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.hualuo.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //Bean--------------------------------------------------------
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Bean
    public MyMessageConverter myMessageConverter() {
	    return new MyMessageConverter();
    }

    //重载方法----------------------------------------------------------------

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}

	/**
	 * 集中管理页面转向
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
		registry.addViewController("/converter").setViewName("/converter");
	}

    /**
     * 不忽略"."后的参数
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
	    configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * 注册自定义的HttpMessageConverter
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myMessageConverter());
    }
}

package com.ldh.express.interceptor;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Value("${ldh.dir}")
	private String dir;	//虚拟路径地址
	
	@Value("${ldh.dir_path}")
	private String dir_path;	//虚拟路径地址

	
	 
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
	
	@Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
	
	// 就是这个
    /*@Bean
    public HttpPutFormContentFilter httpPutFormContentFilter() {
        return new HttpPutFormContentFilter();
    }*/
	
	/**
	 * 配置虚拟路径
	 */
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("虚拟路径=====>" + dir);
		System.out.println("虚拟路径地址=====>" + dir_path);
        registry.addResourceHandler(dir).addResourceLocations(dir_path);  
        //super.addResourceHandlers(registry);
    }

}

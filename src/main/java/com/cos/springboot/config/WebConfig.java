package com.cos.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.cos.springboot.aop.SessionIntercepter;
// 이파일을 web.xml 파일을 자바 클래스 파일로 바꾼것과같다.
@Configuration      //IoC 하기 위해서 는 이거 꼭 써야함.
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${file.path}")
	private String fileRealPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		//파일 경로 인식하게 하기.
		registry.addResourceHandler("/media/**")
		.addResourceLocations("file:///"+fileRealPath)
		.setCachePeriod(3600)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter())
			.addPathPatterns("/user/profile/**")
			.addPathPatterns("/post/write/**")
			.addPathPatterns("/post/update/**")
			.addPathPatterns("/post/delete/**");   
			// 이 4가지 아이들은  addInterceptors 에서 다 낚아챈다.
		
		  // .addExcludePatterns()--> 제외 시킬때 사용한다.	
	}
}

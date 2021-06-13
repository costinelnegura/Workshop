package com.costinel.Workshop.config;

import com.costinel.Workshop.interceptor.HeaderInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.costinel.Workshop")
@EnableWebMvc
public class WorkshopMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public DataSource dataSource(){
		// this is a Spring MVC dataSourceLookup implementation,
		// of which is am creating an instance to use.
		final JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		// if this was to be set to false, then I would have to specify the full JNDI name.
		dataSourceLookup.setResourceRef(true);
		// "jdbc/workshop_db" is the JNDI name I have chosen in the context.xml in
		// applications/apache-tomcat-8.5.65/conf/context.xml
		// it is not the name of the exact database.
		DataSource dataSource = dataSourceLookup.getDataSource("jdbc/workshop_db");
		return dataSource;
	}

//	@Bean
//	public RequestMappingHandlerMapping requestMappingHandlerMapping(){
//		RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
//		// this is set true by default by Spring but i'm leaving this here in case
//		// I wish to play with this feature;
//		// suffix = true will match the url to the file even if the suffix is amended (ie. .htm .php)
//		rmhm.setUseSuffixPatternMatch(true);
//		// trail = true will match the url to the file even if a / is typed in the url
//		rmhm.setUseTrailingSlashMatch(true);
//		return rmhm;
//	}

	// this will set the default folder there the WorkshopMvcConfig will look for
	// the jsp files, setting the prefix and suffix;
	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/home/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	// this will pre-configure the app with a homepage as welcome.jsp
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("welcome");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HeaderInterceptor());
	}
}

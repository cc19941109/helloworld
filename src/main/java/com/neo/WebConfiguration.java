package com.neo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	//@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	/**
	 * 过滤器位于客户端和web应用程序之间，用于检查和修改两者之间流过的请求和响应。 在请求到达Servlet/JSP之前，过滤器截获请求。
	 * 在响应送给客户端之前，过滤器截获响应。
	 * 多个过滤器形成一个过滤器链，过滤器链中不同过滤器的先后顺序由部署文件web.xml中过滤器映射<filter-mapping>的顺序决定。
	 * 最先截获客户端请求的过滤器将最后截获Servlet/JSP的响应信息。
	 */
	@Bean
	public FilterRegistrationBean testFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/hello");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(1);
		return registration;
	}

	public class MyFilter implements Filter {
		@Override
		public void destroy() {
		}

		@Override
		public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
				throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) srequest;
			System.out.println("this is MyFilter,url :" + request.getRequestURI());
			// doFilter方法之前地方，request是可用的；在doFilter()方法之后response是可用的。
			filterChain.doFilter(srequest, sresponse);
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
		}
	}
}

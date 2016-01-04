package net.furikuri;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MicroZuulApplication.class).web(true).run(args);
	}
}

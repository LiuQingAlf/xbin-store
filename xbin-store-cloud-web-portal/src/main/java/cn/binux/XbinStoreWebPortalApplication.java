package cn.binux;

import cn.binux.utils.JedisClient;
import cn.binux.utils.impl.JedisClientSingle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = { "cn.binux" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "cn.binux.druid.*"))
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@Configuration
//@EnableApolloConfig
public class XbinStoreWebPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(XbinStoreWebPortalApplication.class, args);
	}

	@Bean
	public JedisClient jedisClient() {
		return new JedisClientSingle();
	}
}


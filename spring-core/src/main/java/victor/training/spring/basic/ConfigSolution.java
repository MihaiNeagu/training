package victor.training.spring.basic;

import java.util.Arrays;

import javax.sql.DataSource;

import org.hsqldb.jdbcDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import victor.training.spring.basic.service.CurrencyConverter;
import victor.training.spring.basic.service.CurrencyConverterHandshakeImpl;
import victor.training.spring.basic.service.CurrencyConverterStatelessImpl;
import victor.training.spring.basic.service.HRService;
import victor.training.spring.basic.service.MyWSClient;

@Configuration
@PropertySource("classpath:/config-basic.properties")
@ComponentScan(basePackages="victor")
public class ConfigSolution {

	@Autowired
	private Environment env;
	
	@Bean
	public HRService hrService() {
		HRService service = new HRService();
		service.setWebServiceClient(webServiceClient());
		service.setMyProperty(env.getProperty("myProperty"));
		return service;
	}
	
	@Bean
	public MyWSClient webServiceClient() {
		MyWSClient client = MyWSClient.getInstance();
		client.setEndpointURLs(Arrays.asList("http://ro.ibm.com/myws", "http://localhost:8080/myws"));
		return client;
	}
	
	@Bean
	public CurrencyConverter handshakeConverter() {
		return new CurrencyConverterHandshakeImpl();
	}
	
	@Bean
	public CurrencyConverter statelessConverter() {
		return new CurrencyConverterStatelessImpl();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(jdbcDriver.class.getCanonicalName());
		dataSource.setUrl("jdbc:hsqldb:file:hr-database");
		dataSource.setUsername("SA");
		return dataSource;
	}
	
}

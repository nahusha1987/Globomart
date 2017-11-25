/**
 * 
 */
package com.globomart.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.web.client.RestTemplate;

import com.globomart.controller.PricingController;
import com.globomart.dao.PricingDAO;
import com.globomart.dao.PricingDAOImpl;
import com.globomart.service.PricingService;
import com.globomart.service.PricingServiceImpl;

/**
 * @author nahusha
 *
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public PricingController pricingController(final PricingService pricingService) {
		return new PricingController(pricingService);
	}

	@Bean
	public PricingService pricingService(final PricingDAO pricingDao) {
		return new PricingServiceImpl(pricingDao);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
				.addScript("create-db.sql").addScript("insert-data.sql").build();
		return embeddedDatabase;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PricingDAO pricingDao(final JdbcTemplate jdbcTemplate) {
		return new PricingDAOImpl(jdbcTemplate);
	}

}

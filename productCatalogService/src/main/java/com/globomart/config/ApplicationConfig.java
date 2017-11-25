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

import com.globomart.controller.ProductController;
import com.globomart.dao.ProductDAO;
import com.globomart.dao.ProductDAOImpl;
import com.globomart.service.ProductService;
import com.globomart.service.ProductServiceImpl;

/**
 * @author nahusha
 *
 */
@Configuration
public class ApplicationConfig {
	
	@Bean
    public ProductService productService(final ProductDAO ProductDao) {
        return new ProductServiceImpl(ProductDao);
    }

    @Bean
    public ProductController productController(final ProductService productService) {
        return new ProductController(productService);
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
    public ProductDAO productDAO(final JdbcTemplate jdbcTemplate) {
        return new ProductDAOImpl(jdbcTemplate);
    }
}

/**
 * 
 */
package com.globomart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.globomart.dto.Price;

/**
 * @author nahusha
 *
 */
public class PricingDAOImpl implements PricingDAO {
	 private JdbcTemplate jdbcTemplate;

	    public PricingDAOImpl(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    @Override
	    public Price findByProductId(Long id) {
	        return jdbcTemplate.queryForObject("select * from price where productId = ?",
	                new RowMapper<Price>() {
	                    @Override
	                    public Price mapRow(ResultSet resultSet, int i) throws SQLException {
	                        Price price = new Price();
	                        price.setId(resultSet.getLong("id"));
	                        price.setPrice(resultSet.getDouble("price"));
	                        price.setProductId(resultSet.getLong("productId"));
	                        return price;
	                    }
	                }, id);
	    }
}

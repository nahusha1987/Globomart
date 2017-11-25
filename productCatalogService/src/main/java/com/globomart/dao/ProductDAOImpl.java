/**
 * 
 */
package com.globomart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.globomart.dto.ProductDto;

/**
 * @author nahusha
 *
 */
public class ProductDAOImpl implements ProductDAO {

	private JdbcTemplate jdbcTemplate;

	public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	@Override
	public List<ProductDto> findByTypeAndName(String type, String name) {
		return jdbcTemplate.query("select * from product where type=? and name =? ", productDtoRowMapper, type, name);
	}

	@Override
	public List<ProductDto> findByType(String type) {
		return jdbcTemplate.query("select * from product where type=?", productDtoRowMapper, type);
	}

	@Override
	public List<ProductDto> findAll() {
		return jdbcTemplate.query("select * from product", productDtoRowMapper);
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update("delete from product where id= ?", id);

	}

	@Override
	public void save(ProductDto productDto) {
		jdbcTemplate.update("insert into product values (?,?,?)", productDto.getId(), productDto.getName(),
				productDto.getType());
	}

	private RowMapper<ProductDto> productDtoRowMapper = new RowMapper<ProductDto>() {
		@Override
		public ProductDto mapRow(ResultSet resultSet, int i) throws SQLException {
			ProductDto productDto = new ProductDto();
			productDto.setId(resultSet.getLong("id"));
			productDto.setName(resultSet.getString("name"));
			productDto.setType(resultSet.getString("type"));
			return productDto;
		}
	};
}

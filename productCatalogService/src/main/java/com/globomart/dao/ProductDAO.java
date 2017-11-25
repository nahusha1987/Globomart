/**
 * 
 */
package com.globomart.dao;

import java.util.List;

import com.globomart.dto.ProductDto;

/**
 * @author nahusha
 *
 */
public interface ProductDAO {
	List<ProductDto> findByTypeAndName(String type, String name);

	List<ProductDto> findByType(String type);

	List<ProductDto> findAll();

	void delete(long id);

	void save(ProductDto ProductDto);
}

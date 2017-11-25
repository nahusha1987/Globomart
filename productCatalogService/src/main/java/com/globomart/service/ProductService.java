/**
 * 
 */
package com.globomart.service;

import java.util.List;

import com.globomart.dto.ProductDto;

/**
 * @author nahusha
 *
 */
public interface ProductService {
	void addProduct(ProductDto productVo);

    List<ProductDto> getProducts();

    void deleteProduct(Long id);

    List<ProductDto> getProductsByTypeAndName(String type, String name);

    List<ProductDto> getProductsByType(String type);
}

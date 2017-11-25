/**
 * 
 */
package com.globomart.service;

import java.util.List;

import com.globomart.dao.ProductDAO;
import com.globomart.dto.ProductDto;

/**
 * @author nahusha
 *
 */
public class ProductServiceImpl implements ProductService {
	private final ProductDAO productDao;

    public ProductServiceImpl(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(ProductDto productVo) {
        final ProductDto ProductDto = new ProductDto();
        ProductDto.setName(productVo.getName());
        ProductDto.setType(productVo.getType());
        productDao.save(ProductDto);
    }

    @Override
    public List<ProductDto> getProducts() {
        return productDao.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

    @Override
    public List<ProductDto> getProductsByTypeAndName(String type, String name) {
        return productDao.findByTypeAndName(type, name);
    }

    @Override
    public List<ProductDto> getProductsByType(String type) {
        return productDao.findByType(type);
    }
}

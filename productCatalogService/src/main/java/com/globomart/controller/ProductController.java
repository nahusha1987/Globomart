/**
 * 
 */
package com.globomart.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.dto.ProductDto;
import com.globomart.service.ProductService;

/**
 * @author nahusha
 *
 */

@RestController
@RequestMapping(value = "/productCatalogService/products")
public class ProductController {
	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduct(@RequestBody final ProductDto productVo) {
        productService.addProduct(productVo);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductsByTypeAndName(@RequestParam(value = "type", required = false) final String type, @RequestParam(value = "name", required = false) final String name) {
        return productService.getProductsByTypeAndName(type, name);
    }

    @RequestMapping(value = "/searchByType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductsByTypeAndName(@RequestParam(value = "type", required = false) final String type) {
        return productService.getProductsByType(type);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct(@PathVariable final Long id) {
        productService.deleteProduct(id);
    }
}

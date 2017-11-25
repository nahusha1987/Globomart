/**
 * 
 */
package com.globomart.service;

import java.util.List;

import com.globomart.dto.ProductDTO;

/**
 * @author nahusha
 *
 */
public interface PricingService {

	String getPrice(List<ProductDTO> productVos);

}

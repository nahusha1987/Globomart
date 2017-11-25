/**
 * 
 */
package com.globomart.dao;

import com.globomart.dto.Price;

/**
 * @author nahusha
 *
 */
public interface PricingDAO {
	Price findByProductId(Long id);
}

/**
 * 
 */
package com.globomart.service;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.globomart.dao.PricingDAO;
import com.globomart.dto.Price;
import com.globomart.dto.ProductDTO;


/**
 * @author nahusha
 *
 */
public class PricingServiceImpl implements PricingService {
	
	 public static final String NO_PRODUCT_FOUND = "No Product Found";
	    private final PricingDAO pricingDao;

	    public PricingServiceImpl(PricingDAO pricingDao) {
	        this.pricingDao = pricingDao;
	    }

	    @Override
	    public String getPrice(final List<ProductDTO> productVos) {
	        if (CollectionUtils.isEmpty(productVos)) {
	            return NO_PRODUCT_FOUND;
	        }
	        ProductDTO productVo = productVos.get(0);
	        final Price price = pricingDao.findByProductId(productVo.getId());
	        return price == null ? NO_PRODUCT_FOUND : price.getPrice() == null ? NO_PRODUCT_FOUND : price.getPrice().toString();
	    }

}

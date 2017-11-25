/**
 * 
 */
package com.globomart.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.globomart.dao.PricingDAO;
import com.globomart.dto.Price;
import com.globomart.dto.ProductDTO;

/**
 * @author nahusha
 *
 */
public class PricingServiceImplTest {
	@Mock
    private PricingDAO pricingDao;
    private PricingService pricingService;
    private List<ProductDTO> productDtos;
    private Price price;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pricingService = new PricingServiceImpl(pricingDao);
        productDtos = new ArrayList<>();
        ProductDTO productDto = new ProductDTO();
        productDto.setId(1L);
        productDto.setName("BMW");
        productDto.setType("car");
        productDtos.add(productDto);
        price = new Price();
        price.setId(1L);
        price.setProductId(1L);
        price.setPrice(220.3D);
    }

    @Test
    public void testGetPrice() {
        Mockito.doReturn(price).when(pricingDao).findByProductId(Mockito.anyLong());
        String output = pricingService.getPrice(productDtos);
        Assert.assertTrue(output.equalsIgnoreCase(price.getPrice().toString()));
    }

    @Test
    public void testGetPriceForNoProductFound() {
        String output = pricingService.getPrice(null);
        Assert.assertTrue(output.equalsIgnoreCase(PricingServiceImpl.NO_PRODUCT_FOUND));
    }
}

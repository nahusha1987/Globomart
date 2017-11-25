
package com.globomart.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.globomart.dto.ProductDTO;
import com.globomart.service.PricingService;

/**
 * @author nahusha
 *
 */
@RestController
@RequestMapping("/pricingService/products/price")
public class PricingController {

    private final PricingService pricingService;
    // CATALOG URL HARDCODED
    private final String CATALOG_SERVICE_URL = "http://localhost:8003/productCatalogService";
    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPrice(@RequestParam(value = "name", required = true) final String name, @RequestParam(value = "type", required = true) final String type) {
        URI uri = null;
		try {
			uri = new URI(CATALOG_SERVICE_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
    	String url = uri.toString() + "/products/search?name=" + name + "&type=" + type;
        ProductDTO[] productDtos = (new RestTemplate()).getForObject(url, ProductDTO[].class);
        return pricingService.getPrice(Arrays.asList(productDtos));
    }

}
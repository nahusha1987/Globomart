/**
 * 
 */
package com.globomart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author nahusha
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PricingServiceApplication.class)
@WebAppConfiguration
public class PricingServiceApplicationTest {

	@Test
	public void contextLoads() {
	}

}

package com.it.java8demo.ceshi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @CLassName PowerBaseUnitTest
 * @Description: TODO
 * @date: 2020/11/6 9:57
 * @Version 1.0
 */

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@PowerMockIgnore({"javax.crypto.*","javax.management.*","javax.security.*"})
@WebAppConfiguration
//@ContextConfiguration(classes=WebMockConfig.class,initializers = {DubboRegistryInitializer.class,
//		DefaultApplicationContextInitializer.class,MockAppContextIntializer.class})
public class PowerBaseUnitTest {
	protected final Logger logger= LoggerFactory.getLogger(getClass());
	@Autowired
	private WebApplicationContext context;
	@Autowired
//	private   ICacheService cacheService;
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc(){mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public  void testDemo() throws Exception{}
}

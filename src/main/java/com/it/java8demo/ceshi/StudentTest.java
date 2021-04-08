package com.it.java8demo.ceshi;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.powermock.configuration.ConfigurationType.PowerMock;

/**
 * @CLassName StudentTest
 * @Description: TODO
 * @date: 2020/11/6 14:04
 * @Version 1.0
 */
@PrepareForTest(Student.class)//静态方法需导入该class
public class StudentTest extends  PowerBaseUnitTest {


	@InjectMocks
	private Student student;
//	@Mock
//	private StudentService studentService;

//	/**
//	 * 注入Student中的通过Value注入的变量值
//	 * @throws Exception
//	 */
//	@Before
//	public void setUp() throws Exception{
//		ReflectionTestUtils.setField(student,"url","url");
//	}
//	@Test
//	public void testDemo() throws Exception{
//		PowerMockito.mockStatic(Student.class);
//		PowerMockito.when(Student.method(Mockito.any())).thenReturn();
//
//	}

}

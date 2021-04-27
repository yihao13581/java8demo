//package com.cmos.isccmp.web.config;
//
///**
// * @CLassName SwaggerConfig
// * @Description: Swagger基础配置
// * @date: 2020/7/21 17:25
// * @Version 1.0
// */
//@Configuration
//@EnabledSwaggerCondition
//public class SwaggerConfig {
//	@Bean
//	public Decket configSpringfoxDocketForALL(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.appInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage(com.cmos.isccmp))
//				.paths(PathSelectors.any())
//				.build();
//	}
//	private ApiInfo apiInfo(){
//		return new ApiInfoBuilder()
//				.title("isccmp REST API文档")
//				.description("使用Swagger UI构建SpringMVC Rest风格的可视化文档")
//				.termsOfServiceUrl("http://127.0.0.1:18080/swagger-ui.html")
//				.contact(new Contact("itframe","http://192.168.100.9:8090/pages/viewpage.action?pageId=3116125","dangshixu@cmos.chinamobile.com"))
//				.version("1.0.0-SNAPSHOT")
//				.build();
//	}
//}

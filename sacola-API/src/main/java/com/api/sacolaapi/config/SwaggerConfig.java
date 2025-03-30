package com.api.sacolaapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.api.sacolaapi.controllers"))
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Sacola API")
        .description("API desenvolvida durante o ifood dev week")
        .version("v1")
        .contact(contact())
        .build();
  }

  private Contact contact() {
    return new Contact(
        "Anderson Porto",
        "https://www.linkedin.com/in/andersonhsporto/",
        "anderson.higo2@gmail.com");
  }

}

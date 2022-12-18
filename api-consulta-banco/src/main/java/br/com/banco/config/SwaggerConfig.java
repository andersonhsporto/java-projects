package br.com.banco.config;

import br.com.banco.domain.DTO.AccountDTO;
import br.com.banco.domain.DTO.TransferDTO;
import com.fasterxml.classmate.TypeResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

  private final TypeResolver typeResolver;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .paths(PathSelectors.any())
        .build()
        .additionalModels(
            typeResolver.resolve(AccountDTO.class),
            typeResolver.resolve(TransferDTO.class))
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Banco API")
        .description("Api para simular operações de transferencia entre contas")
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

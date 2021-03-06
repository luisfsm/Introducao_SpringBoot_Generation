package br.org.generation.blogpessoal.configuration;
 

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
   
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.org.generation.blogpessoal.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metadata()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessage()).globalResponses(HttpMethod.POST, responseMessage())
				.globalResponses(HttpMethod.PUT, responseMessage())
				.globalResponses(HttpMethod.DELETE, responseMessage());

	}

	public static ApiInfo metadata() {
		return new ApiInfoBuilder()
					.title("API - BLOG PESSOAL")
					.description("Projeto API SPRING - Blog Pessoal")
					.version("1.0.0").license("Apache License Version 2.0")
					.licenseUrl("https://github.com/luisfsm")
					.contact((Contact) contact()).build();

	}

	private static List<Contact> contact() {
		List<Contact> lista = new ArrayList<>();
		//return new Contact("Luis Felipe", "https://github.com/luisfsm", "luis.s.mendes20@gmail.com");
		lista.add(new Contact("Luis Felipe", "https://github.com/luisfsm", "luis.s.mendes20@gmail.com"));
		return lista;
	}

	private static List<Response> responseMessage() {
		return new ArrayList<Response>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Sucesso!").build());
				add(new ResponseBuilder().code("201").description("Criado!").build());
				add(new ResponseBuilder().code("400").description("Erro na requisi????o!").build());
				add(new ResponseBuilder().code("401").description("N??o Autorizado!").build());
				add(new ResponseBuilder().code("403").description("Proibido!").build());
				add(new ResponseBuilder().code("404").description("N??o Encontrado!").build());
				add(new ResponseBuilder().code("500").description("Erro!").build());
			}
		};
	}

}

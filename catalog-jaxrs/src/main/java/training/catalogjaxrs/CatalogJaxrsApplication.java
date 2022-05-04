package training.catalogjaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatalogJaxrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogJaxrsApplication.class, args);
	}

	@Bean
	public ResourceConfig config() {
		var config = new ResourceConfig();
		var service = new BookService();
		service.init();
		config.register(new BookResource(service));
		return config;
	}

}

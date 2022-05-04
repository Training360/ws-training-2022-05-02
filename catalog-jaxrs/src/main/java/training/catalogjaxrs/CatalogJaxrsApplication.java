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
		config.register(new BookResource());
		return config;
	}

}

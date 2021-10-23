package ZNueva_Tienda_FrontEnd2.ZNueva_Tienda_FrontEnd2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class ZNuevaTiendaFrontEnd2Configuration {
	private static final String URL = "http://localhost:8080";
	
	@Bean
    public WebClient myWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "APPLICATION_JSON")
                .defaultHeader(HttpHeaders.USER_AGENT, "TiendaVirtualFrontEnd")
                .build();
    }

}

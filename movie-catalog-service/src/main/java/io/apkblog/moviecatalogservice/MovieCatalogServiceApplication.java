package io.apkblog.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogServiceApplication {

	//This is created because any method want to create restTemplate can call it from here. if we are creating every c
	//class mehod than it will create restTemplate every time we run that mathod. to avoid that we are creating seperate
	@Bean
	@LoadBalanced // it does service discovery in load balnce way. //it will look for hint to find the url
	public RestTemplate restTemplate(){ 
		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder  getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}

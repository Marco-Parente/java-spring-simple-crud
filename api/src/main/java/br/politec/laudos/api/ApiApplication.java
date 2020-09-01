package br.politec.laudos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.politec.laudos.api.Index"})
public class ApiApplication {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(ApiApplication.class, args);
    }

}

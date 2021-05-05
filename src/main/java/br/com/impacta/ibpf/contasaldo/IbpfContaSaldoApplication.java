package br.com.impacta.ibpf.contasaldo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class IbpfContaSaldoApplication {

	public static void main(String[] args) {

		SpringApplication.run(IbpfContaSaldoApplication.class, args);
	}

}

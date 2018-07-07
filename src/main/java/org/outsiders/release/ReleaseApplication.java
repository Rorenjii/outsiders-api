package org.outsiders.release;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ReleaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReleaseApplication.class, args);
	}
}

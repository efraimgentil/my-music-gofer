package me.efraimgentil.mymusic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class GoferApplication {

	@Bean
	@Qualifier(value = "config")
	public Properties configProperties() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "/../finder.properties"));
		return properties;
	}

	@Bean
	@Qualifier("baseFolder")
	public String baseFolder( @Qualifier("config") Properties properties){
		return properties.getProperty("baseFolder");
	}


	public static void main(String[] args) {
		SpringApplication.run(GoferApplication.class, args);
	}

}

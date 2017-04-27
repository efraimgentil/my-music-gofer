package me.efraimgentil.mymusic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
@PropertySource("file://${user.dir}/../finder.properties")
public class GoferApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoferApplication.class, args);
	}

}

package me.efraimgentil.mymusic.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by efraimgentil on 01/02/17.
 */
@Configuration
@EnableJpaRepositories( basePackages ="me.efraimgentil.mymusic.repository" )
@EntityScan(basePackages =  "me.efraimgentil.mymusic.model")
public class JpaConfig {

}

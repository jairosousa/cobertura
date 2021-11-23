package io.jnsdev.cobertura.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:32
 */
@Configuration
@ComponentScan(basePackages = "io.jnsdev.cobertura")
@EnableJpaRepositories(value = "io.jnsdev.cobertura.repository")
@EntityScan(value = "io.jnsdev.cobertura.model")
public class MyHateoasExampleCommonConfig {
}

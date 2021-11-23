package io.jnsdev.cobertura;

import io.jnsdev.cobertura.config.MyHateoasExampleCommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:30
 */
@SpringBootApplication
@Import(value = {MyHateoasExampleCommonConfig.class})
public class CoberturaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoberturaApplication.class, args);
    }
}

package com.example.featureflagservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class FeatureFlagServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureFlagServiceApplication.class, args);
    }

    @Bean
    public String printEnvironment(
            Environment environment,
            @Value("${features.configuration.profile}") String configurationProfile,
            @Value("${features.configuration.file}") String configurationFile
    ) {
        System.out.println(configurationProfile);
        System.out.println(configurationFile);

        System.out.print("DEFAULT PROFILES: ");
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));

        System.out.print("ACTIVE PROFILES: ");
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        return null;
    }

}

package com.Ekartdrools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    private final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        return kieServices.getKieClasspathContainer();
    }

    @Bean
    public KieSession kieSession() {
        KieContainer kieContainer = kieContainer();
        if (kieContainer == null) {
            throw new IllegalStateException("KieContainer is null. Cannot create KieSession.");
        }
        return kieContainer.newKieSession();
    }
}

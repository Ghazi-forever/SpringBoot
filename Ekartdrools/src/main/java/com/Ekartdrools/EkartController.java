package com.Ekartdrools;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EkartController {

    @Autowired
    private KieSession kieSession;

    @PostMapping("/processEkart")
    public Ekart processEkart(@RequestBody Ekart ekart) {
        kieSession.insert(ekart);
        kieSession.fireAllRules();
        return ekart;
    }
}

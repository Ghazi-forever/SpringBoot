package com.Drools.controllor;


import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Drools.modal.ekart;

@RestController
public class ekartControllor {

    @Autowired
    private KieSession session;

    @PostMapping("/process") // Adjust the endpoint URL as required
    public ekart post(@RequestBody ekart kart) {
        if (session == null) {
            // Handle the case where session is null (optional)
        } else {
            session.insert(kart);
            session.fireAllRules();
        }
        return kart;
    }
}

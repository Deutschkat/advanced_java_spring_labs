package platform.codingnomads.co.springtest.usingtestresttemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;
import platform.codingnomads.co.springtest.usingtestresttemplate.services.CoffeePreferenceService;

@Controller
@RequestMapping("/coffee")
public class CoffeePreferenceController {

    @Autowired
    CoffeePreferenceService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCoffeePreference(@PathVariable Long id) {
        try {
            CoffeePreference preference = service.getCoffeePreference(id);
            if (preference != null) {
                return ResponseEntity.ok(preference);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Exception(e.getMessage()));
        }
    }



    @PostMapping
    public ResponseEntity<?> postNewCoffeePreference(@RequestBody CoffeePreference coffeePreference) {
        try {
            CoffeePreference preference = service.insertNewCoffeePreference(coffeePreference);
            return ResponseEntity.ok().header("Location", "http://www.url.com/new/location").body(preference);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Exception(e.getMessage()));
        }
    }
}

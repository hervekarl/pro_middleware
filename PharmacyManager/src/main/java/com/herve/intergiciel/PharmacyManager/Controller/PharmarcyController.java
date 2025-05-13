package com.herve.intergiciel.PharmacyManager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pharmacy")
public class PharmarcyController {

    @GetMapping("/products")
    public String getProducts() {
        return "Liste des produits";
    }

}

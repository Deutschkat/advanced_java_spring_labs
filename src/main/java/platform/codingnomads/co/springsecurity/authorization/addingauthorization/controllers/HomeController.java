package platform.codingnomads.co.springsecurity.authorization.addingauthorization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.repositories.UserPrincipalRepo;
import platform.codingnomads.co.springsecurity.authorization.addingauthorization.services.CustomUserService;


import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CustomUserService customUserService;

    @GetMapping("/")
    public String homePage() {
        return "authorization/home";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "authorization/admin";
    }

    @GetMapping("/superu")
    public String superUPage() {
        return "authorization/superu";
    }

    @GetMapping("/mas")
    public String testMas(int id){
        return "authorization/mas";
    }


    @RolesAllowed("SUPERUSER")
    @RequestMapping("/superuSettings")
    public String superuSettings(){
        return "authorization/superuSettings";
    }

    @GetMapping("/superuProfile")
    @PreAuthorize("hasRole('SUPERU')")
    public String superuProfile() {
        return "authorization/superuProfile";
    }

    @PostAuthorize("returnObject == 'superuDashboard.html'")
    @RequestMapping("/superuDashboard")
    public String superuDashboard() {
        return "authorization/superuProfile";
    }



    /*
        Method Security Annotations

        @RolesAllowed("USER")
        @PreAuthorize("#id != 1")
        @PostAuthorize("returnObject.ownerUsername == authentication.principal.username")
        @PreFilter(value = "filterObject != shutdown", filterTarget = "commands")
        @PostFilter("filterObject.id <= 20")
     */
}
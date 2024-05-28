package com.intro.storecoffe.badge;

import com.intro.storecoffe.coffee.Coffee;
import com.intro.storecoffe.coffee.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //return json
@RequestMapping("/api/v1/badge") //http://localhost:8080/api/v1/badge
@RequiredArgsConstructor

public class BadgeController {
    @Autowired
    private BadgeService badgeservice;


    @GetMapping("/get/all") //http://localhost:8080/api/v1/badge/get/all
    public ResponseEntity<List<Badge>> getAll(){
        List<Badge> badges = badgeservice.getAll();
        return new ResponseEntity<>(badges, HttpStatus.OK);
    }


    @GetMapping("/{id}") //http://localhost:8080/api/v1/badge/get/id
    public Badge getBadgeById(@PathVariable("id") Long id) {
        return badgeservice.getBadgeById(id);

    }
    @PostMapping("/add") //http://localhost:8080/api/v1/badge/add
    public Badge addBadge(@RequestBody Badge badge){
        return  badgeservice.addBadge(badge);
    }

    @PutMapping("/update/{id}") //http://localhost:8080/api/v1/badge/update/id
    public Badge updateBadge(@RequestBody Badge badge, @PathVariable("id") Long id) {
        return badgeservice.updateBadge(badge, id);
    }

    @DeleteMapping("/delete/{id}") //http://localhost:8080/api/v1/badge/delete/id
    public void deleteBadge(@PathVariable("id") Long id) {
        badgeservice.deleteBadge(id);
    }

    //je ne comprend pas
    @PutMapping("/update") //http://localhost:8080/api/v1/badge/update
    public Badge updateBadge(@RequestBody Badge badge) {
        return badgeservice.updateBadge2(badge);
    }

}

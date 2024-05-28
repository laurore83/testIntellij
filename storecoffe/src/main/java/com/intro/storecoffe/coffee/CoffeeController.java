package com.intro.storecoffe.coffee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //return json
@RequestMapping("/api/v1/coffee") //http://localhost:8080/api/v1/coffee
@RequiredArgsConstructor

public class CoffeeController {
    @Autowired
    private CoffeeService service;

    @GetMapping("/get/all") //http://localhost:8080/api/v1/coffee/get/all
    public ResponseEntity<List<Coffee>> getAll(){
      List<Coffee> coffees = service.getAll();
    return new ResponseEntity<>(coffees, HttpStatus.OK);
}

    @GetMapping("/{id}") //http://localhost:8080/api/v1/coffee/get/id
    public Coffee getCoffeeById(@PathVariable("id") Long id) {
        return service.getCoffeeById(id);
    }


@PostMapping("/add") //http://localhost:8080/api/v1/coffee/add
public Coffee addCoffee(@RequestBody Coffee coffee){
        return  service.addCoffee(coffee);
}


    @PutMapping("/update/{id}") //http://localhost:8080/api/v1/coffee/update/id
    public Coffee updateCoffee(@RequestBody Coffee coffee, @PathVariable("id") Long id) {
        return service.updateCoffee(coffee, id);
    }


    @DeleteMapping("/delete/{id}") //http://localhost:8080/api/v1/coffee/delete/id
    public void deleteCoffee(@PathVariable("id") Long id) {
        service.deleteCoffee(id);
    }

    //je ne comprend pas
    @PutMapping("/update") //http://localhost:8080/api/v1/coffee/update
    public Coffee updateCoffee(@RequestBody Coffee coffee) {
        return service.updateCoffee2(coffee);
    }



}
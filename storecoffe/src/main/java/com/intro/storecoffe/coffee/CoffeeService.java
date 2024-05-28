package com.intro.storecoffe.coffee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    @Autowired
    private CoffeeRepository repository;

    public List<Coffee> getAll(){
        return repository.findAll();
    }

    public Coffee addCoffee(Coffee coffee) {
        return repository.save(coffee);
    }

    public Coffee getCoffeeById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Coffee updateCoffee(Coffee coffee,Long id){
        Coffee foundCoffee = getCoffeeById(id);
        foundCoffee.setName(coffee.getName());
        foundCoffee.setPrice(coffee.getPrice());
        return repository.save(foundCoffee);
    }

    public Coffee updateCoffee2(Coffee coffee) {
        return repository.save(coffee);
    }

    public void deleteCoffee( Long id){
        repository.deleteById(id);
    }

}

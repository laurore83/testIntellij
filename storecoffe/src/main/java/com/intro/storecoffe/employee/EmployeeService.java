package com.intro.storecoffe.employee;

import com.intro.storecoffe.badge.Badge;
import com.intro.storecoffe.badge.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAll(){
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee,Long id){
        Employee foundEmployee = getEmployeeById(id);
        foundEmployee.setName(employee.getName());
        return repository.save(foundEmployee);
    }


    public void deleteEmployee( Long id){
        repository.deleteById(id);
    }

    public Employee updateEmployee2(Employee employee) {
        return repository.save(employee);
    }
}


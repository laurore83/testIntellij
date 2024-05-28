package com.intro.storecoffe.employee;

import com.intro.storecoffe.employee.Employee;
import com.intro.storecoffe.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //return json
@RequestMapping("/api/v1/employee") //http://localhost:8080/api/v1/employee
@RequiredArgsConstructor

public class EmployeeController {
    @Autowired
    private EmployeeService employeeservice;


    @GetMapping("/get/all") //http://localhost:8080/api/v1/employee/get/all
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = employeeservice.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/{id}") //http://localhost:8080/api/v1/employee/get/id
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeservice.getEmployeeById(id);

    }
    @PostMapping("/add") //http://localhost:8080/api/v1/employee/add
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeservice.addEmployee(employee);
    }

    @PutMapping("/update/{id}") //http://localhost:8080/api/v1/employee/update/id
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
        return employeeservice.updateEmployee(employee, id);
    }

    @DeleteMapping("/delete/{id}") //http://localhost:8080/api/v1/employee/delete/id
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeservice.deleteEmployee(id);
    }

    //je ne comprend pas
    @PutMapping("/update") //http://localhost:8080/api/v1/employee/update
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeservice.updateEmployee2(employee);
    }

}
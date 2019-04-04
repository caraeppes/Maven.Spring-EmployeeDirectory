package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/API")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employees/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee e){
        return new ResponseEntity<>(employeeService.create(e), HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Integer id){
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/employees/")
    public ResponseEntity<Iterable<Employee>> findAllEmployees(){
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }


    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee){
        return new ResponseEntity<>(employeeService.updateEmployee(id, updatedEmployee), HttpStatus.OK);
    }

    @PutMapping(value = "/employees/{id}/updateManager")
    public ResponseEntity<Employee> updateManager(@PathVariable Integer id, @RequestParam Integer managerId){
        return new ResponseEntity<>(employeeService.updateManager(id, managerId), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Integer id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id), HttpStatus.NOT_FOUND);
    }

}

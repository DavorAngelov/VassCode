package org.example.backendvass.controller;


import org.example.backendvass.model.Employee;
import org.example.backendvass.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor

@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }



    //byy idd
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }


    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee
    ) {
        return employeeService.updateEmployee(id, employee);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam String query
    ) {
        return employeeService.searchEmployees(query);
    }


}





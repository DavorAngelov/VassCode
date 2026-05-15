package org.example.backendvass.service;

import lombok.RequiredArgsConstructor;
import org.example.backendvass.model.Employee;
import org.example.backendvass.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();

    }

    public Employee createEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }

    public Employee getEmployee(Long id) {

        return employeeRepository.findById(id)

                .orElseThrow(() -> new RuntimeException(" not found"));

    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee employee = getEmployee(id);

        employee.setName(updatedEmployee.getName());

        employee.setRole(updatedEmployee.getRole());

        employee.setDepartment(updatedEmployee.getDepartment());

        employee.setEmail(updatedEmployee.getEmail());

        employee.setImage(updatedEmployee.getImage());


        return employeeRepository.save(employee);

    }

    public void deleteEmployee(Long id) {

        employeeRepository.deleteById(id);

    }

    public List<Employee> searchEmployees(String keyword) {

        return employeeRepository.findByNameContainingIgnoreCase(keyword);

    }

    public List<Employee> getByDepartment(String department) {

        return employeeRepository.findByDepartment(department);

    }

}
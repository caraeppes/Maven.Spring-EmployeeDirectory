package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateManager(Integer employeeId, Integer managerId) {
        Employee original = employeeRepository.findOne(employeeId);
        original.setManagerId(managerId);
        return employeeRepository.save(original);
    }

    public Employee updateEmployee(Integer employeeIdToUpdate, Employee updatedEmployee) {
        Employee original = employeeRepository.findOne(employeeIdToUpdate);
        original.setFirstName(updatedEmployee.getFirstName());
        original.setLastName(updatedEmployee.getLastName());
        original.setTitle(updatedEmployee.getTitle());
        original.setPhoneNumber(updatedEmployee.getPhoneNumber());
        original.setEmail(updatedEmployee.getEmail());
        original.setHireDate(updatedEmployee.getHireDate());
        original.setManagerId(updatedEmployee.getManagerId());
        original.setDepartmentNumber(updatedEmployee.getDepartmentNumber());
        return employeeRepository.save(original);
    }


    public Employee findEmployeeById(Integer employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Boolean deleteEmployee(Integer id) {
        employeeRepository.delete(id);
        return true;
    }


}

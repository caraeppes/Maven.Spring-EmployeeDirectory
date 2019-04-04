package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.entities.Department;
import io.zipcoder.persistenceapp.entities.Employee;
import io.zipcoder.persistenceapp.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department){
        return departmentRepository.save(department);
    }

    public Department findDepartment(Integer id){
        return departmentRepository.findOne(id);
    }

    public Iterable<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department updateManager(Integer departmentNumber, Employee manager){
        Department original = departmentRepository.findOne(departmentNumber);
        original.setManager(manager);
        return departmentRepository.save(original);
    }

    public Department updateName(Integer departmentNumber, String name){
        Department original = departmentRepository.findOne(departmentNumber);
        original.setName(name);
        return departmentRepository.save(original);
    }

    public Boolean deleteDepartment(Integer id){
        departmentRepository.delete(id);
        return true;
    }

}

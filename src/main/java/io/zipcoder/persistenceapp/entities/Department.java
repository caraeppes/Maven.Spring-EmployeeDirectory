package io.zipcoder.persistenceapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentNumber;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Employee manager;


    public Integer getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Integer departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}

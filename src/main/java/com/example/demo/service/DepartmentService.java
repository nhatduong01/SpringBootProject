package com.example.demo.service;


import com.example.demo.Error.DepartmentNotFoundException;
import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentBYID(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentBYID(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String name);

    Department fetchDepartmentByAddress(String address);
}

package com.example.demo.service;


import com.example.demo.Error.DepartmentNotFoundException;
import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentBYID(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentBYID(Long id);

    Department updateDepartment(Long id, Department department);

    Department fetchDepartmentByName(String name);

    Department fetchDepartmentByAddress(String address);
}

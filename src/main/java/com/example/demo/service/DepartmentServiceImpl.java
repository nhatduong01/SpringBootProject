package com.example.demo.service;

import com.example.demo.Error.DepartmentNotFoundException;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
        // If you have a different entity at client side
        // you have to do further stuff to convert
    }

    @Override
    public Department fetchDepartmentBYID(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department with ID " + id + " is not available");
        }
        return  department.get();
    }

    @Override
    public void deleteDepartmentBYID(Long id) {
        boolean isExist = departmentRepository.existsById(id);
        if(!isExist)
        {
            throw  new IllegalStateException("Department with ID " + id + " does not exist");
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department oldDep = departmentRepository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            oldDep.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            oldDep.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            oldDep.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(oldDep);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findBydepartmentName(name);
    }

    @Override
    public Department fetchDepartmentByAddress(String address) {
        return departmentRepository.findAddress(address);
    }
}

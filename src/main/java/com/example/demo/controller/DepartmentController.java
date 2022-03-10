package com.example.demo.controller;

import com.example.demo.Error.DepartmentNotFoundException;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController
{
    // You can create the constructor too

    @Autowired
    private DepartmentService departmentService;
    // Add logger for debugging
    private final Logger LOGGER =
        LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department)
    {
        LOGGER.info("You just add a new department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }


    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> fetchDepartmentBYID(@PathVariable Long id) throws
            DepartmentNotFoundException
    {
        Department department = departmentService.fetchDepartmentBYID(id);
        return ResponseEntity.ok(department);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentBYID(@PathVariable("id") Long ID)
    {
        departmentService.deleteDepartmentBYID(ID);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id,
                                       @RequestBody(required = true) Department department)
    {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDeparmentByName(@PathVariable String name)
    {
        return departmentService.fetchDepartmentByName(name);
    }

    @GetMapping("/departments/address/{address}")
    public ResponseEntity<Department> fetchDepartmentByAddress(@PathVariable String address)
    {
        Department department = departmentService.fetchDepartmentByAddress(address);
        return ResponseEntity.ok(department);
    }
}

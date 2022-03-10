package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp()
    {
        Department department = new Department();
        department.setDepartmentAddress("600 Pennsylvania Avenue NW");
        department.setDepartmentName("White House");

        Mockito.when(departmentRepository.findAddress("600 Pennsylvania Avenue NW"))
                .thenReturn(department);
    }
    @Test
    public void IfWeHaveADeparment_ThenReturnIt()
    {
        String departmentAddress = "600 Pennsylvania Avenue NW";
        Department found =
                departmentService.fetchDepartmentByAddress(departmentAddress);
        assertEquals(departmentAddress, found.getDepartmentAddress());
    }

}
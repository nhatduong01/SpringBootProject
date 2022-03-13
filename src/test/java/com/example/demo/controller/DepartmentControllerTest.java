package com.example.demo.controller;

import com.example.demo.Error.DepartmentNotFoundException;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest
{
    @Autowired
    private MockMvc mockMvc;
    // Similar to when we test the service layer, we mock the repo layer
    // Now we mock the service layer.

    @MockBean
    private DepartmentService departmentService;
    private Department department;
    @BeforeEach
    void setUp()
    {
        department  = new Department();
        department.setDepartmentName("Chemical Engineering");
        department.setDepartmentCode("Chem");
        department.setDepartmentAddress("B2, Ly Thuong Kiet");
        department.setDepartmentID(1L);
    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = new Department();
        inputDepartment.setDepartmentName("Chemical Engineering");
        inputDepartment.setDepartmentCode("Chem");
        inputDepartment.setDepartmentAddress("B2, Ly Thuong Kiet");
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        var response = mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \n" +
                        "    \"departmentAddress\": \"B2, Ly Thuong Kiet\",\n" +
                        "    \"departmentName\": \"Chemical Engineering\",\n" +
                        "    \"departmentCode\": \"Chem\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse();
    }
    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentBYID(1L))
                .thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));


    }
}
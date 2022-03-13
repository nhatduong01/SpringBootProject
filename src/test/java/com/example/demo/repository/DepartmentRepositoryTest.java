package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp()
    {
        Department department  = new Department();
        department.setDepartmentName("Mechanical Engineering");
        department.setDepartmentCode("ME01");
        department.setDepartmentAddress("Delhi");
        testEntityManager.persist(department);

    }
    @Test
    public void whenFindByIDThenReturnsDepartment()
    {
        Department department = departmentRepository.findAddress("Delhi");
        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
}
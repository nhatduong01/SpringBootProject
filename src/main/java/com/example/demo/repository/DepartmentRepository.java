package com.example.demo.repository;


import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>
{
    // We wont create concrete implementation of this class
    // rather we extend JPA repo because JPA repo gives us
    // a lot of different methods.

    //There is no default method so we must create one.
    public Department findBydepartmentName(String departmentName);
    // Naming Convention is IMPORTANT
    public Department findBydepartmentNameIgnoreCase(String departmentName);

    // Pass native SQL
    @Query(value = "SELECT * FROM department WHERE department_address = ?1", nativeQuery = true)
    public Department findAddress(String address);
}

package com.restapi.tepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByNameAndPasswordAndDepartment(String name, String password, String department);
    List<Staff> findByDepartment(String department);
}

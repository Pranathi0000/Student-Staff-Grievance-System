package com.restapi.tepo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.HOD;

public interface HODRepository extends JpaRepository<HOD, Long> {
    HOD findByNameAndPasswordAndDepartment(String name, String password, String department);
    List<HOD> findByDepartment(String department);
}
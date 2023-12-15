package com.restapi.tepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Management;

public interface ManagementRepository extends JpaRepository<Management, Long> {
    Management findByNameAndPasswordAndPosition(String name, String password, String position);
    List<Management> findByPosition(String position);
}

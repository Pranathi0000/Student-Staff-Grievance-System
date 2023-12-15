package com.restapi.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Staff;
import com.restapi.tepo.StaffRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class StaffController {

    @Autowired
    StaffRepository staffRepository;

    @GetMapping("/staff")
    public ResponseEntity<List<Staff>> getAllStaff(@RequestParam(required = false) String department) {
        try {
            List<Staff> staffList = new ArrayList<>();
            if (department == null) {
                staffRepository.findAll().forEach(staffList::add);
            } else {
                staffRepository.findByDepartment(department).forEach(staffList::add);
            }
            if (staffList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(staffList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") long id) {
        Optional<Staff> staffData = staffRepository.findById(id);
        if (staffData.isPresent()) {
            return new ResponseEntity<>(staffData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/staffcreate")
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        try {
            Staff _staff = staffRepository.save(new Staff(0, staff.getName(), staff.getPassword(), staff.getDepartment()));
            return new ResponseEntity<>(_staff, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // No need for update and delete mappings as requested
}
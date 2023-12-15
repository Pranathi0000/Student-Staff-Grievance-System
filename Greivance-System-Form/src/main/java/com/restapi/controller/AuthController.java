package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.HOD;
import com.restapi.model.Management;
import com.restapi.model.Staff;
import com.restapi.model.Student;
import com.restapi.model.Auth.AuthRequest;
import com.restapi.tepo.HODRepository;
import com.restapi.tepo.ManagementRepository;
import com.restapi.tepo.StaffRepository;
import com.restapi.tepo.StudentRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private HODRepository hodRepository;

    @Autowired
    private ManagementRepository managementRepository;

    @PostMapping("/student")
    public ResponseEntity<String> authenticateStudent(@RequestBody AuthRequest authRequest) {
        // Assuming StudentRepository has the appropriate method for authentication
        Student student = studentRepository.findByRegdNumAndDobAndDepartment(
                authRequest.getRegdNum(),
                authRequest.getDob(),
                authRequest.getDepartment()
        );

        if (student != null) {
            // Successful authentication
            return new ResponseEntity<>("Student authentication successful", HttpStatus.OK);
        } else {
            // Failed authentication
            return new ResponseEntity<>("Student authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/staff")
    public ResponseEntity<String> authenticateStaff(@RequestBody AuthRequest authRequest) {
        // Assuming StaffRepository has the appropriate method for authentication
        Staff staff = staffRepository.findByNameAndPasswordAndDepartment(
                authRequest.getName(),
                authRequest.getPassword(),
                authRequest.getDepartment()
        );

        if (staff != null) {
            // Successful authentication
            return new ResponseEntity<>("Staff authentication successful", HttpStatus.OK);
        } else {
            // Failed authentication
            return new ResponseEntity<>("Staff authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/hod")
    public ResponseEntity<String> authenticateHOD(@RequestBody AuthRequest authRequest) {
        // Assuming HODRepository has the appropriate method for authentication
        HOD hod = hodRepository.findByNameAndPasswordAndDepartment(
                authRequest.getName(),
                authRequest.getPassword(),
                authRequest.getDepartment()
        );

        if (hod != null) {
            // Successful authentication
            return new ResponseEntity<>("HOD authentication successful", HttpStatus.OK);
        } else {
            // Failed authentication
            return new ResponseEntity<>("HOD authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/management")
    public ResponseEntity<String> authenticateManagement(@RequestBody AuthRequest authRequest) {
        // Assuming ManagementRepository has the appropriate method for authentication
        Management management = managementRepository.findByNameAndPasswordAndPosition(
                authRequest.getName(),
                authRequest.getPassword(),
                authRequest.getPosition()
        );

        if (management != null) {
            // Successful authentication
            return new ResponseEntity<>("Management authentication successful", HttpStatus.OK);
        } else {
            // Failed authentication
            return new ResponseEntity<>("Management authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    // Similar methods for HOD and Management authentication...
}
package com.restapi.controller;


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

import com.restapi.model.HOD;
import com.restapi.tepo.HODRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class HODController {

    @Autowired
    HODRepository hodRepository;

    @GetMapping("/hod")
    public ResponseEntity<List<HOD>> getAllHODs(@RequestParam(required = false) String department) {
        try {
            List<HOD> hodList = department == null ? hodRepository.findAll() : hodRepository.findByDepartment(department);

            if (hodList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(hodList, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hod/{id}")
    public ResponseEntity<HOD> getHODById(@PathVariable("id") long id) {
        Optional<HOD> hodData = hodRepository.findById(id);
        return hodData.map(hod -> new ResponseEntity<>(hod, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/hodcreate")
    public ResponseEntity<HOD> createHOD(@RequestBody HOD hod) {
        try {
            HOD _hod = hodRepository.save(new HOD(0, hod.getName(), hod.getPassword(), hod.getDepartment()));
            return new ResponseEntity<>(_hod, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // No need for update and delete mappings as requested
}

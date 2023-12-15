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

import com.restapi.model.Management;
import com.restapi.tepo.ManagementRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ManagementController {

  @Autowired
  ManagementRepository managementRepository;

  @GetMapping("/management")
  public ResponseEntity<List<Management>> getAllManagement(@RequestParam(required = false) String position) {
      try {
          List<Management> managementList = position == null ? managementRepository.findAll() : managementRepository.findByPosition(position);

          if (managementList.isEmpty()) {
              return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          } else {
              return new ResponseEntity<>(managementList, HttpStatus.OK);
          }
      } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  @GetMapping("/management/{id}")
  public ResponseEntity<Management> getManagementById(@PathVariable("id") long id) {
      Optional<Management> managementData = managementRepository.findById(id);
      return managementData.map(management -> new ResponseEntity<>(management, HttpStatus.OK))
              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/managementcreate")
  public ResponseEntity<Management> createManagement(@RequestBody Management management) {
      try {
          Management _management = managementRepository.save(new Management(0, management.getName(), management.getPassword(), management.getPosition()));
          return new ResponseEntity<>(_management, HttpStatus.CREATED);
      } catch (Exception e) {
          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  // No need for update and delete mappings as requested
}

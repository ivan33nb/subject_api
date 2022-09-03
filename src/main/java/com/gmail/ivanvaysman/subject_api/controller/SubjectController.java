package com.gmail.ivanvaysman.subject_api.controller;

import com.gmail.ivanvaysman.subject_api.model.SubjectInsertReq;
import com.gmail.ivanvaysman.subject_api.service.impl.SubjectServiceImpl;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Subject;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
@RestController
public class SubjectController {

  private final SubjectServiceImpl service;

  @GetMapping("/all")
  public ResponseEntity<List<Subject>> getAllSubject(){
    return ResponseEntity.ok(service.getAllSubject());
  }

  @PostMapping("/add")
  public ResponseEntity<Integer> insertSubject(@RequestBody SubjectInsertReq requestBody){
    return ResponseEntity.ok(service.insertSubject(requestBody));
  }
}

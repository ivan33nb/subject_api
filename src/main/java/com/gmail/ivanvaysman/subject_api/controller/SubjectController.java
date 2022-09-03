package com.gmail.ivanvaysman.subject_api.controller;

import com.gmail.ivanvaysman.subject_api.model.SubjectInsertReq;
import com.gmail.ivanvaysman.subject_api.model.SubjectUpdateReq;
import com.gmail.ivanvaysman.subject_api.service.SubjectService;
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

  private final SubjectService service;

  @GetMapping("/all")
  public ResponseEntity<List<Subject>> getAll(){
    return ResponseEntity.ok(service.getAll());
  }

  @PostMapping("/add")
  public ResponseEntity<Integer> insert(@RequestBody SubjectInsertReq requestBody){
    return ResponseEntity.ok(service.insert(requestBody));
  }

  @PostMapping("/update")
  public ResponseEntity<Integer> update(@RequestBody SubjectUpdateReq requestBody){
    return ResponseEntity.ok(service.update(requestBody));
  }

  @GetMapping("/getJson")
  public ResponseEntity<String> getJson(){
    return ResponseEntity.ok(service.getAll().toString());
  }
}

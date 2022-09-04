package com.gmail.ivanvaysman.subject_api.controller;

import com.gmail.ivanvaysman.jooq.model.tables.pojos.Subject;
import com.gmail.ivanvaysman.subject_api.service.SubjectService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
@RestController
public class SubjectController {

  private final SubjectService service;

  @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Subject>> getJson() {
    return ResponseEntity.ok(service.getAll());
  }
}

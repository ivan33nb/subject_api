package com.gmail.ivanvaysman.subject_api.service;

import com.gmail.ivanvaysman.subject_api.model.SubjectInsertReq;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Subject;
import java.util.List;

public interface SubjectService {
  int insert(SubjectInsertReq requestBody);

  List<Subject> getAll();
}

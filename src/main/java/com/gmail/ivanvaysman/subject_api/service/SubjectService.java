package com.gmail.ivanvaysman.subject_api.service;

import com.gmail.ivanvaysman.jooq.model.tables.pojos.Subject;
import java.util.List;

public interface SubjectService {
  int insert(Subject subject);

  List<Subject> getAll();

  int update(Subject subject);

  Subject findById(Integer id);

  boolean isExist(Integer id);
}

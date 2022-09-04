package com.gmail.ivanvaysman.subject_api.service.impl;

import com.gmail.ivanvaysman.jooq.model.tables.pojos.Subject;
import com.gmail.ivanvaysman.subject_api.repository.SubjectRepository;
import com.gmail.ivanvaysman.subject_api.service.SubjectService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

  private final SubjectRepository repository;

  @Override
  public int insert(Subject subject) {
    subject.setCreateDate(LocalDateTime.now());
    return repository.insert(subject);
  }

  @Override
  public List<Subject> getAll() {
    return repository.getAll();
  }

  @Override
  public int update(Subject subject) {
    subject.setUpdateDate(LocalDateTime.now());
    return repository.update(subject);
  }

  @Override
  public Subject findById(Integer id) {
    return repository.findById(id);
  }

  @Override
  public boolean isExist(Integer id) {
    return repository.isExist(id);
  }
}

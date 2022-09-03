package com.gmail.ivanvaysman.subject_api.service.impl;

import com.gmail.ivanvaysman.subject_api.model.SubjectInsertReq;
import com.gmail.ivanvaysman.subject_api.model.SubjectUpdateReq;
import com.gmail.ivanvaysman.subject_api.repository.SubjectRepository;
import com.gmail.ivanvaysman.subject_api.service.SubjectService;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Subject;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

  private final SubjectRepository repository;

  @Override
  public int insert(SubjectInsertReq requestBody) {

    Subject subject = new Subject();
    subject.setName(requestBody.getName());
    subject.setAmount(requestBody.getAmount());
    subject.setComment(requestBody.getComment());
    subject.setCreateDate(LocalDateTime.now());

    return repository.insert(subject);
  }

  @Override
  public List<Subject> getAll() {
    return repository.getAll();
  }

  @Override
  public int update(SubjectUpdateReq requestBody) {

    Subject subject = new Subject();
    subject.setId(requestBody.getId());
    subject.setName(requestBody.getName());
    subject.setComment(requestBody.getComment());
    subject.setAmount(requestBody.getAmount());
    subject.setUpdateDate(LocalDateTime.now());

    return repository.update(subject);
  }
}

package com.gmail.ivanvaysman.subject_api.repository;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Subject;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SubjectRepository {

  private final DSLContext dslContext;

  public int insert(Subject subject) {
    return dslContext
        .insertInto(
            Tables.SUBJECT,
            Tables.SUBJECT.NAME,
            Tables.SUBJECT.COMMENT,
            Tables.SUBJECT.AMOUNT,
            Tables.SUBJECT.CREATE_DATE)
        .values(
            subject.getName(),
            subject.getComment(),
            subject.getAmount(),
            LocalDateTime.now())
        .execute();
  }

  public List<Subject> getAll() {
    return dslContext.selectFrom(Tables.SUBJECT).fetchInto(Subject.class);
  }
}

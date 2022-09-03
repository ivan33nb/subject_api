package com.gmail.ivanvaysman.subject_api.repository;

import com.tej.JooQDemo.jooq.sample.model.Tables;
import com.tej.JooQDemo.jooq.sample.model.tables.pojos.Subject;
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
            subject.getName(), subject.getComment(), subject.getAmount(), subject.getCreateDate())
        .execute();
  }

  public List<Subject> getAll() {
    return dslContext.selectFrom(Tables.SUBJECT).fetchInto(Subject.class);
  }

  public int update(Subject subject) {
    return dslContext
        .update(Tables.SUBJECT)
        .set(Tables.SUBJECT.NAME, subject.getName())
        .set(Tables.SUBJECT.COMMENT, subject.getComment())
        .set(Tables.SUBJECT.AMOUNT, subject.getAmount())
        .set(Tables.SUBJECT.UPDATE_DATE, subject.getUpdateDate())
        .where(Tables.SUBJECT.ID.eq(subject.getId()))
        .execute();
  }
}

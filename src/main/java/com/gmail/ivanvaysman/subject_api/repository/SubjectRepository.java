package com.gmail.ivanvaysman.subject_api.repository;

import com.gmail.ivanvaysman.jooq.model.Tables;
import com.gmail.ivanvaysman.jooq.model.tables.pojos.Subject;
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

  public Subject findById(Integer id) {
    List<Subject> subjects =
        dslContext
            .selectFrom(Tables.SUBJECT)
            .where(Tables.SUBJECT.ID.eq(id))
            .fetchInto(Subject.class);

    return subjects.isEmpty() ? null : subjects.get(0);
  }

  public boolean isExist(Integer id) {
    return dslContext.fetchExists(
        dslContext.selectFrom(Tables.SUBJECT).where(Tables.SUBJECT.ID.eq(id)));
  }
}

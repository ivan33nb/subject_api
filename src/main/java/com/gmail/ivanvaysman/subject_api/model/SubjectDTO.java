package com.gmail.ivanvaysman.subject_api.model;

import com.gmail.ivanvaysman.jooq.model.tables.pojos.Subject;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class SubjectDTO {
  private Integer id;
  private String name;
  private String comment;
  private Integer amount;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;

  public Subject toSubject(){
    Subject subject = new Subject();

    subject.setId(id);
    subject.setName(name);
    subject.setComment(comment);
    subject.setAmount(amount);
    subject.setCreateDate(createDate);
    subject.setUpdateDate(updateDate);

    return subject;
  }

  public SubjectDTO(Subject subject){
    this.id = subject.getId();
    this.name = subject.getName();
    this.amount = subject.getAmount();
    this.comment = subject.getComment();
    this.createDate = subject.getCreateDate();
    this.updateDate = subject.getUpdateDate();
  }
}

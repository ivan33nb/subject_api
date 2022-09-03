package com.gmail.ivanvaysman.subject_api.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectUpdateReq extends SubjectInsertReq{
  private int id;
  private LocalDateTime createDate;
}

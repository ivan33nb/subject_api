package com.gmail.ivanvaysman.subject_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectInsertReq {
  private String name;
  private String comment;
  private Integer amount;
}

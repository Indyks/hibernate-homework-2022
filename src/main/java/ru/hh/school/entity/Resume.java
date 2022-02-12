package ru.hh.school.entity;

import javax.persistence.*;

@Entity
@Table(name = "resume")
public class Resume {
  @Id
  @GeneratedValue(generator = "resume_id_seq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "resume_id_seq")
  private Integer id;

  @Column(name = "description")
  private String description;

  public Resume() {
  }

  public Resume(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

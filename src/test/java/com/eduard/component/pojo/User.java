package com.eduard.component.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
  private String name;
  private int age;

  @Override
  public String toString() {
    return "User: [" +
        "name='" + name + '\'' +
        ", age=" + age +
        "]";
  }
}

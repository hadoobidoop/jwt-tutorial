package com.bambi.tutorial.entity;


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(length = 50, unique = true)
  private String username;

  @Column(length = 100)
  private String password;

  @Column(length = 50)
  private String nickname;

  private boolean activated;

  @ManyToMany
  @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")},
      inverseJoinColumns = {@JoinColumn(name = "authorityName", referencedColumnName = "authorityName")})
  private Set<Authority> authorities;
}

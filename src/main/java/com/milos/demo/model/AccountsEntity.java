package com.milos.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name="ACCOUNTS")
public class AccountsEntity {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

}

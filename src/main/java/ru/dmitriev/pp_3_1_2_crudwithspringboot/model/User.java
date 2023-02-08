package ru.dmitriev.pp_3_1_2_crudwithspringboot.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usertable")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;
}

package com.example.SpringExceptionHandling.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "User_Tbl")
@Data
@NoArgsConstructor
//take build and append all the fields
@AllArgsConstructor(staticName = "build")
public class EntityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;



}

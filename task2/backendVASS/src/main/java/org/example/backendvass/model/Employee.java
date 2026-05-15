package org.example.backendvass.model;


import jakarta.persistence.*;
import lombok.*;


import java.io.File;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String role;

    private String department;

    private String email;

    private File image;
}
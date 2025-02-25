package com.learning.Student_Management_System.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learning.Student_Management_System.enums.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject", nullable = false)
    private Subject subject;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Group> groups;
}

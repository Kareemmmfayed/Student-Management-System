package com.learning.Student_Management_System.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.learning.Student_Management_System.util.YearMonthAttributeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.YearMonth;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "paid_at", nullable = false, updatable = false)
    @Convert(converter = YearMonthAttributeConverter.class)
    private YearMonth paidAt;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference
    private Student student;
}

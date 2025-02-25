package com.learning.Student_Management_System.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.learning.Student_Management_System.enums.Day;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "periods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day", nullable = false)
    private Day day;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Group group;
}

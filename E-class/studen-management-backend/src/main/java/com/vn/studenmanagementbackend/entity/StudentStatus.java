package com.vn.studenmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_statuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "can_study")
    private Boolean canStudy = true;


}

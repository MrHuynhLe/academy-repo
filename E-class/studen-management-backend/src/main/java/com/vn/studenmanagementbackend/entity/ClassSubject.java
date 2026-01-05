package com.vn.studenmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;
import java.io.Serializable;

@Entity
@Table(name = "class_subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ClassSubjectId.class)
@SQLRestriction("is_deleted = false")
public class ClassSubject {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;
}


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class ClassSubjectId implements Serializable {
    private Integer schoolClass;
    private Integer subject;
}
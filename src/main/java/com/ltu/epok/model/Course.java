package com.ltu.epok.model;


import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "`Course`")
public class Course {

    @GeneratedValue
    @Id
    @Column(name = "course_id", updatable = false, nullable = false)
    private Long id;

    @Basic
    @Column(name = "course_name")
    private String name;

    @Basic
    @Column(name = "course_code")
    private String courseCode;


    @NotNull
    private LocalDate createdAt;

    public Course(String name, String courseCode, List<CourseInstance> courseInstances){
        this.name = name;
        this.courseCode = courseCode;
    }

    // ********************** Accessor Methods ********************** //

    // ********************** Model Methods ********************** //

    @PrePersist
    void createdAt() {
        this.createdAt = LocalDate.now();
    }


    // ********************** Common Methods ********************** //
}
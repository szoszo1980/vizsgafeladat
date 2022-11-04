package com.vizsgafeladat.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todos")
public class ToDo {

    enum Importance {URGENT, IMPORTANT, NON_URGENT}
    enum Status {DONE, WORKING_ON_IT, NOT_STARTED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long description;

    private LocalDate deadline;

    private Importance importance;

    private Status status;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}

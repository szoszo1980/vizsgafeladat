package com.vizsgafeladat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_Email")
    private String userEmail;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<ToDo> todos;

    public void addToDo(ToDo todo) {
        if (todos == null) {
            todos = new ArrayList<>();
        }
        todos.add(todo);
        todo.setUser(this);
    }
}

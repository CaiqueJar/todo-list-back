package com.dias.todolist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_task")
@Getter
@Setter
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String hour;
    private TaskStatusModel taskStatusModel;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}

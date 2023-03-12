package com.dias.todolist.controller;

import com.dias.todolist.model.TaskModel;
import com.dias.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService ts;

    @GetMapping("/all-tasks")
    public Iterable<TaskModel> getAll() {
        return ts.getAll();
    }

    @GetMapping("/")
    public String rota() {
        return "Teste zika";
    }
}

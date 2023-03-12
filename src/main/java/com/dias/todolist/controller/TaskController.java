package com.dias.todolist.controller;

import com.dias.todolist.model.TaskModel;
import com.dias.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService ts;

    @GetMapping("/all-tasks")
    public Iterable<TaskModel> getAll() {
        return ts.getAll();
    }

    @GetMapping("/{id}")
    public TaskModel getById(@PathVariable("id") Long id) {
        return ts.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        ts.deleteTask(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    public String rota() {
        return "Teste zika";
    }
}

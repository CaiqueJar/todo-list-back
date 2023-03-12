package com.dias.todolist.controller;

import com.dias.todolist.model.TaskModel;
import com.dias.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService ts;

    @GetMapping()
    public Iterable<TaskModel> getAll() {
        return ts.getAll();
    }

    @GetMapping("/{id}")
    public TaskModel getById(@PathVariable("id") Long id) {
        return ts.getTaskById(id);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody TaskModel taskModel) {
        TaskModel savedTask = ts.createTask(taskModel);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/task/" + savedTask.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody TaskModel taskModel) {
        TaskModel updateTask = ts.updateTask(id, taskModel);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        ts.deleteTask(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}

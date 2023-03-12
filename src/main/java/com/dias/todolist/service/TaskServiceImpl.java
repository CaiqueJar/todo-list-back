package com.dias.todolist.service;

import com.dias.todolist.model.TaskModel;
import com.dias.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository tr;

    @Override
    public Iterable<TaskModel> getAll() {
        return tr.findAll();
    }

    @Override
    public TaskModel getTaskById(Long id) {
        return null;
    }
}

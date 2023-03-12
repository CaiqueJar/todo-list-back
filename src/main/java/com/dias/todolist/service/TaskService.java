package com.dias.todolist.service;

import com.dias.todolist.model.TaskModel;

public interface TaskService {


    Iterable<TaskModel> getAll();

    TaskModel getTaskById(Long id);
}

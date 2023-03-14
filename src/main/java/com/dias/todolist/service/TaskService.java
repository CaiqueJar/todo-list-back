package com.dias.todolist.service;

import com.dias.todolist.model.TaskModel;

public interface TaskService {


    Iterable<TaskModel> getAll();
    TaskModel getTaskById(Long id);

    TaskModel createTask(TaskModel taskModel);

    TaskModel updateTask(Long id, TaskModel taskModel);

    void deleteTask(Long id);

    TaskModel checkTaskStatus(Long id);
}

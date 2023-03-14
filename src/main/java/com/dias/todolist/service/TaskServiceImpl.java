package com.dias.todolist.service;

import com.dias.todolist.model.TaskModel;
import com.dias.todolist.model.TaskStatusModel;
import com.dias.todolist.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        return tr.findById(id).get();
    }

    @Override
    public TaskModel createTask(TaskModel taskModel) {
        taskModel.setTaskStatusModel(TaskStatusModel.CREATED);
        tr.save(taskModel);
        return taskModel;
    }

    @Override
    public TaskModel updateTask(Long id, TaskModel taskModel) {
        TaskModel updateTask = getTaskById(id);

        updateTask.setName(taskModel.getName());
        updateTask.setHour(taskModel.getHour());
        updateTask.setTaskStatusModel(taskModel.getTaskStatusModel());
        updateTask.setUpdated_at(LocalDateTime.now());

        tr.save(updateTask);

        return updateTask;
    }

    @Override
    public void deleteTask(Long id) {
        tr.deleteById(id);
    }

    @Override
    public TaskModel checkTaskStatus(Long id) {
        TaskModel updateTask = getTaskById(id);
        updateTask.setTaskStatusModel(TaskStatusModel.CHECKED);

        tr.save(updateTask);

        return updateTask;
    }
}

package com.javarush.jira.bugtracking;

import com.javarush.jira.bugtracking.internal.mapper.TaskMapper;
import com.javarush.jira.bugtracking.internal.model.Task;
import com.javarush.jira.bugtracking.internal.model.TaskTag;
import com.javarush.jira.bugtracking.internal.model.TaskTagId;
import com.javarush.jira.bugtracking.internal.repository.TaskRepository;
import com.javarush.jira.bugtracking.internal.repository.TaskTagRepository;
import com.javarush.jira.bugtracking.to.TaskTo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService extends BugtrackingService<Task, TaskTo, TaskRepository> {

    private final TaskTagRepository taskTagRepository;

    public TaskService(final TaskRepository taskRepository,
                       final TaskTagRepository taskTagRepository,
                       final TaskMapper mapper) {

        super(taskRepository, mapper);
        this.taskTagRepository = taskTagRepository;
    }

    public List<TaskTo> getAll() {
        return mapper.toToList(repository.getAll());
    }

    @Transactional
    public void addTag(long taskId, String tag) {
        taskTagRepository.save(new TaskTag(taskId, tag));
    }
}

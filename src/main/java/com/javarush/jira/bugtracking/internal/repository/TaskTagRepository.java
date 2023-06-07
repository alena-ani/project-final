package com.javarush.jira.bugtracking.internal.repository;

import com.javarush.jira.bugtracking.internal.model.TaskTag;
import com.javarush.jira.bugtracking.internal.model.TaskTagId;
import org.springframework.data.repository.CrudRepository;

public interface TaskTagRepository extends CrudRepository<TaskTag, TaskTagId> {
}

package com.javarush.jira.bugtracking.internal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TaskTagId.class)
public class TaskTag {

    @Id
    @Column(name = "task_id")
    private long taskId;

    @Id
    private String tag;
}

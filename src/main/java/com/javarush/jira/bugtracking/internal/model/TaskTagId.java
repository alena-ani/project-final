package com.javarush.jira.bugtracking.internal.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTagId implements Serializable {

    private long taskId;

    private String tag;
}

package br.edu.iftm.database.models;

import java.util.Date;
import java.util.List;

public class TaskModel {
    enum Status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    private int id;
    private int projectId;
    private String description;
    private Date completionDate;
    private Status status;
    private List<CommentModel> comments;
}

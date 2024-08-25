package br.edu.iftm.database.models;

import java.util.Date;

public class Task {
    private int id;
    private int projectId;
    private String description;
    private Date completionDate;
    private Status status;

    public enum Status {
        PENDING,
        IN_PROGRESS,
        FINISHED
    }

    public Task(int id, int projectId, String description, Date completionDate, Status status) {
        this.id = id;
        this.projectId = projectId;
        this.description = description;
        this.completionDate = completionDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getId() + ". [" + this.getStatus() + "] " + this.getDescription();
    }

}

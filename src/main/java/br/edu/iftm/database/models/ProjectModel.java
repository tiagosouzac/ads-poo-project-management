package br.edu.iftm.database.models;

import java.util.Date;

public class ProjectModel {
    public enum Status {
        PENDING,
        IN_PROGRESS,
        FINISHED
    }

    private int id;
    private String name;
    private String description;
    private TeamModel team;
    private Status status;
    private Date startAt;
    private Date endAt;

    public ProjectModel(int id, String name, String description, Status status, Date startAt, Date endAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public TeamModel getTeam() {
        return this.team;
    }

    public Status getStatus() {
        return this.status;
    }

    public Date getStartDate() {
        return this.startAt;
    }

    public Date getEndDate() {
        return this.endAt;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " - " + this.description + " - " + this.status;
    }
}

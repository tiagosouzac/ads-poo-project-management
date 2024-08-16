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
    private Date startDate;
    private Date endDate;

    public ProjectModel(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = Status.PENDING;
    }

    public ProjectModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = Status.PENDING;
    }

    public ProjectModel(int id, String name, String description, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
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
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " - " + this.description + " - " + this.status;
    }
}

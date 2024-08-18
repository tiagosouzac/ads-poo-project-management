package br.edu.iftm.database.models;

import java.util.Date;

public class Project {
    private int id;
    private String name;
    private String description;
    private Team team;
    private Status status;
    private Date startAt;
    private Date endAt;

    public enum Status {
        PENDING,
        IN_PROGRESS,
        FINISHED
    }

    public Project(int id, String name, String description, Status status, Date startAt, Date endAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " - " + this.description + " - " + this.status;
    }
}

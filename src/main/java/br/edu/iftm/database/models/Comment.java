package br.edu.iftm.database.models;

import java.util.Date;

public class Comment {
    private int id;
    private int taskId;
    private int memberId;
    private String text;
    private Date createdAt;
    private Date updatedAt;

    public Comment(int id, int taskId, int memberId, String text, Date createdAt, Date updatedAt) {
        this.id = id;
        this.taskId = taskId;
        this.memberId = memberId;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

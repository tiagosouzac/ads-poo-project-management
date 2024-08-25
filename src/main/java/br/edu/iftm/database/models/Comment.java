package br.edu.iftm.database.models;

public class Comment {
    private int id;
    private int taskId;
    private String text;

    public Comment(int id, int taskId, String text) {
        this.id = id;
        this.taskId = taskId;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}

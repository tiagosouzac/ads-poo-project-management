package br.edu.iftm.database.models;

import java.util.Date;

public class CommentModel {
    private int id;
    private int taskId;
    private int memberId;
    private String text;
    private Date createdAt;
    private Date updatedAt;
}

package br.edu.iftm.database.models;

public class MemberModel {
    enum Role {
        DEVELOPER,
        DESIGNER,
        MANAGER
    }

    private int id;
    private String name;
    private Role role;
    private int teamId;
}

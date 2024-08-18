package br.edu.iftm.database.models;

public class MemberModel {
    public enum Role {
        DEVELOPER,
        DESIGNER,
        MANAGER
    }

    private int id;
    private String name;
    private Role role;
    private int teamId;

    public MemberModel(int id, String name, Role role, int teamId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.teamId = teamId;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Role getRole() {
        return this.role;
    }

    public int getTeamId() {
        return this.teamId;
    }
}

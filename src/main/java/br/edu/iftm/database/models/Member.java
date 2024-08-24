package br.edu.iftm.database.models;

public class Member {
    private int id;
    private String name;
    private Role role;
    private int teamId;

    public enum Role {
        DEVELOPER,
        DESIGNER,
        MANAGER
    }

    public Member(int id, String name, Role role, int teamId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.teamId = teamId;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.name + " - Cargo: " + this.role + " - Time: " + this.teamId;
    }
}

package br.edu.iftm.database.daos;

import br.edu.iftm.database.Database;

public class TeamDAO {
    private final Database database;

    public TeamDAO() {
        this.database = new Database();
    }

    public boolean store(String name) {
        String sql = "INSERT INTO teams(name) values (?)";

        return this.database.query(sql, name);
    }

    public void update() {
    }

    public void delete() {
    }

    public void list() {
    }

    public void find() {
    }
}

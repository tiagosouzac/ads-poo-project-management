package br.edu.iftm.database.daos;

import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.TeamMapper;
import br.edu.iftm.database.models.TeamModel;

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

    public boolean delete(int id) {
        String sql = "DELETE FROM teams WHERE id = ?;";

        return this.database.query(sql, id);
    }

    public List<TeamModel> list() {
        String sql = "SELECT * FROM teams;";

        return this.database.query(sql, TeamMapper.map());
    }

    public void find() {
    }
}

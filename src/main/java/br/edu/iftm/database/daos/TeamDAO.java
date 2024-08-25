package br.edu.iftm.database.daos;

import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.TeamMapper;
import br.edu.iftm.database.models.Team;

public class TeamDAO {
    private final Database database = new Database();

    public boolean store(String name) {
        String sql = "INSERT INTO teams(name) values (?)";

        return this.database.query(sql, name);
    }

    public boolean update(int id, String name) {
        String sql = "UPDATE teams SET name = ? WHERE id = ?;";

        return this.database.query(sql, name, id);
    }

    public boolean update(int teamId, int projectId) {
        String sql = "UPDATE teams SET project_id = ? WHERE id = ?;";

        return this.database.query(sql, projectId, teamId);
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM teams WHERE id = ?;";

        return this.database.query(sql, id);
    }

    public List<Team> list() {
        String sql = "SELECT * FROM teams;";

        return this.database.query(sql, TeamMapper.map());
    }

    public Team find(int id) {
        String sql = "SELECT * FROM teams WHERE id = ?;";

        return this.database.query(sql, TeamMapper.map(), id).get(0);
    }
}

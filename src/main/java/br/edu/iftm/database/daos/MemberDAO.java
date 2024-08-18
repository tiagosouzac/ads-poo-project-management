package br.edu.iftm.database.daos;

import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.MemberMapper;
import br.edu.iftm.database.models.MemberModel;
import br.edu.iftm.database.models.MemberModel.Role;

public class MemberDAO {
    private final Database database;

    public MemberDAO() {
        this.database = new Database();
    }

    public boolean store(String name, Role role, int teamId) {
        String sql = "INSERT INTO members(name, role, teamId) values (?, ?, ?)";

        return this.database.query(sql, name, role, teamId);
    }

    public boolean update(int id, String name, Role role, int teamId) {
        String sql = "UPDATE members SET name = ?, role = ?, teamId = ? WHERE id = ?;";

        return this.database.query(sql, name, role, teamId, id);
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM members WHERE id = ?;";

        return this.database.query(sql, id);
    }

    public List<MemberModel> list() {
        String sql = "SELECT * FROM members;";

        return this.database.query(sql, MemberMapper.map());
    }

    public MemberModel find(int id) {
        String sql = "SELECT * FROM members WHERE id = ?;";

        return this.database.query(sql, MemberMapper.map(), id).get(0);
    }
}

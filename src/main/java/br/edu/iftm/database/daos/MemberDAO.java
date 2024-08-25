package br.edu.iftm.database.daos;

import java.util.List;

import br.edu.iftm.database.Database;
import br.edu.iftm.database.mappers.MemberMapper;
import br.edu.iftm.database.models.Member;
import br.edu.iftm.database.models.Member.Role;

public class MemberDAO {
    private final Database database = new Database();

    public boolean store(String name, Role role) {
        String sql = "INSERT INTO members(name, role) values (?, ?)";

        return this.database.query(sql, name, role.name());
    }

    public boolean store(String name, Role role, int teamId) {
        String sql = "INSERT INTO members(name, role, team_id) values (?, ?, ?)";

        return this.database.query(sql, name, role, teamId);
    }

    public boolean update(int id, String name, Role role) {
        String sql = "UPDATE members SET name = ?, role = ? WHERE id = ?;";

        return this.database.query(sql, name, role.name(), id);
    }

    public boolean update(int id, Integer teamId) {
        if (teamId == null) {
            String sql = "UPDATE members SET team_id = NULL WHERE id = ?;";
            return this.database.query(sql, id);
        } else {
            String sql = "UPDATE members SET team_id = ? WHERE id = ?;";
            return this.database.query(sql, teamId, id);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM members WHERE id = ?;";

        return this.database.query(sql, id);
    }

    public List<Member> list() {
        String sql = "SELECT * FROM members";

        return this.database.query(sql, MemberMapper.map());
    }

    public List<Member> list(int teamId) {
        String sql = "SELECT * FROM members WHERE team_id = ?;";

        return this.database.query(sql, MemberMapper.map(), teamId);
    }

    public Member find(int id) {
        String sql = "SELECT * FROM members WHERE id = ?;";

        return this.database.query(sql, MemberMapper.map(), id).get(0);
    }
}

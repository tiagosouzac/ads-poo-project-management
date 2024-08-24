package br.edu.iftm.database.mappers;

import java.util.function.Function;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.edu.iftm.database.models.Member;
import br.edu.iftm.database.models.Member.Role;

public class MemberMapper {
    public static Function<ResultSet, Member> map() {
        return member -> {
            try {
                int id = member.getInt("id");
                String name = member.getString("name");
                Role role = Role.valueOf(member.getString("role"));
                int teamId = member.getInt("team_id");

                return new Member(id, name, role, teamId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    };
}

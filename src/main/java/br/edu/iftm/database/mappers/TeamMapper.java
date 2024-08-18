package br.edu.iftm.database.mappers;

import java.util.function.Function;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.edu.iftm.database.models.Team;

public class TeamMapper {
    public static Function<ResultSet, Team> map() {
        return team -> {
            try {
                int id = team.getInt("id");
                String name = team.getString("name");

                return new Team(id, name);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    };
}

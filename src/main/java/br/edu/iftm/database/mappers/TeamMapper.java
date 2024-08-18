package br.edu.iftm.database.mappers;

import java.util.function.Function;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.edu.iftm.database.models.TeamModel;

public class TeamMapper {
    public static Function<ResultSet, TeamModel> map() {
        return team -> {
            try {
                int id = team.getInt("id");
                String name = team.getString("name");

                return new TeamModel(id, name);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };
    };
}

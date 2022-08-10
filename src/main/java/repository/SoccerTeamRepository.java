package repository;

import config.ApplicationConnection;
import entity.SoccerTeam;

import java.sql.*;

public class SoccerTeamRepository {

    public void insertTeam(SoccerTeam soccerTeam) throws SQLException {
        String sql = " INSERT INTO soccerteam(name , numberofgames ,  wins , losses , points , goaldifference) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getName());
        ps.setInt(2, 0);
        ps.setInt(3, 0);
        ps.setInt(4, 0);
        ps.setInt(5, 0);
        ps.setInt(6, 0);

        ps.execute();
        ps.close();
    }

    public boolean usernameContains(String username) throws SQLException {
        String sql = "SELECT name from soccerteam WHERE name=? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    public void deleteTeam(SoccerTeam soccerTeam) throws SQLException {
        String sql = " DELETE FROM soccerteam WHERE name=?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getName());

        ps.execute();
        ps.close();
    }

    public SoccerTeam usernameContains(SoccerTeam soccerTeam) throws SQLException {
        String sql = "SELECT * from soccerteam WHERE name=? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql);
        ps.setString(1, soccerTeam.getName());

        ResultSet rs = ps.executeQuery();
        SoccerTeam soccerTeam1 = new SoccerTeam();
        if (rs.next()) {

            soccerTeam1.setName(rs.getString("name"));
            soccerTeam1.setNumberOfGames(rs.getInt("numberofgames"));
            soccerTeam1.setWins(rs.getInt("wins"));
            soccerTeam1.setLosses(rs.getInt("losses"));
            soccerTeam1.setPoints(rs.getInt("points"));
            soccerTeam1.setGoalDifference(rs.getInt("goaldifference"));
        }
        return soccerTeam1;
    }

    public SoccerTeam[] showTable() throws SQLException {
        final String query = " select * from soccerteam order by points desc;";
        Statement statement = ApplicationConnection.getConnection().createStatement();


        ResultSet rs = statement.executeQuery(query);
        SoccerTeam[] soccerTeams = new SoccerTeam[1000];

        int index = 0;
        while (rs.next()) {
            SoccerTeam soccerTeam = new SoccerTeam();
            soccerTeam.setName(rs.getString("name"));
            soccerTeam.setNumberOfGames(rs.getInt("numberofgames"));
            soccerTeam.setWins(rs.getInt("wins"));
            soccerTeam.setLosses(rs.getInt("losses"));
            soccerTeam.setPoints(rs.getInt("points"));
            soccerTeam.setGoalDifference(rs.getInt("goaldifference"));
            soccerTeams[index] = soccerTeam;
            index++;

        }
        rs.close();
        return soccerTeams;
    }

  /*  public void updatewinner(SoccerTeam soccerTeam) throws SQLException {
        String sql = " UPDATE soccerteam SET wins = ?, points = ?, losses=?  WHERE name = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getWins());
        ps.setString(2, soccerTeam.getPoints());
        ps.setString(3, soccerTeam.getLosses());
        ps.setString(4, soccerTeam.getName());
        ps.execute();
        ps.close();
    }
    public void updatelosser(SoccerTeam soccerTeam) throws SQLException {
        String sql = " UPDATE soccerteam SET wins = ?, points = ?  , losses = ?  WHERE name = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getWins());
        ps.setString(2, soccerTeam.getPoints());
        ps.setString(3, soccerTeam.getLosses());
        ps.setString(4, soccerTeam.getName());

        ps.execute();
        ps.close();
    }

    public void updatewinnerdif(SoccerTeam soccerTeam) throws SQLException {
        String sql = " UPDATE soccerteam SET goaldifference = ?  WHERE name = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getGoalDifference());
        ps.setString(2, soccerTeam.getName()+3);
        ps.execute();
        ps.close();
    }
    public void updatelosserdif(SoccerTeam soccerTeam) throws SQLException {
        String sql = " UPDATE soccerteam SET goaldifference = ?  WHERE name = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getGoalDifference());
        ps.setString(2, soccerTeam.getName());

        ps.execute();
        ps.close();
    }
*/
}




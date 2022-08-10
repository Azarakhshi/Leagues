package repository;

import config.ApplicationConnection;
import entity.SoccerTeam;

import java.sql.*;

public class SoccerTeamRepository {

    public void insertTeam(SoccerTeam soccerTeam) throws SQLException {
        String sql = " INSERT INTO soccerteam(namesoccerteam , numberofgames ,  wins , losses , points , goaldifference) VALUES (?,?,?,?,?,?)";
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
    }//creat team

    public boolean usernameContains(String username) throws SQLException {
        String sql = "SELECT namesoccerteam from soccerteam WHERE namesoccerteam=? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }//check to team exist or not exist

    public void deleteTeam(SoccerTeam soccerTeam) throws SQLException {
        String sql = " DELETE FROM soccerteam WHERE namesoccerteam=?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getName());

        ps.execute();
        ps.close();
    }//delete team

    public SoccerTeam usernameContains(SoccerTeam soccerTeam) throws SQLException {
        String sql = "SELECT * from soccerteam WHERE namesoccerteam = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, soccerTeam.getName());

        ResultSet rs;
        rs = ps.executeQuery();

        while (rs.next()) {
            soccerTeam.setName(rs.getString("namesoccerteam"));
            soccerTeam.setNumberOfGames(rs.getInt("numberofgames"));
            soccerTeam.setWins(rs.getInt("wins"));
            soccerTeam.setLosses(rs.getInt("losses"));
            soccerTeam.setPoints(rs.getInt("points"));
            soccerTeam.setGoalDifference(rs.getInt("goaldifference"));
        }
        return soccerTeam;

    }//return information team

    public SoccerTeam[] showTable() throws SQLException {
        final String query = " select * from soccerteam order by points desc;";
        Statement statement = ApplicationConnection.getConnection().createStatement();


        ResultSet rs = statement.executeQuery(query);
        SoccerTeam[] soccerTeams = new SoccerTeam[1000];

        int index = 0;
        while (rs.next()) {
            SoccerTeam soccerTeam = new SoccerTeam();
            soccerTeam.setName(rs.getString("namesoccerteam"));
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

    }//return table

    public void updatewinner(SoccerTeam soccerTeam) throws SQLException {
        String sql = " UPDATE soccerteam SET wins = ?, points = ?, numberofgames = ? , goaldifference = ?   WHERE namesoccerteam = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, soccerTeam.getWins());
        ps.setInt(2, soccerTeam.getPoints());
        ps.setInt(3, soccerTeam.getNumberOfGames());
        ps.setInt(4, soccerTeam.getGoalDifference());
        ps.setString(5 , soccerTeam.getName());
        ps.execute();
        ps.close();

    }//update winner team information


    public void updatelosser(SoccerTeam soccerTeam) throws SQLException {
        String sql = " UPDATE soccerteam SET numberofgames = ? , goaldifference = ?  , losses = ?  WHERE namesoccerteam = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, soccerTeam.getNumberOfGames());
        ps.setInt(2, soccerTeam.getGoalDifference());
        ps.setInt(3, soccerTeam.getLosses());
        ps.setString(4, soccerTeam.getName());

        ps.execute();
        ps.close();

    }//update looser team information


}




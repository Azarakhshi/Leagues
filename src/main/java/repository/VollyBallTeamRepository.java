package repository;
import config.ApplicationConnection;
import entity.SoccerTeam;
import entity.VollyballTeam;

import java.sql.*;

public class VollyBallTeamRepository {

    public void insertTeam(VollyballTeam vollyballTeam) throws SQLException {
        String sql = " INSERT INTO vollyballteam(vollyballteamname , numberofgames ,  wins , losses , points , poandifference) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, vollyballTeam.getName());
        ps.setInt(2, 0);
        ps.setInt(3, 0);
        ps.setInt(4, 0);
        ps.setInt(5, 0);
        ps.setInt(6, 0);

        ps.execute();
        ps.close();
    }//creat team

    public boolean usernameContains(String username) throws SQLException {
        String sql = "SELECT vollyballteamname from vollyballteam WHERE vollyballteamname=? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }//check to team exist or not exist

    public void deleteTeam(VollyballTeam vollyballTeam) throws SQLException {
        String sql = " DELETE FROM vollyballteam WHERE vollyballteamname=?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, vollyballTeam.getName());

        ps.execute();
        ps.close();
    }//delete team

    public VollyballTeam usernameContains(VollyballTeam vollyballTeam) throws SQLException {
        String sql = "SELECT * from vollyballteam WHERE vollyballteamname = ? ";
        PreparedStatement ps = ApplicationConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, vollyballTeam.getName());

        ResultSet rs;
        rs = ps.executeQuery();

        while (rs.next()) {
            vollyballTeam.setName(rs.getString("vollyballteamname"));
            vollyballTeam.setNumberOfGames(rs.getInt("numberofgames"));
            vollyballTeam.setWins(rs.getInt("wins"));
            vollyballTeam.setLosses(rs.getInt("losses"));
            vollyballTeam.setPoints(rs.getInt("points"));
            vollyballTeam.setPoanDifference(rs.getInt("poandifference"));
        }
        return vollyballTeam;

    }//return information team

    public VollyballTeam[] showTable() throws SQLException {
        final String query = " select * from vollyballteam order by points desc;";
        Statement statement = ApplicationConnection.getConnection().createStatement();


        ResultSet rs = statement.executeQuery(query);
        VollyballTeam[] vollyballTeams = new VollyballTeam[1000];

        int index = 0;
        while (rs.next()) {
            VollyballTeam vollyballTeam = new VollyballTeam();
            vollyballTeam.setName(rs.getString("vollyballteamname"));
            vollyballTeam.setNumberOfGames(rs.getInt("numberofgames"));
            vollyballTeam.setWins(rs.getInt("wins"));
            vollyballTeam.setLosses(rs.getInt("losses"));
            vollyballTeam.setPoints(rs.getInt("points"));
            vollyballTeam.setPoanDifference(rs.getInt("poandifference"));
            vollyballTeams[index] = vollyballTeam;
            index++;

        }
        rs.close();
        return vollyballTeams;

    }//return table

    public void updatewinner(VollyballTeam vollyballTeam) throws SQLException {
        String sql = " UPDATE vollyballteam SET wins = ?, points = ?, numberofgames = ? , poandifference = ?   WHERE vollyballteamname = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, vollyballTeam.getWins());
        ps.setInt(2, vollyballTeam.getPoints());
        ps.setInt(3, vollyballTeam.getNumberOfGames());
        ps.setInt(4, vollyballTeam.getPoanDifference());
        ps.setString(5 , vollyballTeam.getName());
        ps.execute();
        ps.close();

    }//update winner team information


    public void updatelosser(VollyballTeam vollyballteam) throws SQLException {
        String sql = " UPDATE vollyballteam SET numberofgames = ? , poandifference = ?  , losses = ?  WHERE vollyballteamname = ?";
        PreparedStatement ps = ApplicationConnection.getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, vollyballteam.getNumberOfGames());
        ps.setInt(2, vollyballteam.getPoanDifference());
        ps.setInt(3, vollyballteam.getLosses());
        ps.setString(4, vollyballteam.getName());

        ps.execute();
        ps.close();

    }//update looser team information


}

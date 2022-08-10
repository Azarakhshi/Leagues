package service;
import entity.SoccerTeam;
import entity.VollyballTeam;
import repository.SoccerTeamRepository;
import repository.VollyBallTeamRepository;

import java.sql.SQLException;
import java.util.Scanner;
public class VollyBallMenuMethod {

    Scanner scanner = new Scanner(System.in);
    VollyballTeam vollyballTeam = new VollyballTeam();
    VollyBallTeamRepository vollyBallTeamRepository = new VollyBallTeamRepository();

    public void creatTeam() throws SQLException {

        String input;
        while (true) {
            System.out.println("please enter the name for team: ");
            input = scanner.next();
            if (input.length() <= 30 && !vollyBallTeamRepository.usernameContains(input)) {
                vollyballTeam.setName(input);
                break;
            } else {
                System.out.println("your team name is not valid! ");
            }
        }
        vollyBallTeamRepository.insertTeam(vollyballTeam);
        System.out.println("creat team is successfully. ");

    }

    public void deletTeam() throws SQLException {
        String input;
        while (true) {
            System.out.println("please enter the name for club: ");
            input = scanner.next();
            if (input.length() <= 30 && vollyBallTeamRepository.usernameContains(input)) {
                vollyballTeam.setName(input);
                break;
            } else {
                System.out.println("your team name is not exist! ");
            }
        }
        vollyBallTeamRepository.deleteTeam(vollyballTeam);
        System.out.println("delete team is successfully. ");

    }

    public void showTeamInformation() throws SQLException {
        String input;
        while (true) {
            System.out.println("please enter the name for club: ");
            input = scanner.next();
            if (input.length() <= 30 && vollyBallTeamRepository.usernameContains(input)) {
                vollyballTeam.setName(input);
                break;
            } else {
                System.out.println("your team name is not valid! ");
            }
        }
        System.out.println(vollyBallTeamRepository.usernameContains(vollyballTeam));

    }

    public void ShowGeneralTable() throws SQLException {
        VollyballTeam[] vollyballTeams;
        vollyballTeams = vollyBallTeamRepository.showTable();
        while (true) {
            if (vollyballTeams.length == 0) {
                System.out.println("published article is not exist");
                break;
            } else {
                for (int i = 0; i < vollyballTeams.length; i++) {

                    if (vollyballTeams[i] != null) {

                        System.out.println((i+1) +  " _ " + vollyballTeams[i]);

                    }

                }

            }
            System.out.println("********");
            break;
        }
        vollyBallTeamRepository.showTable();
    }
}

package service;

import entity.SoccerTeam;
import repository.SoccerTeamRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class SoccerMenuMethod {
    Scanner scanner = new Scanner(System.in);
    SoccerTeam soccerTeam = new SoccerTeam();
    SoccerTeamRepository soccerTeamRepository = new SoccerTeamRepository();

    public void creatTeam() throws SQLException {

        String input;
        while (true) {
            System.out.println("please enter the name for team: ");
            input = scanner.next();
            if (input.length() <= 30 && !soccerTeamRepository.usernameContains(input)) {
                soccerTeam.setName(input);
                break;
            } else {
                System.out.println("your team name is not valid! ");
            }
        }
        soccerTeamRepository.insertTeam(soccerTeam);
        System.out.println("creat team is successfully. ");

    }

    public void deletTeam() throws SQLException {
        String input;
        while (true) {
            System.out.println("please enter the name for club: ");
            input = scanner.next();
            if (input.length() <= 30 && soccerTeamRepository.usernameContains(input)) {
                soccerTeam.setName(input);
                break;
            } else {
                System.out.println("your team name is not exist! ");
            }
        }
        soccerTeamRepository.deleteTeam(soccerTeam);
        System.out.println("delete team is successfully. ");

    }

    public void showTeamInformation() throws SQLException {
        String input;
        while (true) {
            System.out.println("please enter the name for club: ");
            input = scanner.next();
            if (input.length() <= 30 && soccerTeamRepository.usernameContains(input)) {
                soccerTeam.setName(input);
                break;
            } else {
                System.out.println("your team name is not valid! ");
            }
        }
        System.out.println(soccerTeamRepository.usernameContains(soccerTeam));

    }

    public void ShowGeneralTable() throws SQLException {
        SoccerTeam[] soccerTeams = new SoccerTeam[1000];
        soccerTeams = soccerTeamRepository.showTable();
        while (true) {
            if (soccerTeams.length == 0) {
                System.out.println("published article is not exist");
                break;
            } else {
                for (int i = 0; i < soccerTeams.length; i++) {


                    if (soccerTeams[i] != null) {
                        System.out.println(soccerTeams[i]);


                    }


                }

            }
            System.out.println("********");
            break;
        }
        soccerTeamRepository.showTable();
    }


}

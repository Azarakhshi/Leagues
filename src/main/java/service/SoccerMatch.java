package service;

import entity.SoccerTeam;
import repository.SoccerTeamRepository;

import java.sql.SQLException;
import java.util.Scanner;
import java.lang.*;

public class SoccerMatch {


    public void SoccerMatch() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        SoccerTeam soccerTeam = new SoccerTeam();
        SoccerTeamRepository soccerTeamRepository = new SoccerTeamRepository();

        String firstTeamName;
        while (true) {
            System.out.println("please enter the first team: ");
            firstTeamName = scanner.next();
            if (firstTeamName.length() <= 30 && soccerTeamRepository.usernameContains(firstTeamName)) {
                soccerTeam.setName(firstTeamName);
                break;
            } else {
                System.out.println("your team name is not exist! ");
            }
        }


        String secondTeamName;
        while (true) {
            System.out.println("please enter the second team: ");
            secondTeamName = scanner.next();
            if (secondTeamName.length() <= 30 && soccerTeamRepository.usernameContains(firstTeamName)) {
                soccerTeam.setName(secondTeamName);
                break;
            } else {
                System.out.println("your team name is not exist! ");
            }
        }

        SoccerTeam firstTeam = new SoccerTeam();
        SoccerTeam secondTeam = new SoccerTeam();

        firstTeam.setName(firstTeamName);
        secondTeam.setName(secondTeamName);
        String teamWin;
        int diffranceGoal;


        while (true) {
            System.out.println("who team was win? ");
            teamWin = scanner.next();
            while (true) {
                System.out.println("How many diffrance goals: ");
                diffranceGoal = scanner.nextInt();
                if (diffranceGoal < 99) {
                    break;
                } else {
                    System.out.println("diffrance goals is not valid: ");
                }
            }

            if (teamWin.equals(firstTeamName)) {
                firstTeam = soccerTeamRepository.usernameContains(firstTeam);
                firstTeam.setPoints(firstTeam.getPoints() + 3);
                firstTeam.setWins(firstTeam.getWins() + 1);
                firstTeam.setNumberOfGames(firstTeam.getNumberOfGames() + 1);
                firstTeam.setGoalDifference(firstTeam.getGoalDifference() + diffranceGoal);
                soccerTeamRepository.updatewinner(firstTeam);
                secondTeam = soccerTeamRepository.usernameContains(secondTeam);
                secondTeam.setLosses(secondTeam.getLosses() + 1);
                secondTeam.setNumberOfGames(secondTeam.getNumberOfGames() + 1);
                secondTeam.setGoalDifference(secondTeam.getGoalDifference() - diffranceGoal);
                soccerTeamRepository.updatelosser(secondTeam);
                break;
            } else if (teamWin.equals(secondTeamName)) {
                secondTeam = soccerTeamRepository.usernameContains(secondTeam);
                secondTeam.setPoints(secondTeam.getPoints() + 3);
                secondTeam.setWins(secondTeam.getWins() + 1);
                secondTeam.setNumberOfGames(secondTeam.getNumberOfGames() + 1);
                secondTeam.setGoalDifference(firstTeam.getGoalDifference() + diffranceGoal);
                soccerTeamRepository.updatewinner(secondTeam);
                firstTeam = soccerTeamRepository.usernameContains(firstTeam);
                firstTeam.setLosses(firstTeam.getLosses() + 1);
                firstTeam.setNumberOfGames(firstTeam.getNumberOfGames() + 1);
                firstTeam.setGoalDifference(firstTeam.getGoalDifference() - diffranceGoal);
                soccerTeamRepository.updatelosser(firstTeam);
                break;
            } else {
                System.out.println("your team is not valid");
            }

        }


    }

}
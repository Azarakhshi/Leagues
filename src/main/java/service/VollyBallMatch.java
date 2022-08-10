package service;

import entity.VollyballTeam;
import repository.VollyBallTeamRepository;


import java.sql.SQLException;
import java.util.Scanner;
import java.lang.*;

public class VollyBallMatch {

    public void vollyBallMatch() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        VollyballTeam vollyballTeam = new VollyballTeam();
        VollyBallTeamRepository vollyBallTeamRepository = new VollyBallTeamRepository();

        String firstTeamName;
        while (true) {
            System.out.println("please enter the first team: ");
            firstTeamName = scanner.next();
            if (firstTeamName.length() <= 30 && vollyBallTeamRepository.usernameContains(firstTeamName)) {
                vollyballTeam.setName(firstTeamName);
                break;
            } else {
                System.out.println("your team name is not exist! ");
            }
        }

        String secondTeamName;
        while (true) {
            System.out.println("please enter the second team: ");
            secondTeamName = scanner.next();
            if (secondTeamName.length() <= 30 && vollyBallTeamRepository.usernameContains(firstTeamName)) {
                vollyballTeam.setName(secondTeamName);
                break;
            } else {
                System.out.println("your team name is not exist! ");
            }
        }

        VollyballTeam firstTeam = new VollyballTeam();
        VollyballTeam secondTeam = new VollyballTeam();

        firstTeam.setName(firstTeamName);
        secondTeam.setName(secondTeamName);
        String teamWin;
        int poandifference;


        while (true) {
            System.out.println("who team was win? ");
            teamWin = scanner.next();
            while (true) {
                System.out.println("How many diffrance poan: ");
                poandifference = scanner.nextInt();
                if (poandifference < 99) {
                    break;
                } else {
                    System.out.println("diffrance goals is not valid: ");
                }
            }

            if (teamWin.equals(firstTeamName)) {
                firstTeam = vollyBallTeamRepository.usernameContains(firstTeam);
                firstTeam.setPoints(firstTeam.getPoints() + 3);
                firstTeam.setWins(firstTeam.getWins() + 1);
                firstTeam.setNumberOfGames(firstTeam.getNumberOfGames() + 1);
                firstTeam.setPoanDifference(firstTeam.getPoanDifference() + poandifference);
                vollyBallTeamRepository.updatewinner(firstTeam);
                secondTeam = vollyBallTeamRepository.usernameContains(secondTeam);
                secondTeam.setLosses(secondTeam.getLosses() + 1);
                secondTeam.setNumberOfGames(secondTeam.getNumberOfGames() + 1);
                secondTeam.setPoanDifference(secondTeam.getPoanDifference() - poandifference);
                vollyBallTeamRepository.updatelosser(secondTeam);
                break;
            } else if (teamWin.equals(secondTeamName)) {
                secondTeam = vollyBallTeamRepository.usernameContains(secondTeam);
                secondTeam.setPoints(secondTeam.getPoints() + 3);
                secondTeam.setWins(secondTeam.getWins() + 1);
                secondTeam.setNumberOfGames(secondTeam.getNumberOfGames() + 1);
                secondTeam.setPoanDifference(firstTeam.getPoanDifference() + poandifference);
                vollyBallTeamRepository.updatewinner(secondTeam);
                firstTeam = vollyBallTeamRepository.usernameContains(firstTeam);
                firstTeam.setLosses(firstTeam.getLosses() + 1);
                firstTeam.setNumberOfGames(firstTeam.getNumberOfGames() + 1);
                firstTeam.setPoanDifference(firstTeam.getPoanDifference() - poandifference);
                vollyBallTeamRepository.updatelosser(firstTeam);
                break;
            } else {
                System.out.println("your team is not valid");
            }

        }



    }
}

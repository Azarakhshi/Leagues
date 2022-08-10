package service;

import java.sql.SQLException;
import java.util.Scanner;

public class SoccerMenu {
    public void showMenuSoccer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        SoccerMenuMethod soccerMenuMethod = new SoccerMenuMethod();
        String input;
        while (true) {
            System.out.println("please enter the follwing menu: ");
            System.out.println("1: creat team");
            System.out.println("2: deleted team");
            System.out.println("3: add match");
            System.out.println("4: show team information: ");
            System.out.println("5: show table of league: ");
            System.out.println("exit");
            input = scanner.next();
            if (input.equals("1")) {
                soccerMenuMethod.creatTeam();
            } else if (input.equals("2")) {
                soccerMenuMethod.deletTeam();
            } else if (input.equals("3")) {

            } else if (input.equals("4")) {
                soccerMenuMethod.showTeamInformation();
            } else if (input.equals("5")) {
                soccerMenuMethod.ShowGeneralTable();
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("your input is not correct! ");
            }

        }
    }
}

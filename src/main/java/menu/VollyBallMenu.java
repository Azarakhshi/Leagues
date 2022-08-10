package menu;

import java.util.Scanner;

import repository.VollyBallTeamRepository;
import service.VollyBallMatch;
import service.VollyBallMenuMethod;

import java.sql.SQLException;
import java.util.Scanner;

public class VollyBallMenu {
    public void showMenuVollyBall() throws SQLException {

        Scanner sc = new Scanner(System.in);
        VollyBallMenuMethod vollyBallMenuMethod = new VollyBallMenuMethod();
        String input;
        while (true) {
            System.out.println("please enter the follwing menu : ");
            System.out.println("1 : creat team");
            System.out.println("2 : deleted team");
            System.out.println("3 : add match");
            System.out.println("4 : show team information: ");
            System.out.println("5 : show table of league: ");
            System.out.println("exit");
            input = sc.next();
            if (input.equals("1")) {
                vollyBallMenuMethod.creatTeam();
            } else if (input.equals("2")) {
                vollyBallMenuMethod.deletTeam();
            } else if (input.equals("3")) {

            } else if (input.equals("4")) {
                vollyBallMenuMethod.showTeamInformation();
            } else if (input.equals("5")) {
                vollyBallMenuMethod.ShowGeneralTable();
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("your input is not correct! ");
            }

        }

    }
}

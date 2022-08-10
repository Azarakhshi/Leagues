package menu;

import java.sql.SQLException;
import java.util.Scanner;

public class Firstmenu {
    public void shoeMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("please enter the folliwng menu: ");
            System.out.println("1: soccer");
            System.out.println("2: vollyball");
            System.out.println("exit");
            input = scanner.next();
            if (input.equals("1")) {
                SoccerMenu soccerMenu = new SoccerMenu();
                soccerMenu.showMenuSoccer();
            } else if (input.equals("2")) {
                VollyBallMenu vollyBallMenu = new VollyBallMenu();
                vollyBallMenu.showMenuVollyBall();
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("your input is not correct! ");
            }


        }

    }
}

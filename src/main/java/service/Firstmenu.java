package service;

import java.util.Scanner;

public class Firstmenu {
    public void shoeMenu(){
        Scanner scanner = new Scanner(System.in);
String input;
        while (true){
        System.out.println("please enter the folliwng menu: ");
        System.out.println("1: soccer");
        System.out.println("2: vollyball");
        System.out.println("3: creat league");
        System.out.println("exit");
        input = scanner.next();
        if(input.equals("1")){
            //soccer
        }else if(input.equals("2")){
            //vollyball
        }else if(input.equals("3")){
            //creat league
        }else if(input.equals("exit")){
            break;
        }else{
            System.out.println("your input is not correct! ");
        }




        }

    }
}

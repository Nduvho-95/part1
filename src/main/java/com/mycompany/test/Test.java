/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
       Login auth = new Login();
        Scanner sc = new Scanner(System.in);
       

        System.out.println("--- Registration ---");
        System.out.print("Enter First Name: ");
        String fName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = sc.nextLine();
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        System.out.print("Enter Phone (+27...): ");
        String phone = sc.nextLine();

        String regMessage = auth.registerUser(user, pass, phone);
        System.out.println(regMessage);

        if (regMessage.contains("successfully captured")) {
            System.out.println("\n--- Login ---");
            System.out.print("Username: ");
            String loginUser = sc.nextLine();
            System.out.print("Password: ");
            String loginPass = sc.nextLine();

            boolean success = auth.loginUser(loginUser, user, loginPass, pass);
            System.out.println(auth.returnLoginStatus(success, fName, lName));
        }
    }
}



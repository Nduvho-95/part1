/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;

import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
class Login {
    public boolean checkUserName(String username) {
            return username.contains("_") && username.length() <= 5;
        }

        // Method to check password complexity
        public boolean checkPasswordComplexity(String password) {
            boolean hasUpper = false;
            boolean hasDigit = false;
            boolean hasSpecial = false;

            if (password.length() < 8) return false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                if (Character.isDigit(c)) hasDigit = true;
                if (!Character.isLetterOrDigit(c)) hasSpecial = true;
            }

            return hasUpper && hasDigit && hasSpecial;
        }

        // Method for South African phone number (International format)
        public boolean checkCellPhoneNumber(String phone) {
            // Regex for +27 followed by 9 digits
            String regex = "^\\+27[6-8][0-9]{8}$";
            return Pattern.matches(regex, phone);
        }

        public String registerUser(String username, String password, String phone) {
            if (!checkUserName(username)) {
                return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
            }
            

            if (!checkPasswordComplexity(password)) {
                return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
            }

            if (!checkCellPhoneNumber(phone)) {
                return "Cell phone number incorrectly formatted or does not contain an international code.";
            }

            return "Username, password, and cell phone number successfully captured.";
        }

        public boolean loginUser(String enteredUser, String storedUser, String enteredPass, String storedPass) {
            return enteredUser.equals(storedUser) && enteredPass.equals(storedPass);
        }

        public String returnLoginStatus(boolean isLoggedIn, String firstName, String lastName) {
            if (isLoggedIn) {
                return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
            } else {
                return "Username or password incorrect, please try again.";
            }
        }
    
}

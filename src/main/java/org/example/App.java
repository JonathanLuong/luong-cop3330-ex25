package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 25 Solution
 *  Copyright 2021 Jonathan Luong
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class App {
    static int passwordValidator (String password) {

        int strength = 0;
        char arr1[] = password.toCharArray();

        if(arr1.length < 8)
            strength = 0;
        else
            strength = strength + 1;

        // uses regex lib to match chars in the string
        if( password.matches("(?=.*[0-9]).*") ) // if its contains numbers
            strength = strength + 0;
        if (password.matches("(?=.*[a-z]).*")) // if its contains lower cases letters
            strength = 1;
        if ((password.matches("(?=.*[a-z]).*") || password.matches("(?=.*[A-Z]).*")) && arr1.length >= 8 && password.matches("(?=.*[0-9]).*")) // if its contains letters and numbers
            strength = 2;
        if ((password.matches("(?=.*[a-z]).*") || password.matches("(?=.*[A-Z]).*")) && arr1.length >= 8 && password.matches("(?=.*[0-9]).*") && password.matches("(?=.*[~!@#$%^&*()_-]).*")) // if its contains all of the above
            strength = 3;

        return strength;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); // Creates reader

        System.out.printf("Enter your password: ");
        String password = reader.nextLine();

        int str = passwordValidator(password);

        if(str == 0)
            System.out.printf("The password '"+ password +"' is a very weak password.");
        else if(str == 1)
            System.out.printf("The password '"+ password +"' is a weak password.");
        else if(str == 2)
            System.out.printf("The password '"+ password +"' is a strong password.");
        else if(str == 3)
            System.out.printf("The password '"+ password +"' is a very strong password.");

    }
}
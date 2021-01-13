package emailapp;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*{}[]+-=?<>'|\"\\/()^~`;:,.";
        String[] list = passwordSet.split("");

        ArrayList<String> charsList = new ArrayList<>(Arrays.asList(passwordSet.split("")));
        Collections.sort(charsList);

        for (String eachChar : charsList) {
            System.out.print(eachChar);
        }
        System.out.println();
        charsList.sort(Comparator.naturalOrder());

        for (String eachChar : charsList) {
            System.out.print(eachChar);
        }


    }
}

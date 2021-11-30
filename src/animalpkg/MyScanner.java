/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

import java.util.Scanner;

/**
 *
 * @author SE140861
 */
public class MyScanner {

    public static Scanner sc = new Scanner(System.in);

    public static boolean getBoolean(String message) {
        String s;
        System.out.format("%s-(T/F, Y/N, 1/0): ", message);
        s = sc.nextLine().trim().toUpperCase();
        char a = s.charAt(0);
        if (a == 'T' || a == 'Y' || a == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static double getDouble(String message, double min, double max) {
        double a;
        do {
            System.out.print(message+"("+min+"..."+max+"): ");
            a = Double.parseDouble(sc.nextLine().trim());
        } while (a < min || a > max);
        return a;
    }

    public static double getDouble(String message, double max) {
        double a;
        do {
            System.out.print(message+"("+0+"..."+max+"): ");
            a = Double.parseDouble(sc.nextLine().trim());
        } while (a < 0 || a > max);
        return a;
    }

    public static int getInt(String message, int min, int max) {
        int a;
        do {
            System.out.print(message+"("+min+"..."+max+"): ");
            a = Integer.parseInt(sc.nextLine().trim());
        } while (a < min || a > max);
        return a;
    }

    public static int getInt(String message, int max) {
        int a;
        do {
            System.out.print(message+"("+0+"..."+max+"): ");
            a = Integer.parseInt(sc.nextLine().trim());
        } while (a < 0 || a > max);
        return a;
    }

    public static String getNonBlankStr(String message) {
        String a;
        do {
            System.out.print(message+"(non-blank):");
            a = sc.nextLine().trim();
        } while (a.length() == 0);
        return a;
    }
}

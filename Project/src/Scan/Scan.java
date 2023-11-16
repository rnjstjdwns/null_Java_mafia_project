package Scan;

import java.util.Scanner;

public class Scan {
   
   private static Scanner s = new Scanner(System.in);
   
   public static int getIntInput() {
       int input = s.nextInt();
       s.nextLine(); // 개행 문자 소비
       return input;
   }

    public static String getStringInput() {
        return s.nextLine();
    }

    public static void closeScanner() {
        s.close();
    }
}
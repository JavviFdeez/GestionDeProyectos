package View.Utils;

import java.util.Scanner;

public class Utils {
    public static void printMsg(String message) {
        System.out.println(message);

    }
    public static void pressEnter() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Press enter to continue.");
        teclado.nextLine();
    }

    public static int readInt(String msg) {
        Scanner keyboard = new Scanner(System.in);
        int num = 0;
        boolean comp = false;

        do {
            System.out.print(msg);
            try {
                num = keyboard.nextInt();
                comp = true;
            } catch (Exception e) {
                System.out.println("Error: this number isn´t good.");
                keyboard.nextLine();
            }
        } while (!comp);
        return num;
    }

    public static String readString(String msg) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(msg);
        return teclado.nextLine();
    }

}
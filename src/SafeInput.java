import java.util.Scanner;

public class SafeInput {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt = 0;
        boolean valid = false;
        String trash = "";

        do {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (retInt >= low && retInt <= high) {
                    valid = true;
                } else {
                    System.out.println("Input is out of range enter a number between " + low + " and " + high);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("\n" + trash + " is not a valid whole number try again");
            }
        }
        while (!valid);
        return retInt;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean playAgain = false;
        boolean valid = false;
        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.equalsIgnoreCase("y")){
                valid = true;
            } else if (retString.equalsIgnoreCase("n")) {
                valid = true;
                playAgain = true;
            }
            else {
                System.out.println("Please enter y or n");
            }
        }
        while (!valid);
        return playAgain;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retString = "";
        boolean valid = false;

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("\nInvalid input: " + retString);
            }
        }
        while (!valid);
        return retString;
    }
}

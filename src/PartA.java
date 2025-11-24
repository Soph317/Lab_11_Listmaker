import java.util.Scanner;
import java.util.ArrayList;

public class PartA {
    public static void main(String[] args) {
        ArrayList<String> myArrList = new ArrayList<>();
        boolean playAgain = true;
        String option;



        Scanner in = new Scanner(System.in);

        while (playAgain){
            option = SafeInput.getRegExString(in, "Enter a menu choice (A - Add, D - Delete, I - Insert, P - Print, Q - Quit", "^[AaDdIiPpQq]$");
            if (option.equalsIgnoreCase("A")){
                addItem(myArrList, in);
            } else if (option.equalsIgnoreCase("D")) {
                deleteItem(myArrList, in);
            } else if (option.equalsIgnoreCase("I")) {
                insertItem(myArrList, in);
            } else if (option.equalsIgnoreCase("P")) {
                printItem(myArrList);
            }else {
                playAgain= SafeInput.getYNConfirm(in, "Are you sure you want to quit y/n");
            }
        }
        for (String item : myArrList) {
            System.out.println(item);
        }
    }
    private static void addItem(ArrayList<String> myArrList, Scanner pipe){
        String item;

        System.out.print("Enter item to add: ");
        item = pipe.nextLine();
        myArrList.add(item);
        System.out.println("Item added");
    }

    private static void deleteItem(ArrayList<String> myArrList, Scanner pipe) {
        int index;

        if (myArrList.isEmpty()) {
            System.out.println("There is nothing to delete");
            return;
        }

        index = SafeInput.getRangedInt(pipe, "Enter the number to delete: ", 1, myArrList.size() + 1);
        myArrList.remove(index - 1);

        System.out.println("Item deleted");
    }

    private static void insertItem(ArrayList<String> myArrList, Scanner pipe) {
        String item;
        int index;


        System.out.print("Enter item to insert: ");
        item = pipe.nextLine();

        index = SafeInput.getRangedInt(pipe, "Enter the number to insert: ", 1, myArrList.size() + 1);
        myArrList.add(index - 1, item);

        System.out.println("Item inserted");
    }

    private static void printItem(ArrayList<String> myArrList) {
        if (myArrList.isEmpty()) {
            System.out.println("There is nothing to delete");
            return;
        }

        for (String item : myArrList) {
            System.out.println(item);
        }
        System.out.println();
    }
}

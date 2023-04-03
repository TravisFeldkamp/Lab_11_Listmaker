import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    static ArrayList<String> list = new ArrayList<>();
    static String item = "";
    static int itemDelete = 0;
    static int itemDeleteFinal = 0;
    static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        boolean done = false;
        final String menu = "A - Add   D - Delete   P - Print Q - Quit ";
        String cmd = "";
        boolean answer = true;


        do {

            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();





            switch (cmd)
            {
                case "A":
                   addList();
                   break;
                case "D":
                    deleteItem();
                    break;
                case "P":

                    break;
                case "Q":
                    answer = SafeInput.getYNConfirm(in, "Are you sure you would like to quit?");
                    if (answer != false)
                    {
                        done = true;
                    }
                    break;
            }

        }
        while (!done);
    }
    private static void displayList()
    {
        //System.out.println("++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0)
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
                System.out.println("\n");
            }
        }
        else
            System.out.println("+++          List is empty           +++");
       // System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }
    private static void addList()
    {
      item = SafeInput.getNonZeroLenString(in,"Input your item to add to the list");
        list.add(item);
        System.out.println("Item added");
    }
    private static void deleteItem()
    {
        System.out.println("List: ");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%3d%35s", i+1, list.get(i));
            System.out.println("\n");
        }

        itemDelete =  SafeInput.getRangedInt(in, "Which item would you like to delete?", 1, list.size());
        itemDeleteFinal = itemDelete - 1;
        list.remove(itemDeleteFinal);
        System.out.println("Item " +itemDelete+ " had been deleted");

    }
}
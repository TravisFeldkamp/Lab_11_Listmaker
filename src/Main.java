import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    static ArrayList<String> list = new ArrayList<>();//creates new array list
    static String item = "";//variable
    static int itemDelete = 0;//variable for method
    static int itemDeleteFinal = 0;//variable for method
    static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        boolean done = false;
        final String menu = "A - Add   D - Delete   P - Print Q - Quit ";
        String cmd = "";
        boolean answer = true;


        do {

            displayList();//displays current list
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");//gets input from user must be adpq
            cmd = cmd.toUpperCase();//converts user input to uppercase





            switch (cmd)//starts switch and case depends on string from user
            {
                case "A"://run if a input given
                   addList();//run addList method
                   break;
                case "D"://run if d input from user
                    deleteItem();//run delete item method
                    break;
                case "P"://displays list already

                    break;
                case "Q"://run if q given by user
                    answer = SafeInput.getYNConfirm(in, "Are you sure you would like to quit?");//get yn confirm for user if they want to quit
                    if (answer != false)//if user does want to quit run this
                    {
                        done = true;//set done to true which quits the loop
                    }
                    break;
            }

        }
        while (!done);
    }
    private static void displayList()
    {

        if (list.size() != 0)//run this if there is an item in the list
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
                System.out.println("\n");
            }
        }
        else//if no items in list display this block
            System.out.println("+++          List is empty           +++");

    }
    private static void addList()
    {
      item = SafeInput.getNonZeroLenString(in,"Input your item to add to the list");// get input from user
        list.add(item);//add input to list
        System.out.println("Item added");
    }
    private static void deleteItem()
    {
        System.out.println("List: ");//displays current list
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%3d%35s", i+1, list.get(i));
            System.out.println("\n");
        }

        itemDelete =  SafeInput.getRangedInt(in, "Which item would you like to delete?", 1, list.size());//ask for ranged input from user
        itemDeleteFinal = itemDelete - 1;//takes input and subtracts one
        list.remove(itemDeleteFinal);//removes item from list
        System.out.println("Item " +itemDelete+ " had been deleted");//output to user saying it was deleted

    }
}
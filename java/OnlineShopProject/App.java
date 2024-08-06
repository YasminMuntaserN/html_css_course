import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static int convertStringIntoNum(String str) {
        int AsciArr[] = { 48, 49, 51, 51, 52, 53, 54, 55, 56, 57 };
        int num = 0;
        int ZerosCount = 1;
        for (int i = str.length() - 1; i > 0; i--) {
            ZerosCount *= 10;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < AsciArr.length; j++) {
                if (str.charAt(i) == (char) AsciArr[j]) {
                    num += (j * ZerosCount);
                    ZerosCount /= 10;
                }
            }
        }
        return num;
    }

    // ************************************************************************************************
    Scanner scanner = new Scanner(System.in);
    String CustomerFileName = "G:\\java\\OnlineShopProject\\Customer.txt";
    String ItemFileName = "G:\\java\\OnlineShopProject\\Item.txt";

    public void AddDateLineToFile(String FileName, String text) {
        try {
            FileWriter fr = new FileWriter(FileName, true);
            PrintWriter printWriter = new PrintWriter(fr);
            printWriter.println(text);
            printWriter.close();
            fr.close();
        } catch (Exception IOException) {
            System.out.println("Exception");
        }
    }

    // ************* Add a new Item to Store ********
    ArrayList<Book> books = new <Book>ArrayList();
    ArrayList<Game> games = new <Game>ArrayList();
    ArrayList<Shoes> shoess = new <Shoes>ArrayList();

    boolean CheakItemNum(String ItemNum, ArrayList<Item> itemsArr) {
        for (Item item : itemsArr) {
            if (item.getItemNumber().equals(ItemNum)) {
                return true;
            }
        }
        return false;
    }

    Item ReadItemFromFile(String Line) {
        Item item = new Item();
        String[] ClientData = Line.split("#//#");
        item.setItemNumber(ClientData[0]);
        item.setItemName(ClientData[1]);
        item.setquantity(convertStringIntoNum(ClientData[2]));
        item.setPrice((double) convertStringIntoNum(ClientData[3]));
        return item;
    }

    ArrayList<Item> LoadItemDataFromFile(String FileName) {
        ArrayList<Item> AllData = new ArrayList();
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while (line != null) {
                AllData.add(ReadItemFromFile(line));
                line = br.readLine();
            }
            br.close();
            reader.close();
        } catch (Exception IOException) {
            System.out.print("Exception **");
        }
        return AllData;
    }

    String convertItemRecordToLine(Item item) {
        String line = item.getItemNumber() + "#//#"
                + item.getItemName() + "#//#"
                + item.getquantity() + "#//#"
                + item.getPrice();
        return line;
    }

    Item ReadItemInfo(ArrayList<Item> itemsArr) {
        Item item;
        System.out.print("Please enter the item Number : ");
        String ItemNum = scanner.next();

        while (CheakItemNum(ItemNum, itemsArr)) {
            System.out.print("\n This Number has been Saved ,please Enter Another Number : ");
            ItemNum = scanner.next();
        }
        System.out.print(" \nPlease enter the item Name : ");
        String ItemName = scanner.next();
        System.out.print(" \nPlease enter the quantity : ");
        int Quantity = scanner.nextInt();
        System.out.print(" \nPlease enter the Price : ");
        double Price = scanner.nextDouble();
        System.out.println("\n Enter the type of item (B)Book , (S)Shoes ,(G)Game ?");
        String type = scanner.next().toUpperCase();
        item = new Item(ItemNum, ItemName, Quantity, Price);
        choice(type, item, itemsArr);
        return item;
    }

    void addItem() {
        String Answer = "y";
        ArrayList<Item> itemsArr = LoadItemDataFromFile(ItemFileName);
        while (Answer.equalsIgnoreCase("y")) {
            System.out.println("--------------------------------");
            System.out.println("Add Item Operation : ");
            System.out.println("--------------------------------");
            Item item = ReadItemInfo(itemsArr);
            AddDateLineToFile(ItemFileName, convertItemRecordToLine(item));
            System.out.println("Item added Successfully ");
            System.out.println("DO you want to add another item (Y / N)");
            Answer = scanner.next().toLowerCase();
        }
    }

    void choice(String type, Item item, ArrayList<Item> itemsArr) {
        switch (type) {
            case "B":
                Book book = new Book(item.getItemNumber(), item.getItemName(), item.getquantity(), item.getPrice());
                book.BookInfo();
                books.add(book);
                itemsArr.add(book);
                break;
            case "S":
                Shoes shoes = new Shoes(item.getItemNumber(), item.getItemName(), item.getquantity(), item.getPrice());
                shoess.add(shoes);
                itemsArr.add(shoes);
                break;
            case "G":
                Game game = new Game(item.getItemNumber(), item.getItemName(), item.getquantity(), item.getPrice());
                games.add(game);
                itemsArr.add(game);
                break;
        }
    }

    // ************* Add a new Customer to Store ********
    Customer ReadFromFile(String Line ) {
        Customer customer = new Customer();
        String[] ClientData = Line.split("#//#");
        customer.setCustomerNumber(ClientData[0]);
        customer.setCustomerName(ClientData[1]);
        return customer;
    }

    ArrayList<Customer> LoadDataFromFile(String FileName) {
        ArrayList<Customer> AllData = new ArrayList();
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while (line != null) {
                AllData.add(ReadFromFile(line));
                line = br.readLine();
            }
            br.close();
            reader.close();
        } catch (Exception IOException) {
            System.out.print("Exception **");
        }
        return AllData;
    }

    boolean CheakCustomerAccountNum(String customerNum, ArrayList<Customer> customerArr) {
        for (Customer customer : customerArr) {
            if (customer.getCustomerNumber().equals(customerNum)) {
                return true;
            }
        }
        return false;
    }

    String convertRecordToLine(Customer customer) {
        String line = customer.getCustomerNumber() + "#//#"
                + customer.getCustomerName();
        return line;
    }

    Customer ReadCustomerInfo(ArrayList<Customer> customerArr) {
        System.out.print("Please enter the Customer Number : ");
        String customerNumber = scanner.next();
        while (CheakCustomerAccountNum(customerNumber, customerArr)) {
            System.out.print("\n This Number has been Saved ,please Enter Another Number : ");
            customerNumber = scanner.next();
        }
        System.out.print(" \nPlease enter the Customer Name : ");
        String customerName = scanner.next();
        Customer customer = new Customer(customerNumber, customerName);
        return customer;
    }

    void addCustomer() {
        ArrayList<Customer> customerArr = LoadDataFromFile(CustomerFileName);
        String Answer = "y";
        while (Answer.equalsIgnoreCase("y")) {
            System.out.println("--------------------------------");
            System.out.println("Add new Customer Operation : ");
            System.out.println("--------------------------------");

            Customer customer = ReadCustomerInfo(customerArr);
            customerArr.add(customer);
            AddDateLineToFile(CustomerFileName, convertRecordToLine(customer));
            System.out.println("Customer added Successfully ");
            System.out.println("DO you want to add another Customer (Y / N)");
            Answer = scanner.next().toLowerCase();
        }
    }

    // ************* Add an Item to Customer Shoping Cart ********
    public void SaveCItemDataToFile(String FileName, ArrayList<Item> AllData, Item selectedItem, int quantityNum) {
        File file = new File(FileName);
        file.delete();
        try {
            FileWriter fr = new FileWriter(FileName, true);
            PrintWriter printWriter = new PrintWriter(fr);
            for (Item c : AllData) {
                if (!(c == selectedItem)) {
                    fr.write(convertItemRecordToLine(c) + "\n");
                } else {
                    selectedItem.setquantity(selectedItem.getquantity() - quantityNum);
                    fr.write(convertItemRecordToLine(c) + "\n");
                }
            }
            printWriter.close();
            fr.close();
        } catch (Exception IOException) {
            System.out.println("Exception");
        }
    }

    Customer MarkCustomer(String customerNum, ArrayList<Customer> customerArr) {
        Customer c = null;
        for (Customer customer : customerArr) {
            if (customer.getCustomerNumber().equals(customerNum)) {
                c = customer;
            }
        }
        return c;
    }

    Customer CheakIfCustomerExsist(ArrayList<Customer> customerArr) {
        System.out.println("Please Enter Customer Number :");
        String CustomerNum = scanner.next();
        while (!CheakCustomerAccountNum(CustomerNum, customerArr)) {
            System.out.println("The Customer is not exits , Do you want to try again ( y ,n )?");
            String TryAgain = scanner.next();
            if (TryAgain.equalsIgnoreCase("n")) {
                // menu.MainMenuSecreen();
            } else {
                System.out.println("Please Enter Customer Number :");
                CustomerNum = scanner.next();
            }
        }
        Customer customer = MarkCustomer(CustomerNum, customerArr);
        System.out.println("The customer no : " + customer.getCustomerNumber()
                + "  The customer Name : " + customer.getCustomerName());
        return customer;
    }

    void printItemInStore(ArrayList<Item> itemsArr) {
        System.out.println("--------------------------------");
        System.out.println("\t Item List :");
        System.out.println("--------------------------------");

        int i = 1;
        for (Item item : itemsArr) {
            System.out.println(" >>>> " + i + " . " + item.getItemNumber() + " "
                    + item.getItemName() + ".  [" + item.getquantity() + "]");
            i++;
        }
        System.out.println(" >>>> 0. Return to a main menu");
    }

    public void AddItemToCart() {
        ArrayList<Customer> customerArr = LoadDataFromFile(CustomerFileName);
        ArrayList<Item> itemsArr = LoadItemDataFromFile(ItemFileName);
        Customer c = CheakIfCustomerExsist(customerArr);
        // Cart cart = ;
        printItemInStore(itemsArr);
        String Answer = "y";
        while (Answer.equalsIgnoreCase("y")) {
            System.out.print("Enter Your Choice item :\n");
            int num = scanner.nextInt();
            Item it = itemsArr.get(num - 1);
            if (num == 0) {
                Menu menu = new Menu();
                menu.MainMenuSecreen();
            } else {

                System.out.println("The item is [ " + it.getItemNumber() + " "
                        + it.getItemName() + ".[" + it.getquantity() + "] ]\n");
            }
            System.out.print("Enter the quantity you need :");
            int QuantityNum = scanner.nextInt();
            if (QuantityNum > it.getquantity()) {
                System.out.println("Sorry , the required quantity is not available , the available quantity is [ "
                        + it.getquantity() + "] Try Again !");
            } else {
                c.getCart().items.add(it);
                // System.out.println(it.getItemName() + " " + it.getItemNumber());
                // System.out.println(c.getCart().getItemCart().get(0).getItemName());
                SaveCItemDataToFile(ItemFileName, itemsArr, it, QuantityNum);

            }
            System.out.println("Do you want to add another item to shopping cart (y/n) ? ");
            Answer = scanner.next();
        }
    }

    // ************* Remove an Item from Customer Shoping Cart ********
    void printItemInShoppingCart(ArrayList<Item> itemsArr) {
        System.out.println("--------------------------------");
        System.out.println("\t Item List In Shopping Cart :");
        System.out.println("--------------------------------");

        int i = 1;
        for (Item item : itemsArr) {
            System.out.println(" >>>> " + i + " . " + item.getItemNumber() + " "
                    + item.getItemName() + ".  [" + item.getquantity() + "]");
            i++;
        }
    }

    public void Remove() {
        ArrayList<Customer> customerArr = LoadDataFromFile(CustomerFileName);
        Customer c = CheakIfCustomerExsist(customerArr);
        Cart cart = c.getCart();
        ArrayList<Item> itemsArr = cart.getItemCart();
        printItemInShoppingCart(itemsArr);
        String choice = "R";
        while (choice.equalsIgnoreCase("R")) {
            System.out.println("What you want to modify ?");
            System.out.println(">>> R. Remove item from shopping cart .");
            System.out.println(">>> M. Return to the main menu .");
            System.out.println("Enter your Choice [R Remove , M Main Menu] :");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("m"))
                break;
            System.out.println("Enter Your item Number:");
            int num = scanner.nextInt();
            Item it = itemsArr.get(num - 1);
            System.out.println("The item is [ " + it.getItemNumber() + " "
                    + it.getItemName() + ".[" + it.getquantity() + "] ] Is Removed from shopping cart .");
            cart.Remove(it);
        }
        if (choice.equalsIgnoreCase("m")) {
            Menu menu = new Menu();
            menu.MainMenuSecreen();
        }

    }
    // ************* View the Item in Customer Shoping Cart ********
    public void View() {
        ArrayList<Customer> customerArr = LoadDataFromFile(CustomerFileName);
        Customer c = CheakIfCustomerExsist(customerArr);
        Cart cart =c.getCart();
        printItemInShoppingCart(cart.getItemCart());
    }

}

// public static void main(String[] args){
// App a=new App();
// ArrayList<Customer> customerArr = a.LoadDataFromFile(a.CustomerFileName);
// Customer c = a.CheakIfCustomerExsist(customerArr);
// Item it=new Item("001", "NN", 5, 5.2);
// c.getCart().add(it);
// a.printItemInShoppingCart(c.getCart().getItemCart());
// Customer c1 = a.CheakIfCustomerExsist(customerArr);
// Item it1=new Item("002", "BB", 5, 5.2);
// c1.getCart().add(it1);
// a.printItemInShoppingCart(c1.getCart().getItemCart());
// }
// }

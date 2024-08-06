import java.util.Scanner;

public class Menu {
    App a = new App();

    int ReadOptionNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option number :");
        int optionNumber = scanner.nextInt();
        return optionNumber;
    }

    void MainMenuSecreen() {
        System.out.println("-------------------------------------");
        System.out.println("\tMain Menu Secreen");
        System.out.println("-------------------------------------");

        System.out.println("[1] Add a new Item to Store");
        System.out.println("[2] Add a new Customer to Store");
        System.out.println("[3] Add an Item to Customer Shoping Cart");
        System.out.println("[4] Remove an Item from Customer Shoping Cart");
        System.out.println("[5] View the items in customer Shoping Cart");
        System.out.println("[6] Modify  Customer data");
        System.out.println("[7] Empty Customer Shoping Cart");
        System.out.println("[8] End shoping and go to checkout");
        System.out.println("[9] Exit the program");
        MenueCase(ReadOptionNumber());
    }

    void MenueCase(int optionNumber) {
        switch (optionNumber) {
            case 1:
                a.addItem();
                MainMenuSecreen();
                break;
            case 2:
                a.addCustomer();
                MainMenuSecreen();
                break;
            case 3:
                a.AddItemToCart();
                MainMenuSecreen();
                break;
            case 4:
                a.Remove();
                break;
            case 5:
                a.View();
                MainMenuSecreen();
                break;

        }
    }
}

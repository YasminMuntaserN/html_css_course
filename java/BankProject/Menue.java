import java.util.Scanner;

public class Menue {
    Scanner scanner = new Scanner(System.in);
    App a = new App();

    public void ShowMainMenue() {
        System.out.println("===========================================\n");
        System.out.println("\t\t Main Menue ");
        System.out.println("===========================================\n");
        System.out.println("\t[1] Show Client List");
        System.out.println("\t[2] Add New Client ");
        System.out.println("\t[3] Delete Client ");
        System.out.println("\t[4] Update Client Info ");
        System.out.println("\t[5] Find Client ");
        System.out.println("\t[6] Transactions");
        System.out.println("\t[7] Log Out");
        System.out.println("===========================================\n");
        MainMenue(MainMenueOption());
    }

    public int MainMenueOption() {
        System.out.print("Choose what do you want to do ? [1 to 8]?");
        int option = scanner.nextInt();
        return option;
    }

    public void MainMenue(int option) {
        switch (option) {
            case 1:
                a.ShowAllClientScreen();
                ShowMainMenue();
                break;
            case 2:
                a.addClients();
                ShowMainMenue();
                break;
            case 3:
                a.Delete();
                ShowMainMenue();
                break;
            case 4:
                a.update();
                ShowMainMenue();
                break;
            case 5:
                a.Find();
                ShowMainMenue();
                break;
            case 6:
                ShowTransactionsMenue();
                ShowMainMenue();
                break;
            case 7:
                break;

        }
    }

    public int TransactionsMenueOption() {
        System.out.print("Choose what do you want to do ? [1 to 4]?");
        int option = scanner.nextInt();
        return option;
    }

    public void ShowTransactionsMenue() {
        System.out.println("===========================================\n");
        System.out.println("\t   Transactions Menue Screen ");
        System.out.println("===========================================\n");
        System.out.println("\t[1] Deposit.");
        System.out.println("\t[2]  Withdraw ");
        System.out.println("\t[3] Total Balances ");
        System.out.println("\t[4] Main Menue . ");
        TransactionsMenue(TransactionsMenueOption());
    }

    public void TransactionsMenue(int option) {
        switch (option) {
            case 1:
                a.Deposite();
                ShowMainMenue();
                break;
            case 2:
                a.Withdraw();
                ShowMainMenue();
                break;
            case 3:
                a.ShowTotalBalancesScreen();
                ShowMainMenue();
                break;
            case 4:
                ShowMainMenue();
                break;
        }
    }
}

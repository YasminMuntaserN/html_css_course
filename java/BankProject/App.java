import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    String ClientsFileName = "G:\\java\\BankProject\\Clients.txt";
    Clients AccountToDelete = null;

    public void printCard(Clients client) {
        System.out.print("--------------------------------------------------\n");
        System.out.print("Acount Number :" + client.getAcountNumber() + "\n");
        System.out.print("Name :" + client.getName() + "\n");
        System.out.print("pin Code :" + client.getpinCode() + "\n");
        System.out.print("phone :" + client.getphone() + "\n");
        System.out.print("Account Balance :" + client.getAccountBalance() + "\n");
        System.out.print("--------------------------------------------------\n");
    }

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

    public Clients ReadNewClinet() {
        Clients client = new Clients();
        System.out.print("\nEnter Account Number : ");
        client.setAcountNumber(scanner.next());
        System.out.print("\nEnter PIN Code : ");
        client.setpinCode(scanner.next());
        System.out.print("\nEnter Name : ");
        client.setName(scanner.next());
        System.out.print("\nEnter Phone : ");
        client.setphone(scanner.next());
        System.out.print("\nEnter  Account Balance : ");
        client.setAccountBalance(scanner.nextInt());
        return client;
    }

    public String convertRecordToline(Clients client, String Seperator) {
        String stClientRecord = "";
        stClientRecord += client.getAcountNumber() + Seperator;
        stClientRecord += client.getpinCode() + Seperator;
        stClientRecord += client.getName() + Seperator;
        stClientRecord += client.getphone() + Seperator;
        stClientRecord += client.getAccountBalance();
        return stClientRecord;
    }

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

    // Add client
    void addNewClient() {
        Clients Clinet = ReadNewClinet();
        AddDateLineToFile(ClientsFileName, convertRecordToline(Clinet, "#//#"));
    }

    void addClients() {
        String AddMore = "y";
        while (AddMore.equalsIgnoreCase("y")) {
            System.out.print("--------------------------------------------------\n");
            System.out.print("\t Add Client  ");
            System.out.print("\n--------------------------------------------------\n");
            System.out.println("Adding New Client : \n\n");
            addNewClient();
            System.out.print("\nClient Added Successfully, do you want to add more clients? Y/N? ");
            AddMore = scanner.next();
        }
    }

    Clients addClinet(String Line) {
        Clients client = new Clients();
        String[] ClientData = Line.split("#//#");
        client.setAcountNumber(ClientData[0]);
        client.setpinCode(ClientData[1]);
        client.setName(ClientData[2]);
        client.setphone(ClientData[3]);
        // int n=(ClientData[4]);
        client.setAccountBalance(convertStringIntoNum(ClientData[4]));// cast string to double
        return client;
    }

    ArrayList<Clients> LoadDataFromFile(String FileName) {
        ArrayList<Clients> AllData = new ArrayList();
        try {
            FileReader reader = new FileReader(FileName);
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while (line != null) {
                AllData.add(addClinet(line));
                line = br.readLine();
            }
            br.close();
            reader.close();
        } catch (Exception IOException) {
            System.out.print("Exception **");
        }
        return AllData;
    }

    // ********************************* print Info ********************
    void printInfo(ArrayList<Clients> AllData) {
        // Clients data;
        System.out.println("------------------------------------------------------");
        for (Clients data : AllData) {
            // data = addClinet(line);
            System.out.print(" | " + data.getAcountNumber() + "            "
                    + " | " + data.getName() + "           "
                    + " | " + data.getphone() + "            "
                    + " | " + data.getpinCode() + "          "
                    + " | " + data.getAccountBalance() + "\n");
            System.out.println("------------------------------------------------------");
        }
    }

    void ShowAllClientScreen() {
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t Client List\t");
        System.out.println("------------------------------------------------------");
        System.out.println(" |Account Number\t   |CLient Name\t   |Phone Number   |pin Code\t |Account Balance\t ");
        printInfo(AllData);
    }

    // ********************************* Delete Client ********************
    public String ReadAccountNum() {
        System.out.println("Enter Account Number ?");
        String Num = scanner.next();
        return Num;
    }

    boolean CheakClientAccountNum(String AccountNum, ArrayList<Clients> AllData) {
        for (Clients c : AllData) {
            if (c.getAcountNumber().equals(AccountNum)) {
                System.out.println(c.getAcountNumber());
                AccountToDelete = c;
                return true;
            }

        }
        return false;
    }

    public void DeleteAccount(String FileName, ArrayList<Clients> AllData, Clients AccountToDelete) {
        try {
            File file = new File(FileName);
            file.delete();
            FileWriter fr = new FileWriter(FileName, true);
            PrintWriter printWriter = new PrintWriter(fr);
            for (Clients c : AllData) {
                if (!(c == AccountToDelete)) {
                    fr.write(convertRecordToline(c, "#//#") + "\n");
                }
            }
            printWriter.close();
            fr.close();
        } catch (Exception IOException) {
            System.out.println("Exception");
        }
    }

    public void Delete() {
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        String Answer;
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t Delete Client \t");
        System.out.println("------------------------------------------------------");
        String AccountNum = ReadAccountNum();
        if (CheakClientAccountNum(AccountNum, AllData)) {
            printCard(AccountToDelete);
            System.out.println("Are You Sure to Updeat this chlient (y ,n) ? ");
            Answer = scanner.next();
            if (Answer.equalsIgnoreCase("y")) {
                DeleteAccount(ClientsFileName, AllData, AccountToDelete);
                System.out.println("Client Updeat Successfuly");
            } else {
                Menue a = new Menue();
                a.ShowMainMenue();
            }
        } else {
            System.out.println("Client Wit Account Number (" + AccountNum + " ) Not Found!");
        }
    }

    // **************** Update Client Info ************
    Clients ReadUpdeatClinetData(String AccountNumber) {
        Clients client = new Clients();
        client.setAcountNumber(AccountNumber);
        System.out.print("\nEnter PIN Code : ");
        client.setpinCode(scanner.next());
        System.out.print("\nEnter Name : ");
        client.setName(scanner.next());
        System.out.print("\nEnter Phone : ");
        client.setphone(scanner.next());
        System.out.print("\nEnter  Account Balance : ");
        client.setAccountBalance(scanner.nextInt());
        return client;
    }

    public void SaveClientsDataToFileAfterUpdeat(String FileName, ArrayList<Clients> AllData, Clients AccountToDelete) {
        try {
            File file = new File(FileName);
            file.delete();
            FileWriter fr = new FileWriter(FileName, true);
            PrintWriter printWriter = new PrintWriter(fr);
            for (Clients c : AllData) {
                if (!(c == AccountToDelete)) {
                    fr.write(convertRecordToline(c, "#//#") + "\n");
                } else {
                    c = ReadUpdeatClinetData(AccountToDelete.getAcountNumber());
                    fr.write(convertRecordToline(c, "#//#") + "\n");
                }
            }
            printWriter.close();
            fr.close();
        } catch (Exception IOException) {
            System.out.println("Exception");
        }
    }

    public void update() {
        String AccountNum = ReadAccountNum();
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        String Answer;
        if (CheakClientAccountNum(AccountNum, AllData)) {
            printCard(AccountToDelete);
            System.out.println("Are You Sure to Updeat this chlient (y ,n) ? ");
            Answer = scanner.next();
            if (Answer.equalsIgnoreCase("y")) {
                SaveClientsDataToFileAfterUpdeat(ClientsFileName, AllData, AccountToDelete);
                System.out.println("Client Updeat Successfuly");
            } else {
                Menue a = new Menue();
                a.ShowMainMenue();
            }
        } else {
            System.out.println("Client Wit Account Number (" + AccountNum + " ) Not Found!");
        }
    }

    // **************** Find Client ***************
    public void Find() {
        String AccountNum = ReadAccountNum();
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        if (CheakClientAccountNum(AccountNum, AllData)) {
            System.out.println("------------------------------------------------------");
            System.out.println("The following are the Client details :");
            System.out.println("------------------------------------------------------");
            printCard(AccountToDelete);
        } else {
            System.out.println("Client Wit Account Number (" + AccountNum + " ) Not Found!");
        }
    }

    // ***************** Transaction ----> Deposite ***********
    public void SaveClientsDataToFile(String FileName, ArrayList<Clients> AllData, Clients AccountToDelete,
            int Amount) {
        File file = new File(FileName);
        file.delete();
        try {
            FileWriter fr = new FileWriter(FileName, true);
            PrintWriter printWriter = new PrintWriter(fr);
            for (Clients c : AllData) {
                if (!(c == AccountToDelete)) {
                    fr.write(convertRecordToline(c, "#//#") + "\n");
                } else {
                    AccountToDelete.setAccountBalance(AccountToDelete.getAccountBalance() + Amount);
                    fr.write(convertRecordToline(c, "#//#") + "\n");
                }
            }
            printWriter.close();
            fr.close();
        } catch (Exception IOException) {
            System.out.println("Exception");
        }
    }

    public void Deposite() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t Deposit Screen");
        System.out.println("------------------------------------------------------");
        String AccountNum = ReadAccountNum();
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        String Answer;
        if (CheakClientAccountNum(AccountNum, AllData)) {
            printCard(AccountToDelete);
            System.out.println("Please Enter deposit amount ?");
            int Amount = scanner.nextInt();
            System.out.print("Are you sure you want perform this Transactions?(y/n)? ");
            Answer = scanner.next();
            if (Answer.equalsIgnoreCase("y")) {
                SaveClientsDataToFile(ClientsFileName, AllData, AccountToDelete, Amount);
                System.out.println("Done Sucessfuly .New balance is: " + AccountToDelete.getAccountBalance());
            } else {
                Menue a = new Menue();
                a.ShowMainMenue();
            }
        } else {
            System.out.println("Client Wit Account Number (" + AccountNum + " ) Not Found!");
        }
    }

    // ***************** Transaction ----> Withdraw ***********
    public void Withdraw() {
        System.out.println("------------------------------------------------------");
        System.out.println("\t Withdraw Screen");
        System.out.println("------------------------------------------------------");
        String AccountNum = ReadAccountNum();
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        String Answer;
        if (CheakClientAccountNum(AccountNum, AllData)) {
            printCard(AccountToDelete);
            System.out.println("Please Enter deposit amount ?");
            int Amount = scanner.nextInt();
            System.out.print("Are you sure you want perform this Transactions?(y/n)? ");
            Answer = scanner.next();
            if (Answer.equalsIgnoreCase("y")) {
                SaveClientsDataToFile(ClientsFileName, AllData, AccountToDelete, (-Amount));
                System.out.println("Done Sucessfuly .New balance is: " + AccountToDelete.getAccountBalance());
            } else {
                Menue a = new Menue();
                a.ShowMainMenue();
            }
        } else {
            System.out.println("Client Wit Account Number (" + AccountNum + " ) Not Found!");
        }
    }

    // ***************** Transaction ----> Total Balances ***********
    int countTotalBalance(ArrayList<Clients> AllData){
        int total=0;
        for(Clients client : AllData){
            total += client.getAccountBalance();
        }
        return total;
    }
    void TotalBalancesInfo(ArrayList<Clients> AllData) {
        System.out.println("------------------------------------------------------");
        for (Clients data : AllData) {
            System.out.print(" | " + data.getAcountNumber() + "            "
                    + " | " + data.getName() + "           "
                    + " | " + data.getAccountBalance() + "\n");
            System.out.println("------------------------------------------------------");
        }
    }

    void ShowTotalBalancesScreen() {
        ArrayList<Clients> AllData = LoadDataFromFile(ClientsFileName);
        System.out.println("------------------------------------------------------");
        System.out.println("\t\t Balance List "+AllData.size()+" clients\t");
        System.out.println("------------------------------------------------------");
        System.out.println(" |Account Number\t   |CLient Name\t   |Phone Number   |pin Code\t |Account Balance\t ");
        TotalBalancesInfo(AllData);
        System.out.println("\t\tTotal Balance = " + countTotalBalance(AllData));
    }
}

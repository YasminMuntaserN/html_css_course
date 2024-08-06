import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Clients {
    private String AcountNumber;
    private String pinCode;
    private String name;
    private String phone;
    private int AccountBalance;
    private Clients MarkForDelete ;

    public Clients() {
    }

    public Clients(String acountNumber, String pinCode, String name, String phone, int AccountBalance) {
        this.AcountNumber = acountNumber;
        this.pinCode = pinCode;
        this.name = name;
        this.phone = phone;
        this.AccountBalance = AccountBalance;
    }

    public String getAcountNumber() {
        return AcountNumber;
    }

    public void setAcountNumber(String AcountNumber) {
        this.AcountNumber = AcountNumber;
    }

    public String getpinCode() {
        return pinCode;
    }

    public void setpinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public int getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(int AccountBalance) {
        this.AccountBalance = AccountBalance;
    }

    public Clients getMarkForDelete() {
        return MarkForDelete;
    }

    public void setMarkForDelete(Clients MarkForDeleat) {
        this.MarkForDelete = MarkForDeleat;
    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Bank {

    // public static void write() throws IOException {
    // File file = new File("G:\\java\\BankProject\\test.txt");
    // FileWriter fr = new FileWriter(file, true);
    // PrintWriter printWriter = new PrintWriter(fr);
    // printWriter.println("yasmin ");
    // printWriter.println("yasmin ");
    // printWriter.close();
    // fr.close();
    // }

    // public static void read() throws IOException {
    // File file = new File("G:\\java\\BankProject\\test.txt");
    // FileReader reader = new FileReader(file);
    // BufferedReader br =new BufferedReader(reader);
    // String content="";
    // String line = br.readLine();
    // while(line != null){
    // content+=line +"\n";
    // line = br.readLine();
    // }
    // System.out.println(content);
    // br.close();

    // }


    public static void main(String[] args) throws IOException {
        Menue menue = new Menue();
        menue.ShowMainMenue();
    }
}

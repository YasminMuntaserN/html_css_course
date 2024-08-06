import java.util.Scanner;

public class Book extends Item {
    private String BookTitle;
    private String AuthorName;
    
public Book(String ItemNumber , String ItemName,int quantity,Double Price){
    super(ItemNumber,ItemName,quantity,Price);
}
    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public String getBookTitle() {
        return this.BookTitle;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public String getItemName() {
        return this.AuthorName;
    }

    public void BookInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Book Title :");
        setBookTitle(scanner.next());
        System.out.println("Enter the Author Name :");
        setAuthorName(scanner.next());
        scanner.close();
    }

}

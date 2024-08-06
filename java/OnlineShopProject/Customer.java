public class Customer {
    private String CustomerNumber;
    private String CustomerName;
    private Cart cart ;
    boolean MarkedCustomer = false;

    public Customer() {
        this.CustomerName="";
        this.CustomerNumber="";
        this.cart = new Cart();
    }

    public Customer(String CustomerNumber, String CustomerName) {
        this.CustomerNumber = CustomerNumber;
        this.CustomerName = CustomerName;
        this.cart = new Cart();
    }

    public void setCustomerNumber(String CustomerNumber) {
        this.CustomerNumber = CustomerNumber;
    }

    public String getCustomerNumber() {
        return this.CustomerNumber;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerName() {
        return this.CustomerName;
    }

    public Cart getCart() {
        return this.cart;
    }

}

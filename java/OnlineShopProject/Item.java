public class Item {
    private String ItemNumber;
    private String ItemName;
    private int quantity;
    private Double Price;

    public Item(){}
    public Item(String ItemNumber , String ItemName,int quantity,Double Price){
         this.ItemNumber = ItemNumber;
         this.ItemName = ItemName;
         this.quantity = quantity;
         this.Price = Price;
    }

    public void setItemNumber(String ItemNumber) {
        this.ItemNumber = ItemNumber;
    }

    public String getItemNumber() {
        return this.ItemNumber;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemName() {
        return this.ItemName;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public int getquantity() {
        return this.quantity;
    }
        public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Double getPrice() {
        return this.Price;
    }


}
import java.util.ArrayList;

public class Cart {
     final ArrayList<Item> items ;
    
    public Cart(){
        items =new ArrayList<Item>();
    }

    void add(Item item) {
        items.add(item);
    }

    void Remove(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItemCart() {
        return this.items;
    }
}
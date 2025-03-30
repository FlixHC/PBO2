public class product {
    String name ;
    double price;

    public product(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    //Menambahkan get set untuk fungsi edit
    
    public void getName (String name){
        this.name = name;
    }
    
    public void getPrice (double price){
        this.price = price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice (double price) {
        this.price = price;
    }
}

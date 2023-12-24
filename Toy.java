public class Toy {
    private int id;
    private final String name_toy;
    private int quantity;
    private double weight;

    public Toy(int id, String name_toy, int quantity, double weight){
        this.id = id;
        this.name_toy = name_toy;
        this.quantity = quantity;
        this.weight = weight;
    }
    public int getId(){
        return id;
    }
    public String getName_toy(){
        return name_toy;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }


}

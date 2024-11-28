package org.example.entity;

public class Marfa {
    private int id;
    private String name;
    private String type;
    private String amount;

    public Marfa() {};
    public Marfa(int id, String name, String type, String amount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amount = amount;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getAmount() {return amount;}
    public void setAmount(String amount) {this.amount = amount;}

    @Override
    public String toString(){
        return "id: "+id+" name: "+name+" type: "+type+" amount: "+amount;
    }
}

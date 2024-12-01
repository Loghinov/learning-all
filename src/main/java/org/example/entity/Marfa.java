package org.example.entity;

public class Marfa {
    private int marfaId;
    private String marfaName;
    private String marfaType;
    private String marfaAmount;

    public Marfa() {};

    public Marfa(int id, String name, String type, String amount) {
        this.marfaId = id;
        this.marfaName = name;
        this.marfaType = type;
        this.marfaAmount = amount;
    }
    public int getId() {return marfaId;}
    public void setId(int id) {this.marfaId = id;}
    public String getName() {return marfaName;}
    public void setName(String name) {this.marfaName = name;}
    public String getType() {return marfaType;}
    public void setType(String type) {this.marfaType = type;}
    public String getAmount() {return marfaAmount;}
    public void setAmount(String amount) {this.marfaAmount = amount;}

    @Override
    public String toString(){
        return "id: "+marfaId+" name: "+marfaName+" type: "+marfaType+" amount: "+marfaAmount;
    }
}

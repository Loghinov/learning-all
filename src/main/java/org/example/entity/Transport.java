package org.example.entity;

public class Transport {
    private int id;
    private String transportName;
    private String transportType;
    private String transportDescription;

    public Transport() {};

    public Transport(int id, String transportName, String transportType, String transportDescription) {
        this.id = id;
        this.transportName = transportName;
        this.transportType = transportType;
        this.transportDescription = transportDescription;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getTransportName() {return transportName;}
    public void setTransportName(String transportName) {this.transportName = transportName;}
    public String getTransportType() {return transportType;}
    public void setTransportType(String transportType) {this.transportType = transportType;}
    public String getTransportDescription() {return transportDescription;}
    public void setTransportDescription(String transportDescription) {this.transportDescription = transportDescription;}

    @Override
    public String toString() {
        return " Transport id: "+id+" TransportName: "+transportName+" TransportType: "+transportType+" TransportDescription: "+transportDescription;
    }
}


package me.spiochu.blockchain;

public class Data {
    private String sender;
    private String reciver;
    private String data;

    public Data(String sender, String reciver, String data) {
        this.sender = sender;
        this.reciver = reciver;
        this.data = data;
    }

    public String getSender() {
        return sender;
    }

    public String getReciver() {
        return reciver;
    }

    public String getData() {
        return data;
    }
}

package me.spiochu.blockchain.BlockChainCore;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Data {
    private String sender;
    private String receiver;
    private String data;

    public Data(String sender, String receiver, String data) {
        this.sender = sender;
        this.receiver = receiver;
        this.data = Base64.getEncoder().encodeToString(data.getBytes());

    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Data{" +
                  sender + ':' +
                  receiver + ':' +
                  data +
                '}';
    }
}

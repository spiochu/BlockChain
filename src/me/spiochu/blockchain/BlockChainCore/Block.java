package me.spiochu.blockchain.BlockChainCore;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class Block implements Serializable {
    private int index;
    private long timestamp;
    private String hash;
    private String previousHash;
    private ArrayList<Data> dataList = new ArrayList<>();

    //constructor creating a block using index, hash of previous block and list of data
    public Block(int index,String previousHash, ArrayList<Data> dataList) {
        this.index = index;
        this.previousHash = previousHash;
        for (Data d:dataList
             ) {
            this.dataList.add(d);

        }
        this.timestamp = System.currentTimeMillis();
        this.hash = generateHash();
    }

    public Block(String blockString) {
        String[] parts =  blockString.split("DATALIST");
        String[] firstPart = parts[0].split(",");
        this.index = Integer.valueOf(firstPart[0]);
        this.timestamp = Long.valueOf(firstPart[1]);
        this.hash = firstPart[2];
        this.previousHash = firstPart[3];
        String[] secondPart = parts[1].split("\\W");

        ArrayList<Data> dataArrayList = new ArrayList<>();
        for (int i = 0; i < secondPart.length; i++) {
            if (secondPart[i].equals("Data")){
                Data newData = new Data(secondPart[i+1],secondPart[i+2],decodeBase64formString(secondPart[i+3]));
                dataArrayList.add(newData);
            }
        }
        this.dataList = dataArrayList;
    }

    //return index of block
    public int getIndex() {
        return index;
    }

    //generating hash od block using index, timestamp, list of data
    private String generateHash() {
            String data = index + timestamp + previousHash;
            for (Data d:dataList
            ) {
                data += d.toString();
            }

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte bytes[] = digest.digest(data.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b :bytes){
                String hex = Integer.toHexString(0xff &b);
                if (hex.length() == 0){
                    hexString.append(0);
                }
                hexString.append(hex);
            }
            return String.valueOf(hexString);
    }

    //return a hash of previous block
    public String getPreviousHash() {
        return previousHash;
    }

    //return a hash of block
    public String getHash() {
        return generateHash();
    }

    @Override
    public String toString() {
        return  index +
                "," + timestamp +
                "," + hash  +
                "," + previousHash  +
                ", DATALIST[" + dataList +
                ']';
    }

    private String decodeBase64formString(String s){
        byte[] rawData = Base64.getDecoder().decode(s);
        String decodedData = new String(rawData);
        return decodedData;

    }
}

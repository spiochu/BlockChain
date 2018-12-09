package me.spiochu.blockchain.BlockChainCore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private String hash;
    private String previousHash;
    private List<Data> dataList;


    //constructor creating a block using index, hash of previous block and list of data
    public Block(int index,String previousHash, List<Data> dataList) {
        this.index = index;
        this.previousHash = previousHash;
        this.dataList = dataList;
        this.timestamp = System.currentTimeMillis();
        this.hash = generateHash();
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
        return "Block{" +
                "index=" + index +
                ", timestamp=" + timestamp +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", dataList=" + dataList +
                '}';
    }
}

package me.spiochu.blockchain.BlockChainCore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private String hash;
    private String previusHash;
    private List<Data> dataList;


    public Block(int index,String previusHash, List<Data> dataList) {
        this.index = index;
        this.previusHash = previusHash;
        this.dataList = dataList;
        this.timestamp = System.currentTimeMillis();
        this.hash = generateHash();
    }

    public int getIndex() {
        return index;
    }

    private String generateHash() {
            String data = index + timestamp + previusHash;
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

    public String getHash() {
        return hash;
    }
}

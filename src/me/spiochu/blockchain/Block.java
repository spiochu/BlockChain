package me.spiochu.blockchain;

import java.util.List;

public class Block {
    private String hash;
    private String previusHash;
    private List<Data> dataList;

    public Block(String previusHash, List<Data> dataList) {
        this.previusHash = previusHash;
        this.dataList = dataList;
    }

    public String getHash() {
        return hash;
    }
}

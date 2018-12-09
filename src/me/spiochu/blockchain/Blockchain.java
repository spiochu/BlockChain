package me.spiochu.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain = new ArrayList<>();

    public Blockchain(Block genesisBlock) {
        this.blockchain.add(genesisBlock);
    }

    public void addBlock(Block block){
        this.blockchain.add(block);
    }

    public int getBlockchainLenght(){
        return this.blockchain.size();
    }

    public Block getLastBlock(){
        return this.blockchain.get(-1);
    }
}

package me.spiochu.blockchain.BlockChainCore;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain = new ArrayList<>();

    public Blockchain() {
        createGennesisBlock();
    }

    public void addBlock(List<Data> data){
        Block temp = getLastBlock();
        this.blockchain.add(new Block(temp.getIndex()+1,temp.getHash(),data));
    }

    private void createGennesisBlock(){
        blockchain.add(new Block(0,"0",new ArrayList<>()));
    }

    public int getBlockchainLenght(){
        return this.blockchain.size();
    }

    public Block getLastBlock(){
        return this.blockchain.get(getBlockchainLenght()-1);
    }
}

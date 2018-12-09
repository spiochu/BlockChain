package me.spiochu.blockchain.BlockChainCore;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain = new ArrayList<>();

    //constructor generate genesis block
    public Blockchain() {
        createGenesisBlock();
    }

    //creating block using data and add it to blockchain
    public void addBlock(List<Data> data){
        Block temp = getLastBlock();
        this.blockchain.add(new Block(temp.getIndex()+1,temp.getHash(),data));
    }

    //creating genesis block
    private void createGenesisBlock(){
        blockchain.add(new Block(0,"0",new ArrayList<>()));
    }

    //return a blockchain length
    public int getBlockchainLength(){
        return this.blockchain.size();
    }

    //return last block in blockchain
    public Block getLastBlock(){
        return this.blockchain.get(getBlockchainLength()-1);
    }

    //return all blocks of blockchain
    public List<Block> getAllBlocks() {
        return blockchain;
    }
}

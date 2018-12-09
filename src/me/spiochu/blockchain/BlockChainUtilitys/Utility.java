package me.spiochu.blockchain.BlockChainUtilitys;

import me.spiochu.blockchain.BlockChainCore.Block;
import me.spiochu.blockchain.BlockChainCore.Blockchain;

public class Utility {
    private Blockchain blockchain;


    public Utility(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    public boolean isValid(){
        String temp = "0";
        for (Block b:blockchain.getAllBlocks()
             ) {
            if (!temp.equals("0")){
                if (!b.getPreviousHash().equals(temp)){
                    return false;
                }
            }
            temp = b.getHash();
        }
        return true;
    }
    public void printBlockchain(){
        for (Block b: blockchain.getAllBlocks()
             ) {
            System.out.println(b);

        }
    }
}

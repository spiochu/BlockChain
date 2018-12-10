package me.spiochu.blockchain.BlockChainUtilitys;

import me.spiochu.blockchain.BlockChainCore.Block;
import me.spiochu.blockchain.BlockChainCore.Blockchain;
import me.spiochu.blockchain.BlockChainCore.Data;

import java.io.*;
import java.util.ArrayList;

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

    public boolean saveBlockchainToFile(String fileName) {
        System.out.println("Writing a block to file...");
        try (FileWriter fileWriter = new FileWriter(fileName);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                 PrintWriter out = new PrintWriter(bufferedWriter)) {

                 for (Block b: blockchain.getAllBlocks()
                    ) {
                    out.println(b);
                 }

        } catch (Exception e) {
                System.out.println("ERROR: UNABLE TO SAVE BLOCK TO DATABASE!");
                e.printStackTrace();
                return false;
        }
        return true;
    }

    public boolean reaBlockchainFromFile(String fileName){
        System.out.println("Reading from file ...");
        Blockchain temp = new Blockchain(false);
        FileReader fileReader = null;
        String line;
        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: UNABLE TO OPEN BLOCKCHAIN FILE!");
            return false;
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferedReader.readLine()) != null){
                    temp.addBlock(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.blockchain = temp;
        return true;
    }

    public void addBlock(ArrayList<Data> data) {
        this.blockchain.addBlock(data);
    }

    public void printLastBlock() {
        Block lastBlock = this.blockchain.getLastBlock();
        System.out.println(lastBlock);
    }
}


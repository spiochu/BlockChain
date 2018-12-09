package me.spiochu.blockchain;

import me.spiochu.blockchain.BlockChainCore.Blockchain;
import me.spiochu.blockchain.BlockChainCore.Data;
import me.spiochu.blockchain.BlockChainUtilitys.Utility;

import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(true);
        ArrayList<Data> dataList = new ArrayList<>();
        Data data = new Data("Tomek","Damian","Hello");
        dataList.add(data);
        blockchain.addBlock(dataList);
        dataList.add(new Data("Damian","Tomek","hejka"));
        blockchain.addBlock(dataList);
        dataList = new ArrayList<Data>();
        dataList.add(new Data("Damian","ALL","hejka"));
        blockchain.addBlock(dataList);
        dataList.add(new Data("Tomek","ALL","Hello ALL"));
        blockchain.addBlock(dataList);

        Utility utility = new Utility(blockchain);
        utility.printBlockchain();
        utility.saveBlockchainToFile("blockchain.txt");
        Utility utility1 = new Utility(new Blockchain(false));
        utility1.reaBlockchainFromFile("blockchain.txt");
        utility1.printBlockchain();

    }


}

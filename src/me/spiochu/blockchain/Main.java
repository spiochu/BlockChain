package me.spiochu.blockchain;

import me.spiochu.blockchain.BlockChainCore.Block;
import me.spiochu.blockchain.BlockChainCore.Blockchain;
import me.spiochu.blockchain.BlockChainCore.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        List<Data> dataList = new ArrayList<>();
        Data data = new Data("Tomek","Damian","Hello");
        dataList.add(data);
        blockchain.addBlock(dataList);
        blockchain.addBlock(dataList);
        blockchain.addBlock(dataList);
        blockchain.addBlock(dataList);

    }
}

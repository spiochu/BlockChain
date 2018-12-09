package me.spiochu.blockchain;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Block genesisBlock = new Block("0",new ArrayList<Data>());
        Blockchain blockchain = new Blockchain(genesisBlock);

    }
}

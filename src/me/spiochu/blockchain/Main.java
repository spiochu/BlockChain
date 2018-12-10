package me.spiochu.blockchain;

import me.spiochu.blockchain.BlockChainCore.Blockchain;
import me.spiochu.blockchain.BlockChainCore.Data;
import me.spiochu.blockchain.BlockChainUtilitys.Utility;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.println("---------------------");
        System.out.println("- 1. New Blockchain -");
        System.out.println("- 2. Read Blockchain-");
        System.out.println("- 3. The End        -");
        System.out.println("---------------------");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                createNewBlockchain();
                break;
            case 2:
                readBlockchainFromFile();
                break;
            case 3:
                return ;
        }

    }

    private static void readBlockchainFromFile() {
        Blockchain blockchain = new Blockchain(false);
        Utility utility = new Utility(blockchain);
        System.out.println("Type filename to read blockchain :");
        Scanner scanner = new Scanner(System.in);
        utility.reaBlockchainFromFile(scanner.next());
        utility.printBlockchain();
        while (true){
            System.out.println("-----------------------");
            System.out.println("- 1. Add block        -");
            System.out.println("- 2. Read last block  -");
            System.out.println("- 3. Print all blocks -");
            System.out.println("- 4. Save to file     -");
            System.out.println("- 5. Quit             -");
            System.out.println("-----------------------");
            switch (scanner.nextInt())
            {
                case 1:
                    utility.addBlock(getDataArray());
                    break;
                case 2:
                    utility.printLastBlock();
                    break;
                case 3:
                    utility.printBlockchain();
                    break;
                case 4:
                    System.out.println("Type a file name to save blockchain:");
                    utility.saveBlockchainToFile(scanner.next());
                    break;
                case 5:
                    return;
            }
        }
    }

    private static ArrayList<Data> getDataArray() {
        Scanner scanner = new Scanner(System.in);
        boolean next = true;
        System.out.println("Add data to block");
        ArrayList<Data> temp = new ArrayList<>();
        do {
            System.out.println();
            System.out.print("Sender:");
            String sender = scanner.next();
            System.out.print("Receiver:");
            String receiver = scanner.next();
            System.out.print("Data:");
            String data = scanner.next();
            temp.add(new Data(sender,receiver,data));
            System.out.println("End adding data?(Y/N)");
            if (scanner.next().equals("Y")){
                next = false;
            }
        }while (next);
        return temp;
    }

    private static void createNewBlockchain() {
        Blockchain blockchain = new Blockchain(true);
        Utility utility = new Utility(blockchain);
        while (true){
            System.out.println("-----------------------");
            System.out.println("- 1. Add block        -");
            System.out.println("- 2. Read last block  -");
            System.out.println("- 3. Print all blocks -");
            System.out.println("- 4. Save to file     -");
            System.out.println("- 5. Quit             -");
            System.out.println("-----------------------");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt())
            {
                case 1:
                    utility.addBlock(getDataArray());
                    break;
                case 2:
                    utility.printLastBlock();
                    break;
                case 3:
                    utility.printBlockchain();
                    break;
                case 4:
                    System.out.println("Type a file name to save blockchain:");
                    utility.saveBlockchainToFile(scanner.next());
                    break;
                case 5:
                    return;
            }
        }
    }


}

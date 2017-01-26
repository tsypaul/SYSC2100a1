package com.company;

import java.util.Scanner;

public class ConfigurationCounting {
    // declare variables
    private static int no_of_nodes, no_of_channels, sum;

    public static int factorial(int n){
        return n==1? 1 : factorial(n-1)*n;
    } //Calculate factorial

    public static int binomial(int n, int k){
        return k==0? 1 : factorial(n)/factorial(k)/factorial(n-k);
    } // Calculate binomial coefficient

    public static void generateCombinations (int Nodes, int currentChannel, int[] combinations){
        if (currentChannel == no_of_channels-1){
            combinations[currentChannel] = Nodes; // Assign all the nodes to last channel
            int binomial = binomial(no_of_nodes,no_of_nodes-combinations[currentChannel]); // Calculate the combination of a specific combination
            sum += binomial;
            print(binomial, combinations);
        }else{
            for(int i=0; i<= Nodes; i++){
                combinations[currentChannel] = i;
                generateCombinations(Nodes-i, currentChannel+1, combinations); // recursive call
            }
        }
    }
    // print message method
    public static void print (long numberOfSets, int[] combinations){
        System.out.print(numberOfSets+" set(s) with occupancies: ");
        for (int i=0; i<combinations.length; i++){
            System.out.print(combinations[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // prompt user input
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the number of nodes: ");
        no_of_nodes = reader.nextInt();
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the number of channels");
        no_of_channels = s.nextInt();
        // create array for generateCombinations
        int[] comb = new int[no_of_channels];
        System.out.println(no_of_nodes + " Nodes, " + no_of_channels + " Channels:");
        generateCombinations(no_of_nodes, 0, comb);
        System.out.println("Total number of assignment: " + sum);
    }
}
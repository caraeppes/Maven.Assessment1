package com.zipcodewilmington.assessment1.part4;

public class Jumper {

    /*
     * Complete the function below.
     */
    public Integer jumps(int k, int j) {
        int totalJumps = 0;
        if (j > k){
            return k;
        }
        int jJumps = (int)Math.floor(k/j);

        while (((jJumps * j) + totalJumps) < k){
            totalJumps++;
        }
        totalJumps += jJumps;
        return totalJumps;
    }
}

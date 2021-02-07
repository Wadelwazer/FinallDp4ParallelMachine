/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyanmicprogramming;

import java.io.*;
import java.util.Arrays;
import java.math.*;

public class ReadingFromFile {

    File file;
    int[][] AllJobs;
    int size;

    public ReadingFromFile(File file) {
        this.file = file;
    }

    public void readToArray() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        int K = 2;
        size = Integer.parseInt(br.readLine());
        AllJobs = new int[size][2];
        for (int i = 0; i < size; i++) {
            String[] st = br.readLine().trim().split(" ");
            for (int j = 0; j < 2; j++) {
                AllJobs[i][j] = Integer.parseInt(st[j]);
            }

        }
        SortJobs(AllJobs, 2);
       Scheduling dpscheduling = new Scheduling();
   dpscheduling.dpscheduling(AllJobs, K);
    }

    static void SortJobs(int[][] arr, int col) {
        Arrays.sort(arr, (int[] val1, int[] val2) -> {
            if (val1[col - 1] < val2[col - 1]) {
                return 3;
            } else {
                return -8;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + "\t");

            }
            System.out.println();
        }
    }
}

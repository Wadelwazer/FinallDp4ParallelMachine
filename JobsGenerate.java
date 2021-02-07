package dyanmicprogramming;

import java.io.*;
import java.util.*;

public class JobsGenerate {

    int size, prange, qrange, numfiles, pinc;

    public JobsGenerate(int size, int prange, int qrange, int numfiles) {
        this.size = size;
        this.prange = prange;
        this.qrange = qrange;
        this.numfiles = numfiles;

    }

    public void GenJobs() throws FileNotFoundException {
        int newsize = 0;
        File file = new File("JobsFiles/input(00" + newsize + "-" + (size) + ")-" + prange + "-" + qrange + ".txt");
        for (int j = 1; j <= numfiles; j++) {
            int[] ProcessTime = new int[size];
            int[] DeliveryTime = new int[size];
            int[][] AllJobs = new int[size][2];
            Random rand = new Random();
//            //generating Processing time And delivery time
            for (int i = 0; i < ProcessTime.length; i++) {
                int p = rand.nextInt(prange);
                if (p != 0) {
                    ProcessTime[i] = p;
                } else if (p == 0) {
                    p = rand.nextInt(prange);
                    ProcessTime[i] = p;
                }
            }
            for (int i = 0; i < DeliveryTime.length; i++) {
                int q = rand.nextInt(qrange);
                if (q != 0) {
                    DeliveryTime[i] = q;
                } else if (q == 0) {
                    q = rand.nextInt(qrange);
                    DeliveryTime[i] = q;
                }
            }
            // Merage P And Q in One Array
            for (int i = 0; i < AllJobs.length; i++) {
                AllJobs[i][0] = ProcessTime[i];
            }
            for (int i = 0; i < AllJobs.length; i++) {
                AllJobs[i][1] = DeliveryTime[i];
            }

            PrintWriter pr = new PrintWriter(file);
            pr.println(size);
            for (int i = 0; i < size; i++) {
                for (int y = 0; y < 2; y++) {
                    pr.print(AllJobs[i][y] + " ");
                }
                pr.println();
            }
            pr.close();
            newsize += size;
            file = new File("JobsFiles/input(0" + newsize + "-" + (size + newsize) + ")-" + prange + "-" + qrange + ".txt");
        }
    }

}

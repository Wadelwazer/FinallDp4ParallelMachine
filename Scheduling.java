/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyanmicprogramming;

import java.util.HashSet;
import dyanmicprogramming.Triplet;

public class Scheduling {


    public void dpscheduling(int[][] jobs, int K) {
        HashSet<Triplet> previousSet = new HashSet<Triplet>();
        previousSet.add(new Triplet(K - 1, (jobs[0][0] + jobs[0][1]), jobs[0][0]));
        HashSet<Triplet> currentSet = null;
        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i][0]);
        }
        for (int j = 1; j < jobs.length; j++) {

            System.out.println("\n\nj=" + jobs[j][0]);

            currentSet = new HashSet<Triplet>();

            for (Triplet t : previousSet) {
                System.out.println("from " + t + " : ");

                Triplet t1 = new Triplet(t.getK(), Math.max((int) t.getLMax(), ((int) t.getCMax() + (int) jobs[j][0] + (int) jobs[j][1])), ((int) t.getCMax() + (int) jobs[j][0]));
                currentSet.add(t1);
                System.out.println("with M" + t.getK() + " : " + t1);
                Triplet t2;
                int newLMax = Math.max((int) t.getLMax(), lMax(jobs, j, (int) t.getCMax()));

                if (cMaxStaysOnTheSameMachineAfterJobAffectation((int) t.getCMax(), jobs, j)) {
                    t2 = new Triplet(t.getK(), newLMax, t.getCMax());
                } else {
                    t2 = new Triplet((1 - (int) t.getK()), newLMax, newCMax(jobs, j, (int) t.getCMax()));
                }

                currentSet.add(t2);
                System.out.println("with M" + (1 - (int) t.getK()) + " : " + t2);
                previousSet = keepBestStates(currentSet);
                System.out.println(previousSet);
            }

            previousSet = keepOnlyNotDominatedStates(currentSet);

            System.out.println("DP: " + previousSet);
        }

    }

    private static int lMax(int[][] jobs, int j, int cMax) {

        int lMax = 0;
        for (int i = 0; i <= j; i++) {
            lMax += jobs[i][0];
        }
        lMax = lMax - cMax + jobs[j][1];

        return lMax;
    }

    private static boolean cMaxStaysOnTheSameMachineAfterJobAffectation(int cMax, int[][] jobs, int j) {

        int leftValue = cMax;
        int rightValue = -cMax;

        for (int i = 0; i <= j; i++) {
            rightValue += jobs[i][0];
        }
        return leftValue >= rightValue;
    }

    private static int newCMax(int[][] jobs, int j, int cMax) {

        int newCMax = 0;
        for (int i = 0; i <= j; i++) {
            newCMax += jobs[i][0];
        }
        newCMax = newCMax - cMax;

        return newCMax;
    }

    private static HashSet<Triplet> keepBestStates(HashSet<Triplet> currentSet) {
        HashSet<Triplet> newSet = new HashSet<Triplet>();

        for (Triplet t : currentSet) {
            boolean found = false;
            int k = (int) t.getK();
            int cMax = (int) t.getCMax();
            int lMax = (int) t.getLMax();
            for (Triplet target : newSet) {
                if ((int) target.getCMax() == cMax && (int) target.getK() == k) {
                    found = true;
                    if ((int) target.getLMax() > lMax) {

                        newSet.remove(target);
                        newSet.add(t);
                    }
                    break;
                }
            }
            if (!found) {
                newSet.add(t);
            }
        }

        return newSet;
    }

    private static HashSet<Triplet> keepOnlyNotDominatedStates(HashSet<Triplet> currentSet) {
        HashSet<Triplet> newSet = new HashSet<Triplet>();

        for (Triplet t : currentSet) {
            int k = (int) t.getK();
            int cMax = (int) t.getCMax();
            int lMax = (int) t.getLMax();
            if (newSet.isEmpty()) {
                newSet.add(t);
            } else {
                boolean added = false;
                boolean dominated = false;
                HashSet<Triplet> toRemoveSet = new HashSet<Triplet>();
                for (Triplet target : newSet) {
                    if (cMax == (int) target.getCMax() && lMax == (int) target.getLMax()) {
                        if ((int) target.getK() != k && !newSet.contains(t)) {
                            newSet.add(t);
                            added = true;
                        } else {
                            dominated = true;
                        }
                        break;
                    } else if (cMax <= (int) target.getCMax() && lMax <= (int) target.getLMax()) {
                        toRemoveSet.add(target);

                    } else if (cMax >= (int) target.getCMax() && lMax >= (int) target.getLMax()) {
                        dominated = true;
                    }
                }
                if (!dominated && !added) {
                    newSet.add(t);
                }
                for (Triplet tTR : toRemoveSet) {
                    newSet.remove(tTR);
                }
            }
        }

        return newSet;
    }
}

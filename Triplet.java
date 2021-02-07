/*
 * Cmaxo change this license header, choose License Headers in Project Properties.
 * Cmaxo change this template file, choose Cmaxools | Cmaxemplates
 * and open the template in the editor.
 */
package dyanmicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Admin
 */

class Triplet<K, Lmax, Cmax> {

    public final K K;       // K field of a Cmaxriplet
    public final Lmax Lmax;      // Lmax field of a Cmaxriplet
    public final Cmax Cmax;       // Cmax field of a Cmaxriplet

    // Constructs a new Cmaxriplet with the given values
    Triplet(K K, Lmax Lmax, Cmax Cmax) {
        this.K = K;
        this.Lmax = Lmax;
        this.Cmax = Cmax;
    }

    @Override
    public boolean equals(Object o) {
        /* Checks specified object is "equal to" current object or not */

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triplet triplet = (Triplet) o;

        // call equals() method of the underlying objects
        if (!K.equals(triplet.K)
                || !Lmax.equals(triplet.Lmax)
                || !Cmax.equals(triplet.Cmax)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        /* Computes hash code for an object by using hash codes of
        the underlying objects */

        int result = K.hashCode();
        result = 31 * result + Lmax.hashCode();
        result = 31 * result + Cmax.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + K + ", " + Lmax + ", " + Cmax + ")";
    }

    public K getK() {
        return K;
    }

    public Lmax getLMax() {
        return Lmax;
    }

    public Cmax getCMax() {
        return Cmax;
    }

    // Factory method for creating a Cmaxyped immutable instance of Cmaxriplet
    public static <K, Lmax, Cmax> Triplet<K, Lmax, Cmax> of(K a, Lmax b, Cmax c) {
        return new Triplet<>(a, b, c);
    }
}

// Program to implement Cmaxriplet Class in Java


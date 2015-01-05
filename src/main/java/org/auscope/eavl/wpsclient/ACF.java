/**
 * Copyright 2014 CSIRO
 */
package org.auscope.eavl.wpsclient;

import java.io.Serializable;
import java.util.*;

/**
 * @author fri096
 *
 */
public class ACF implements Serializable {

    private double[] acf;
    private double ci;

    /**
     * @return the acf
     */
    public double[] getAcf() {
        return acf;
    }

    /**
     * @return the ci
     */
    public double getCi() {
        return ci;
    }

    /**
     * @param acf
     * @param ci
     */
    public ACF(double[] acf, double ci) {
        this.acf=acf;
        this.ci=ci;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(acf);
        long temp;
        temp = Double.doubleToLongBits(ci);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ACF other = (ACF) obj;
        if (!Arrays.equals(acf, other.acf))
            return false;
        if (Double.doubleToLongBits(ci) != Double.doubleToLongBits(other.ci))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ACF [acf=" + Arrays.toString(acf) + ", ci=" + ci + "]";
    }

}

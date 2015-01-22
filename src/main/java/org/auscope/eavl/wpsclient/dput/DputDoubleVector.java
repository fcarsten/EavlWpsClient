/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fri096
 *
 */
public class DputDoubleVector implements Dput {

    private double[] val;

    /**
     * @return the val
     */
    public double[] getVal() {
        return val;
    }

    /**
     * @param val the val to set
     */
    public void setVal(double[] val) {
        this.val = val;
    }

    public DputDoubleVector(ArrayList<Double> res) {
        val = new double[res.size()];
        for (int i = 0; i < val.length; i++) {
            val[i]=res.get(i);
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return  Arrays.toString(val) ;
    }

}

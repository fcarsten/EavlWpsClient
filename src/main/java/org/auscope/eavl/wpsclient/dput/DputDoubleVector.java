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
public class DputDoubleVector implements DputVector {

    private Double[] val= {};

    /**
     * @return the val
     */
    @Override
    public Double[] getValues() {
        return val;
    }

    public DputDoubleVector(ArrayList<Double> res) {
        val= res.toArray(val);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return  "Doubles: "+Arrays.toString(val) ;
    }

}

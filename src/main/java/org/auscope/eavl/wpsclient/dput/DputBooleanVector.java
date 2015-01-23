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
public class DputBooleanVector implements DputVector {

    private Boolean[] val= {};

    /**
     * @return the val
     */
    @Override
    public Boolean[] getValues() {
        return val;
    }

    public DputBooleanVector(ArrayList<Boolean> res) {
        val= res.toArray(val);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return  Arrays.toString(val) ;
    }

}

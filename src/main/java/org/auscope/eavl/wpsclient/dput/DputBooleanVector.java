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
public class DputBooleanVector implements Dput {

    private boolean[] val;

    /**
     * @return the val
     */
    public boolean[] getVal() {
        return val;
    }

    public DputBooleanVector(ArrayList<Boolean> res) {
        val = new boolean[res.size()];
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

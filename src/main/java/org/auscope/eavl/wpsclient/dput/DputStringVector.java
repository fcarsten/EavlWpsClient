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
public class DputStringVector implements DputVector {

    private String[] value= {};

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Strings: "+ Arrays.toString(value);
    }

    /**
     * @return the value
     */
    @Override
    public String[] getValues() {
        return value;
    }

    public DputStringVector(ArrayList<String> res) {
        this.value= res.toArray(new String[0]);
    }

}

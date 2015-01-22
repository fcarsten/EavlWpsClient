/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.util.List;

/**
 * @author fri096
 *
 */
public class DputList implements Dput {

    private List<Dput> value;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return  value.toString()+"\n";
    }

    /**
     * @return the value
     */
    public List<Dput> getValue() {
        return value;
    }

    public DputList(List<Dput> res) {
        this.value=res;
    }

}

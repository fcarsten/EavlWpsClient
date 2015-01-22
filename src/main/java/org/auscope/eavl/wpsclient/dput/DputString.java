/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputString implements Dput {

    private String value;

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    public DputString(String text) {
        this.value=text;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return value;
    }

}

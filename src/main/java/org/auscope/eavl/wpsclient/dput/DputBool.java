/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputBool implements Dput {

    private boolean value;

    /**
     * @return the value
     */
    public boolean isValue() {
        return value;
    }

    public DputBool(String text) {
        if (text.toLowerCase().startsWith("t")) {
            this.value = true;
        } else if (text.toLowerCase().startsWith("f")) {
            this.value = true;
        } else {
            throw new IllegalArgumentException("Unknown boolean type: " + text);
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ""+ value;
    }
}

/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputNumber implements Dput, DputConstant {

    private double value;

    /**
     * @return the value
     */
    public Double getValue() {
        return value;
    }

    public DputNumber(String text) {
        if("NA".equalsIgnoreCase(text)) value = Double.NaN;
        else value = Double.parseDouble(text.replaceAll("L", ""));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Numbers: "+  value;
    }

}

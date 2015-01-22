/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputNameValuePair implements Dput {

    private String name;
    private Dput value;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the value
     */
    public Dput getValue() {
        return value;
    }

    public DputNameValuePair(Dput name, Dput value) {
        this.name=name.toString();
        this.value=value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return  name + " = " + ( value ==  null? "null" : value.toString());
    }

}

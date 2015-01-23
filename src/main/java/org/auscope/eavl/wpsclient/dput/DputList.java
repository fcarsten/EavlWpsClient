/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author fri096
 *
 */
public class DputList implements Dput {

    private ArrayList<Dput> values  =new ArrayList<>( );
    private HashMap<String, Dput> attributes = new HashMap<>();

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return  "List[ "+values.toString()+"\n" + "      " + attributes.toString() + "]";
    }

    public HashMap<String, Dput> getAttributes() {
        return attributes;
    }

    public Dput getAttribute(String key) {
        return attributes.get(key);
    }

    /**
     * @return the value
     */
    public ArrayList<Dput> getValues() {
        return values;
    }

    public void add(Dput v) {
        if(v instanceof DputNameValuePair) {
            DputNameValuePair nvp = (DputNameValuePair)v;
            attributes.put(nvp.getName(), nvp.getValue());
        } else {
            values.add(v);
        }

    }

}

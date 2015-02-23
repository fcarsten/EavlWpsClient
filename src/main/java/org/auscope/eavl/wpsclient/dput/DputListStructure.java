/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author fri096
 *
 */
public class DputListStructure implements Dput {

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ListStructure<" + className + "> [\n"
                + "              metaData=" + metaData + "\n"
                + "              keys    =" + Arrays.toString(keys) + "\n"
                + "              list=" + list + "\n"
                + "]\n";
    }

    private DputList list;

    /**
     * @return
     * @see org.auscope.eavl.wpsclient.dput.DputList#getAttributes()
     */
    public HashMap<String, Dput> getAttributes() {
        return list.getAttributes();
    }

    /**
     * @param key
     * @return
     * @see org.auscope.eavl.wpsclient.dput.DputList#getAttribute(java.lang.String)
     */
    public Dput getAttribute(String key) {
        return list.getAttribute(key);
    }

    /**
     * @return
     * @see org.auscope.eavl.wpsclient.dput.DputList#getValues()
     */
    public List<Dput> getValues() {
        return list.getValues();
    }

    private HashMap<String, Dput> metaData = new HashMap<>();
    private String className;
    private String[] keys;

    /**
     * @return the metaData
     */
    public HashMap<String, Dput> getMetaData() {
        return metaData;
    }

    /**
     * @return the collection
     */
    public DputList getCollection() {
        return list;
    }

    public void add(Dput v) {
        if (v instanceof DputList) {
            this.list = (DputList) v;
        } else if (v instanceof DputNameValuePair) {
            DputNameValuePair nvp = (DputNameValuePair) v;
            if (nvp.getName().equalsIgnoreCase("class")) {
                this.className = ((DputString) nvp.getValue()).getValue();
            } else if (nvp.getName().equalsIgnoreCase(".Names")) {
                this.keys = ((DputStringVector) nvp.getValue()).getValues();
            } else {
                metaData.put(nvp.getName(), nvp.getValue());
            }
        } else {
            throw new IllegalArgumentException("Unexpected elemente: " + v);
        }

    }

}

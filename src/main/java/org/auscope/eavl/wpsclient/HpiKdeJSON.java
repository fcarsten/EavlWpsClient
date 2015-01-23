/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.Serializable;

/**
 * @author fri096
 *
 */
public class HpiKdeJSON implements Serializable{

    private String json;
    private int numHigh;
    private int numAll;

    /**
     * @return the json
     */
    public String getJson() {
        return json;
    }

    /**
     * @return the numHigh
     */
    public int getNumHigh() {
        return numHigh;
    }

    /**
     * @return the numAll
     */
    public int getNumAll() {
        return numAll;
    }

    public HpiKdeJSON(String str, int size, int length) {
        this.json=str;
        this.numHigh = size;
        this.numAll= length;

    }

}

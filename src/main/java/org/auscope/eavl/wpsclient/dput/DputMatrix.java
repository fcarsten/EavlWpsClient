/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author fri096
 *
 *         I think this is always a matrix
 */
public abstract class DputMatrix<T> implements Dput {

    private String[] header = {};
    private T[][] values;
    private HashMap<String, Dput> metaData = new HashMap<>();
    private String[] rowNames;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String res = "DputMatrix ["
                + (metaData != null && (!metaData.isEmpty())? "\n          metaData=" + metaData + ", "
                        : "")
                + (rowNames != null ? "\n          rowNames="
                        + Arrays.toString(rowNames) : "")
                + (header != null ? "header=" + Arrays.toString(header) + ", "
                        : "");
        res += "\n";
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                int l= Math.min(20, values[i].length);
                for (int j = 0; j < l; j++) {
                    res += values[i][j].toString();
                    if (j < l - 1)
                        res += ", ";
                }
                res += "\n";
            }
        }
        return res + "]\n";
    }

    /**
     * @return the header
     */
    public String[] getHeader() {
        return header;
    }

    /**
     * @return the values
     */
    public T[][] getValues() {
        return values;
    }

    /**
     * @return the metaData
     */
    public HashMap<String, Dput> getMetaData() {
        return metaData;
    }

    /**
     * @return the rowNames
     */
    public String[] getRowNames() {
        return rowNames;
    }

    public void add(Dput v) {
        if (v instanceof DputVector) {
            values = createMatrix(1,0);
            values[0]= (T[]) ((DputVector) v).getValues();
        } else if (v instanceof DputNameValuePair) {
            DputNameValuePair nvp = (DputNameValuePair) v;
            if (nvp.getName().equals(".Dim")) {
                DputVector dims = (DputVector) nvp.getValue();
                int dimX = (int) (double) dims.getValues()[0];
                int dimY = (int) (double) dims.getValues()[1];
                T[][] oldVals = values;
                values = createMatrix(dimX, dimY);
                for (int i = 0; i < dimX; i++) {
                    for (int k = 0; k < dimY; k++) {
                        values[i][k] = oldVals[0][i * dimY + k];
                    }
                }
            } else if (nvp.getName().equals(".Dimnames")) {
                ArrayList<Dput> hl = ((DputList) nvp.getValue()).getValues();
                DputStringVector ns = (DputStringVector) hl.get(0);
                header = ns.getValues();
            } else if (nvp.getName().equals(".Names")) {
                rowNames = ((DputStringVector) nvp.getValue()).getValues();
            } else {
                metaData.put(nvp.getName(), nvp.getValue());
            }
        } else {
            throw new IllegalArgumentException("Unexpected elemente: " + v);
        }

    }

    abstract protected T[][] createMatrix(int i, int j);

}

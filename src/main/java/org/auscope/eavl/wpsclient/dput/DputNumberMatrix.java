/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputNumberMatrix extends DputMatrix<Double> {

    /* (non-Javadoc)
     * @see org.auscope.eavl.wpsclient.dput.DputMatrix#createMatrix(int, int)
     */
    @Override
    protected Double[][] createMatrix(int i, int j) {
        return new Double[i][j];
    }
}

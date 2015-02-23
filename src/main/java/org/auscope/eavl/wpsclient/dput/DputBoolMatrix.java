/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputBoolMatrix extends DputMatrix<Boolean> {

    /* (non-Javadoc)
     * @see org.auscope.eavl.wpsclient.dput.DputMatrix#createMatrix(int, int)
     */
    @Override
    protected Boolean[][] createMatrix(int i, int j) {
        return new Boolean[i][j];
    }

}

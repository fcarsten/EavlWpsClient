/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

/**
 * @author fri096
 *
 */
public class DputStringMatrix extends DputMatrix<String> {

    /* (non-Javadoc)
     * @see org.auscope.eavl.wpsclient.dput.DputMatrix#createMatrix(int, int)
     */
    @Override
    protected String[][] createMatrix(int i, int j) {
        return new String[i][j];
    }

}

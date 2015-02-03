/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.Serializable;

import org.auscope.eavl.wpsclient.dput.DputListStructure;
import org.auscope.eavl.wpsclient.dput.DputNumberMatrix;

/**
 * @author fri096
 *
 */
public class HpiKde implements Serializable {

    private DputListStructure hpiKde;

    public HpiKde(DputListStructure res) {
        this.hpiKde = res;
    }

    public Double[] getEstimate() {
        DputListStructure gkde =  (DputListStructure) hpiKde.getAttribute("gkde");
        DputNumberMatrix estimateDput = (DputNumberMatrix) gkde.getAttribute("estimate");
        Double[][] a = estimateDput.getValues();
        return a[0];
    }
}

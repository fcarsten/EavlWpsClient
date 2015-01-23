/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.auscope.eavl.wpsclient.dput.DputFactory;
import org.auscope.eavl.wpsclient.dput.DputListStructure;
import org.auscope.eavl.wpsclient.dput.DputNumberMatrix;

/**
 * @author fri096
 *
 */
public class DputParserTest {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        DputFactory f = new DputFactory();
        DputListStructure res = (DputListStructure) f
                .parse(new FileInputStream("output.dput"));
        DputListStructure gkde = (DputListStructure) res.getAttribute("gkde");
        DputNumberMatrix estimateDput = (DputNumberMatrix) gkde
                .getAttribute("estimate");
        Double[][] a = estimateDput.getValues();
        System.out.println("" + Arrays.toString(a[0]));
    }

}

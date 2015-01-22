/**
 *
 */
package org.auscope.eavl.wpsclient;

import java.io.FileInputStream;
import java.io.IOException;

import org.auscope.eavl.wpsclient.dput.Dput;
import org.auscope.eavl.wpsclient.dput.DputFactory;

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
        Dput res = f.parse(new FileInputStream("kde.dput"));
        System.out.println(""+res);
    }

}

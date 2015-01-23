/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.auscope.eavl.wpsclient.dput.DputParser.StructureContext;

/**
 * @author fri096
 *
 */
public class DputFactory  {

    public Dput parse(InputStream is) throws IOException {

        ANTLRInputStream stream = new ANTLRInputStream(is);
        DputLexer l = new DputLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(l);
        DputParser parser = new DputParser(tokens);

        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        try {
            StructureContext res = parser.structure();  // STAGE 1
            Dput ret = new DputParserVisitor().visit(res);
            return ret;
       }
        catch (Exception ex) {
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                        Object offendingSymbol, int line, int charPositionInLine,
                        String msg, RecognitionException e) {
                    throw new IllegalStateException("failed to parse at line "
                            + line + " due to " + msg, e);
                }
            });
            tokens.reset(); // rewind input stream
            parser.reset();
            parser.getInterpreter().setPredictionMode(PredictionMode.LL);
            StructureContext res = parser.structure();  // STAGE 1
            Dput ret = new DputParserVisitor().visit(res);
            return ret;
            // if we parse ok, it's LL not SLL
        }
    }

}

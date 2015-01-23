/**
 *
 */
package org.auscope.eavl.wpsclient.dput;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTree;
import org.auscope.eavl.wpsclient.dput.DputParser.BoolContext;
import org.auscope.eavl.wpsclient.dput.DputParser.BoolVectorContext;
import org.auscope.eavl.wpsclient.dput.DputParser.ListContext;
import org.auscope.eavl.wpsclient.dput.DputParser.ListStructureContext;
import org.auscope.eavl.wpsclient.dput.DputParser.NameValuePairContext;
import org.auscope.eavl.wpsclient.dput.DputParser.NumberContext;
import org.auscope.eavl.wpsclient.dput.DputParser.NumberVectorContext;
import org.auscope.eavl.wpsclient.dput.DputParser.StrContext;
import org.auscope.eavl.wpsclient.dput.DputParser.StrVectorContext;
import org.auscope.eavl.wpsclient.dput.DputParser.VariableNameContext;
import org.auscope.eavl.wpsclient.dput.DputParser.VectorStructureContext;

/**
 * @author fri096
 *
 */
public class DputParserVisitor extends DputBaseVisitor<Dput> {

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitListStructure(org
     * .auscope.eavl.wpsclient.dput.DputParser.ListStructureContext)
     */
    @Override
    public Dput visitListStructure(ListStructureContext ctx) {
        DputListStructure res = new DputListStructure();

        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree c = ctx.getChild(i);
            Dput childResult = c.accept(this);
            if (childResult != null)
                res.add(childResult);
        }
        return res;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitVectorStructure(
     * org.auscope.eavl.wpsclient.dput.DputParser.VectorStructureContext)
     */
    @Override
    public Dput visitVectorStructure(VectorStructureContext ctx) {
        DputVectorStructure res = new DputVectorStructure();

        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree c = ctx.getChild(i);
            Dput childResult = c.accept(this);
            if (childResult != null)
                res.add(childResult);
        }

        return res;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitNumberVector(org
     * .auscope.eavl.wpsclient.dput.DputParser.NumberVectorContext)
     */
    @Override
    public Dput visitNumberVector(NumberVectorContext ctx) {

        ArrayList<Double> res = new ArrayList<>();

        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree c = ctx.getChild(i);
            DputNumber childResult = (DputNumber) c.accept(this);
            if (childResult != null)
                res.add(childResult.getValue());
        }

        return new DputDoubleVector(res);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitBoolVector(org.auscope
     * .eavl.wpsclient.dput.DputParser.BoolVectorContext)
     */
    @Override
    public Dput visitBoolVector(BoolVectorContext ctx) {

        ArrayList<Boolean> res = new ArrayList<>();

        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree c = ctx.getChild(i);
            DputBool childResult = (DputBool) c.accept(this);
            if (childResult != null)
                res.add(childResult.getValue());
        }

        return new DputBooleanVector(res);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitStrVector(org.auscope
     * .eavl.wpsclient.dput.DputParser.StrVectorContext)
     */
    @Override
    public Dput visitStrVector(StrVectorContext ctx) {

        ArrayList<String> res = new ArrayList<>();

        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree c = ctx.getChild(i);
            DputString childResult = (DputString) c.accept(this);
            if (childResult != null)
                res.add(childResult.getValue());
        }

        return new DputStringVector(res);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitBool(org.auscope
     * .eavl.wpsclient.dput.DputParser.BoolContext)
     */
    @Override
    public Dput visitBool(BoolContext ctx) {
        return new DputBool(ctx.getText());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.auscope.eavl.wpsclient.dput.DputBaseVisitor#visitStr(org.auscope.
     * eavl.wpsclient.dput.DputParser.StrContext)
     */
    @Override
    public Dput visitStr(StrContext ctx) {
        return new DputString(ctx.getText());
    }

    @Override
    public Dput visitNumber(NumberContext ctx) {
        return new DputNumber(ctx.getText());
    }

    @Override
    public Dput visitNameValuePair(NameValuePairContext ctx) {
        if (ctx.name == null)
            return null;

        return new DputNameValuePair(this.visit(ctx.name), this.visit(ctx
                .getChild(2)));
    }

    @Override
    public Dput visitVariableName(VariableNameContext ctx) {
        return new DputString(ctx.getText());
    }

    @Override
    public Dput visitList(ListContext ctx) {
        DputList res = new DputList();

        int n = ctx.getChildCount();
        for (int i = 0; i < n; i++) {
            ParseTree c = ctx.getChild(i);
            Dput childResult = c.accept(this);
            if (childResult != null)
                res.add(childResult);
        }

        return res;
    }

}

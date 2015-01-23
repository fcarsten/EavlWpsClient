// Generated from Dput.g4 by ANTLR 4.3

package org.auscope.eavl.wpsclient.dput;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DputParser}.
 */
public interface DputListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DputParser#nameValuePair}.
	 * @param ctx the parse tree
	 */
	void enterNameValuePair(@NotNull DputParser.NameValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#nameValuePair}.
	 * @param ctx the parse tree
	 */
	void exitNameValuePair(@NotNull DputParser.NameValuePairContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#numberVector}.
	 * @param ctx the parse tree
	 */
	void enterNumberVector(@NotNull DputParser.NumberVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#numberVector}.
	 * @param ctx the parse tree
	 */
	void exitNumberVector(@NotNull DputParser.NumberVectorContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#listStructure}.
	 * @param ctx the parse tree
	 */
	void enterListStructure(@NotNull DputParser.ListStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#listStructure}.
	 * @param ctx the parse tree
	 */
	void exitListStructure(@NotNull DputParser.ListStructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull DputParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull DputParser.ExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(@NotNull DputParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(@NotNull DputParser.VariableNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull DputParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull DputParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(@NotNull DputParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(@NotNull DputParser.Unary_operatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(@NotNull DputParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(@NotNull DputParser.BoolContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#boolVector}.
	 * @param ctx the parse tree
	 */
	void enterBoolVector(@NotNull DputParser.BoolVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#boolVector}.
	 * @param ctx the parse tree
	 */
	void exitBoolVector(@NotNull DputParser.BoolVectorContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#vectorStructure}.
	 * @param ctx the parse tree
	 */
	void enterVectorStructure(@NotNull DputParser.VectorStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#vectorStructure}.
	 * @param ctx the parse tree
	 */
	void exitVectorStructure(@NotNull DputParser.VectorStructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull DputParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull DputParser.ListContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#structure}.
	 * @param ctx the parse tree
	 */
	void enterStructure(@NotNull DputParser.StructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#structure}.
	 * @param ctx the parse tree
	 */
	void exitStructure(@NotNull DputParser.StructureContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#explicit_int}.
	 * @param ctx the parse tree
	 */
	void enterExplicit_int(@NotNull DputParser.Explicit_intContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#explicit_int}.
	 * @param ctx the parse tree
	 */
	void exitExplicit_int(@NotNull DputParser.Explicit_intContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#unsigned_number}.
	 * @param ctx the parse tree
	 */
	void enterUnsigned_number(@NotNull DputParser.Unsigned_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#unsigned_number}.
	 * @param ctx the parse tree
	 */
	void exitUnsigned_number(@NotNull DputParser.Unsigned_numberContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull DputParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull DputParser.StrContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull DputParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull DputParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(@NotNull DputParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(@NotNull DputParser.VectorContext ctx);

	/**
	 * Enter a parse tree produced by {@link DputParser#strVector}.
	 * @param ctx the parse tree
	 */
	void enterStrVector(@NotNull DputParser.StrVectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DputParser#strVector}.
	 * @param ctx the parse tree
	 */
	void exitStrVector(@NotNull DputParser.StrVectorContext ctx);
}
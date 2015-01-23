// Generated from Dput.g4 by ANTLR 4.3

package org.auscope.eavl.wpsclient.dput;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DputParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DputVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DputParser#nameValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameValuePair(@NotNull DputParser.NameValuePairContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#numberVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberVector(@NotNull DputParser.NumberVectorContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#listStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListStructure(@NotNull DputParser.ListStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull DputParser.ExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(@NotNull DputParser.VariableNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(@NotNull DputParser.ConstantContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(@NotNull DputParser.Unary_operatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull DputParser.BoolContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#boolVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVector(@NotNull DputParser.BoolVectorContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#vectorStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorStructure(@NotNull DputParser.VectorStructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull DputParser.ListContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructure(@NotNull DputParser.StructureContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#explicit_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicit_int(@NotNull DputParser.Explicit_intContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#unsigned_number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsigned_number(@NotNull DputParser.Unsigned_numberContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#str}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(@NotNull DputParser.StrContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull DputParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(@NotNull DputParser.VectorContext ctx);

	/**
	 * Visit a parse tree produced by {@link DputParser#strVector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrVector(@NotNull DputParser.StrVectorContext ctx);
}
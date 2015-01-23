grammar Dput;

@header {
package org.auscope.eavl.wpsclient.dput;
}

structure:
	vectorStructure
	| listStructure
	;

vectorStructure:
	'structure' '(' vector (',' nameValuePair)* ')'
	;

listStructure:
	'structure' '(' list (',' nameValuePair)* ')'
	;

list:
	'list' '(' expression (',' expression)* ')'
	;

nameValuePair:
	WS* name=variableName WS* '=' WS* (expression | constant)
	| 'NULL'
	;

expression:
	nameValuePair
	| structure
	| list
	| vector
	;

variableName:
	VariableLetter+
	| QUOTED_VARIABLE_NAME
	;

vector:
	boolVector
	| strVector
	| numberVector
	;

boolVector :
	VECTOR_START bool (',' bool)* ')';

strVector :
	VECTOR_START str (',' str)* ')';

numberVector:
	VECTOR_START number (',' number)* ')';

constant:
	number
	| bool
	| str
	;

bool: ('T' | 'F' | 'TRUE' | 'FALSE');

str : QUOTED_STRING;

number
 :    unary_operator? unsigned_number
 | 'NA'
 ;

explicit_int:
	'L'
	;

unary_operator
 :    '+'
 |    '-'
 ;

unsigned_number
 :  UNSIGNED_INT
 |  UNSIGNED_FLOAT
 ;

VECTOR_START : 'c' WS* '(';

fragment ESCAPED_QUOTE : '\\"';
QUOTED_STRING :   '"' ( ESCAPED_QUOTE | ~('\n'|'\r') )*? '"';


fragment ESCAPED_VAR_QUOTE : '\\`';
QUOTED_VARIABLE_NAME :   '`' ( ESCAPED_VAR_QUOTE | ~('\n'|'\r') )*? '`';

UNSIGNED_INT : DIGIT+ Explicit_int? ;

DIGIT : [0-9];

UNSIGNED_FLOAT
 :   ('0'..'9')+ '.' ('0'..'9')* Exponent?
 |   '.' ('0'..'9')+ Exponent?
 |   ('0'..'9')+ Exponent
 ;

WS: [ \n\t\r]+ -> skip;

fragment Explicit_int : 'L';

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

VariableLetter: [a-zA-Z0-9_.];


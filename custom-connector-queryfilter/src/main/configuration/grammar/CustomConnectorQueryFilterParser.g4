parser grammar CustomConnectorQueryFilterParser;

@parser::header{
package com.amazonaws.appflow.custom.connector.queryfilter.antlr;
}

options  { tokenVocab=CustomConnectorQueryFilterLexer; }

// 'queryfilter' is the root node for the filter expression
queryfilter
: expression EOF
| limitexpression EOF
;

limitexpression
: op=limit right=count                              #limitExpression
| left=expression op=limit right=count              #limitExpression  // SQL 'LIMIT xyz' operator
;

expression
: LPAREN expression RPAREN                       #parenExpression  // supports parenthesis expressions
// logical operators support
| NOT expression                                 #notExpression
| left=expression op=andBinary right=expression     #aNDBinaryExpression
| left=expression op=orBinary right=expression     #oRBinaryExpression
| left=identifier op=gtComparator right=value #greaterThanComparatorExpression
| left=identifier op=geComparator right=value #greaterThanEqualToComparatorExpression
| left=identifier op=ltComparator right=value #lesserThanComparatorExpression
| left=identifier op=leComparator right=value #lesserThanEqualToComparatorExpression
| left=identifier op=eqComparator right=value #equalToComparatorExpression
| left=identifier op=eqComparator right=bool #boolEqualToComparatorExpression
| left=identifier op=neComparator right=value #notEqualToComparatorExpression
| left=identifier op=neComparator right=bool #boolNotEqualToComparatorExpression
| left=identifier op=likeComparator right=value #likeComparatorExpression
| (left=identifier op=betweenComparator (l1=value op1=andBinary right=value)) #betweenExpression
| identifier #identifierExpression
// Following is a leaf node in the parse tree
// This allows validation and transformations of values.
| value #valueExpression
| identifier op=in LPAREN value (COMMA value)* RPAREN  # inExpression  // Supports SQL like 'IN' operator
;

gtComparator
: GT ;

geComparator
: GE ;

ltComparator
: LT ;

leComparator
: LE ;

eqComparator
: EQ ;

neComparator
: NE ;

likeComparator
: LIKE ;

betweenComparator
: BETWEEN ;

andBinary
: AND ;

orBinary
: OR
;

bool
 : TRUE | FALSE
 ;

identifier
:IDENTIFIER ;

in
:IN ;

limit
:LIMIT ;

// Following is to support different String formats in the value expression
string
 : SINGLE_STRING
 | DOUBLE_STRING
 | EMPTY_DOUBLE_STRING
 | EMPTY_SINGLE_STRING
 | NULL
 ;

value
: string #stringValueExpression
| POS_INTEGER #decimalValueExpression
| DECIMAL #decimalValueExpression
| DATE #isoDate
| DATETIME #isoDateTime
;

count
: POS_INTEGER #countValueExpression
;

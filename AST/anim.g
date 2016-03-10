grammar anim;

// BASED ON SIMPLE1MULTI AND MIDTERM?
// { $ast = new AssignStmt($VAR.text,$exp.ast); }
// { VarExpr forVarHolderTwo = new VarExpr($i2.text); }
// { $ast.addAST(forVarHolderTwo); }



prog	returns [AST ast]
	:	{ $ast = new Encoder(); } ( term {$ast.addAST($term.ast);} )* 
			image {$ast.addAST($image.ast);}
	;

term	returns [AST ast]
	:	'type' '=' m1=whatanim '\r'? '\n'?
							{$ast = new TypeInstr($m1.ast);}


	//ALTER TO MAKE NUM OPTIONAL.

	|	'method' '=' m2=whatmeth {$ast = new MethodInstr($m2.ast);}
			( n1=NUM {NumExpr holder = new NumExpr($n1.text); $ast.addAST(holder); } )?
			'\r'? '\n'?	
							
								


	//|	'method' '=' m2=whatmeth  n1=NUM '\r'? '\n'?	
	//						{NumExpr holder = new NumExpr($n1.text); }
	//						{$ast = new MethodInstr($m2.ast, holder);}	
	;

whatanim	returns [AST ast]
	:	'downwipe'	{$ast = new StringExpr("downwipe");}
	|	'upwipe'	{$ast = new StringExpr("upwipe");}
	|	'rightwipe'	{$ast = new StringExpr("rightwipe");}
	|	'leftwipe'	{$ast = new StringExpr("leftwipe");}
	|	'downslide'	{$ast = new StringExpr("downslide");}
	|	'upslide'	{$ast = new StringExpr("upslide");}	
	|	'rightslide'	{$ast = new StringExpr("rightslide");}
	|	'leftslide'	{$ast = new StringExpr("leftslide");}
	;

whatmeth	returns [AST ast]
	:	'ping'		{$ast = new StringExpr("ping");}
	|	'funct'		{$ast = new StringExpr("funct");}
	;

image		returns [AST ast]
	:	{ $ast = new ImageExpr(); }
		'startimage' '\r'? '\n'
			(s=STRINGLINE
				{StringExpr StringHolder = new StringExpr($s.text);}
				{$ast.addAST(StringHolder);}
			)+
		'endimage' '\r'? '\n'?
	;

// lexical rules

NUM :	'0'..'9'+ ;

STRINGLINE	:  '"' .* '"' '\r'? '\n'; 

COMMENT		:  '//' ~('\n'|'\r')* '\r'? '\n' { $channel=HIDDEN; };
WS		:  ( ' ' | '\t' | '\r' | '\n') { $channel=HIDDEN; };

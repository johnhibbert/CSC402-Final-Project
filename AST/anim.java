import org.antlr.runtime.*;

public class anim {
    public static void main(String[] args) throws Exception {

        // check if we have an input file, if not print out error and abort
        if (args.length == 0) {
            System.out.println("Usage: java <grammar name> <input file>");
            System.exit(0);
        } else {
            //System.out.println("Processing: " + args[0]);
        }

        // set up and initialize our lexer and parser objects
        // open up the input file
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        // create the lexer with the input stream
        animLexer lexer = new animLexer(input);
        // create a token stream for the parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser object with the token stream
        animParser parser = new animParser(tokens);

        // call the toplevel recursive descent parsing function -- start symbol
        //parser.prog();
	AST ast = parser.prog();

	CompileVisitor compileVisitor = new CompileVisitor();
	compileVisitor.dispatch(ast);

	//compileVisitor.buildQueue();
	System.out.println(compileVisitor.getCode());
    }
}
	

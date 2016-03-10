// implementation of num expression

public class StringExpr extends AST {
   
    //NOT YET CHANGED

    private String text;

    public StringExpr(String v) {
	text = v;
    }

    public String getString() {
	return text;
    }   

}

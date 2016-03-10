// implementation of num expression

public class NumExpr extends AST {
   
    private String value;

    public NumExpr(String v) {
	value = v;
    }

    public String getValue() {
	return value;
    }   

}

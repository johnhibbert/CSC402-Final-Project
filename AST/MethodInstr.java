public class MethodInstr extends AST {


	public MethodInstr(AST a) {
	this.addAST(a);
	}


	public MethodInstr(AST a, AST b) {
	this.addAST(a);
	this.addAST(b);
	}
}

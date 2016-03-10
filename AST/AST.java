// abstract base class for AST
// Version 2.0
// now includes a simple tree dump facility

import java.util.*;

public abstract class AST {
    private ArrayList<AST> children = new ArrayList<AST>();

    public final void addAST(AST child) {
	children.add(child);
    }

    public final void putAST(int ix, AST child) {
	children.set(ix,child);
    }

    public final AST getAST(int ix) {
	return children.get(ix);
    }

    public final AST removeAST(int ix) {
	return children.remove(ix);
    }

    public int size() {
	return children.size();
    }

    // ***** tree dump facility
    // this is the public entry point.
    // dump toplevel node and then dump children
    // with appropriate indentation
    public void dumpAST() {
	System.out.print("("+this.getClass());

	for (int i = 0; i < this.size(); i++) {
	    AST child = this.getAST(i);
	    child.dumpInternAST(1);
	}
	System.out.println(")");
    }

    // dump internal tree nodes.
    private void dumpInternAST(int ix) {
	System.out.println();
	printIndent(ix);
	System.out.print("("+this.getClass());

	for (int i = 0; i < this.size(); i++) {
	    AST child = this.getAST(i);
	    child.dumpInternAST(ix+1);
	}

	System.out.print(")");
    }

    // print indentation
    private void printIndent(int r) {
	for (int i = 0; i < r; i++)
            System.out.print("     ");
    }
}

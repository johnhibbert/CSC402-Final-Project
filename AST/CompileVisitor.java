import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.Pattern;

public class CompileVisitor {

private String type = "";
private String method = "";
private String[] imageMaster;
private LinkedList<String[]> stepQueue;
private int speed = 500;
private Boolean tooLong = false;
private Boolean tooWide = false;

//*******************************************************************//
//                             DISPATCH()                            //
//*******************************************************************//

public String dispatch(AST ast) {
	
	if (ast.getClass() == Encoder.class){
		return interp((Encoder)ast);
	}

	else if (ast.getClass() == TypeInstr.class){
		type = interp((TypeInstr)ast);
		return null;
	}
	
	else if (ast.getClass() == MethodInstr.class) {

	//If we got here we know we have at least 1.
	
		method = dispatch(ast.getAST(0));

	//But the user may not have offered a speed.

		if (ast.size() == 2){
			speed = Integer.parseInt(dispatch(ast.getAST(1)));
		}
		return null;
	}

	else if (ast.getClass() == NumExpr.class) {
		return interp((NumExpr)ast);
	}

	else if (ast.getClass() == ImageExpr.class) {
		return interp((ImageExpr)ast);
	}

	else if (ast.getClass() == StringExpr.class) {
		return interp((StringExpr)ast);
	}

	else {
	    System.out.println("COMPILEVISITOR: unknown class type");
	    System.out.println("CLASS GIVEN ="+ast.getClass());
	    System.exit(1);
	    return null;
	}

	
    }

//*******************************************************************//
//                         INTERP  (ENCODER)                         //
//*******************************************************************//

private String interp(Encoder ast) {

	/*
	  Encoder is the main AST class which has the other parts as 
	  its children.
	*/

	for (int i = 0; i < ast.size(); i++) {
	    this.dispatch(ast.getAST(i));
	}

	stepQueue = queueBuilder(imageMaster);

	// It's a statement, so return null.
	return null;

} // end interp(Encoder)


//*******************************************************************//
//                       INTERP   (TYPEINSTR)                        //
//*******************************************************************//

private String interp(TypeInstr ast) {

	/*
	  We dispatch the TypeInstr, which has only one
	  child, which is the string we want.
	*/

	return this.dispatch(ast.getAST(0));

} // end interp(TypeInstr)


//*******************************************************************//
//                       INTERP (METHODINSTR)                        //
//*******************************************************************//


private String interp(MethodInstr ast) {

	/*
	  We dispatch the MethodInstr, which has only one
	  child, which is the string we want.
	*/

	return this.dispatch(ast.getAST(0));

}  // end interp(MethodInstr)


//*******************************************************************//
//                        INTERP (STRINGEXPR)                        //
//*******************************************************************//

private String interp(StringExpr ast) {

	/*
	  Once we are here, all we want is the string the
	  StringExpr is holding.
	*/

	return ast.getString();

} // end interp(StringExpr)



//*******************************************************************//
//                         INTERP  (NUMEXPR)                         //
//*******************************************************************//

private String interp(NumExpr ast) {

	/*
	  Once we are here, all we want is the string the
	  NumExpr is holding.
	*/

	return ast.getValue();

} // end interp(StringExpr)

//*******************************************************************//
//                        INTERP  (IMAGEEXPR)                        //
//*******************************************************************//


private String interp(ImageExpr ast) {

	String holder;

	/*
	Arrays can be annoying since their size is immutable, but we
	know what size it has to be because our AST can tell us its
	size, and since an ImageExpr only has StringExpr children that
	compose the image, it is the exact right number.
	*/
	
	String[] imageHolder = new String[ast.size()];

	for (int i = 0; i < ast.size(); i++) {

	/*
	First, grab the string in question, which can be returned to us
	by dispatching it.
	*/

		holder = this.dispatch(ast.getAST(i));

	/*
	  For purposes of pattern matching, the 'STRINGLINE' token contains both
	  opening and closing quotation marks and the new line character.

	  For non-Unix operating systems, as we found out in class, it will also 
	  include a carriage return before the new line character.  So to 'Windows-
	  Proof' this program, we check for that as well.  Oddly enough, I think
	  Windows will accept it without the \r, so we don't have to add them back
	  in later.

	  We know the sequence will always be either:
	  Quote, Carriage Return, New Line
	  Quote, New Line

	  So, we check if the second to last character is the carriage return.  If
	  it is, we remove three characters total.  If it is not, we only remove two.
	*/

		if (holder.substring(holder.length()-2).compareTo("\r") == 0) {
		holder = holder.substring(1,holder.length()-3);
		}
		else {
		holder = holder.substring(1,holder.length()-2);
		}

	/*
	Now, we add that new string to the array in the same place.
	*/

		imageHolder[i] = holder;
	
	} // end for loop

	/*
	  Now we have an array of strings that compose our image.  So we replace
	  the CompileVisitor's imageMaster string array with the
	  new array we have in imageHolder.
	*/

	this.imageMaster = imageHolder;

	return null;

} // end interp(ImageExpr)



//*******************************************************************//
//                         CODE OUTPUT METHODS                       //
//*******************************************************************//

private LinkedList<String[]> escapeInstaller(LinkedList<String[]> original) {

	/*
	  Windows batch files need to have certain characters escaped for them to work
	  in an ECHO (print) command.  So we have to sift through the entire image and
	  replace instances of those characters with versions that have been escaped.
	
	  For ECHO, three characters must be escaped.  The pipe, and the greater and less
	  than characters.  Of course, we don't want to escape anything more than exactly
	  what we have to otherwise we will mess up the image.

	  The pipe character also has to be escaped in the string below.  Within replaceAll()
	  It's treated as a regular expression, and it seems to match to everything, which
	  makes some sense since in logical language, X OR 0 is X.

	  It is possible that other characters must be escaped, but as far as I know, that
	  is all we need for the ECHO command.  If it turned out we are escaping too many
	  or too few, we could extend the grammar to add an choice.

	  In order to make the necessary replacements, we are going to iterate through each
	  element in the array and replace each of the problematic characters with the 
	  corresponding escaped string.  It will cause the output to no longer look like the
	  image, but it will print correctly.
	*/

	String[] DisallowedChar = {"\\|","<",">"};	
	String[] EscapedChar = {"^\\|","^<","^>"};

	LinkedList<String[]> update = new LinkedList<String[]>();

	String[] holder = new String[original.peekFirst()[0].length()];

	while(original.peekFirst() != null) {
	
		holder = original.removeFirst();

		for (int i = 0; i < holder.length; i++) {

			for (int j = 0; j < DisallowedChar.length; j++) {
				if(holder[i] != null) {
					holder[i] = holder[i].replaceAll(DisallowedChar[j],EscapedChar[j]);
				}
			}//end for
		}//end for
		
	update.add(holder);

	}//end while

	return update;

}//end escapeInstaller


//*******************************************************************//
//                         BUILDER   METHODS                         //
//*******************************************************************//

private LinkedList<String[]> queueBuilder(String[] original) {

	/*
	  Queue is an interface, so we can't just make a queue.
	  We don't need a LinkedList<e> for any specific reason, but
	  it was the subclass of queue that I could get to work.	
	*/

	LinkedList<String[]> progress = new LinkedList<String[]>();
	String[] holder = new String[original.length];

	boolean match = false;
	int counter = 1;

	int lastIndex = original.length-1;

	int longestIndex = 0;
	for (int i = 0; i < original.length; i++) {
		if(longestIndex < original[i].length()){
		longestIndex = i;
		}// end if

		if(original[i].length() > 79) {
		this.tooWide = true;
		}

		if(original.length > 25) {
		this.tooLong = true;
		}
	
	

	}//end for

	while (!match) {

	/*
	  Inside each of these switches, we need to do a few things.

	  - Call the appropriate subbuilder method.
	  - Grab a temp version of the most recent addition into holder.
	  - Do some sort of comparison to that recent addition to see
	    if we have reached the end of the animation.

	  I could save a little bit of repetitive code by using two switches,
	  insofar as every option is going to peekLast(), but I think this is
	  way more readable.  Every animation is going to have to check in a
	  different way, but it can't happen before the peek.
	*/
		switch(this.type.toLowerCase()){

		case "downwipe":

			progress.add(DownWipeSubBuilder(original, counter));
			holder = progress.peekLast();
			if (holder[lastIndex+1].compareTo("ECHO " + original[lastIndex+1]) == 0){
				match = true;
			}
			break;
		case "upwipe":
			progress.add(UpWipeSubBuilder(original, counter));
			holder = progress.peekLast();
			if (holder[0].compareTo("ECHO " + original[0]) == 0){
				match = true;
			}
			break;

		case "rightwipe":

			progress.add(RightWipeSubBuilder(original, counter));
			holder = progress.peekLast();

			if (holder[longestIndex].compareTo("ECHO " + original[longestIndex]) == 0){
				match = true;
			}
			break;

		case "leftwipe":

			progress.add(LeftWipeSubBuilder(original, counter, original[longestIndex].length()));
			holder = progress.peekLast();

			if (holder[longestIndex].compareTo("ECHO " + original[longestIndex]) == 0){
				if (counter == original[longestIndex].length()){
					match = true;
				}
			}
			break;

		case "downslide":

			progress.add(DownSlideSubBuilder(original, counter));
			holder = progress.peekLast();

			if (holder[0].compareTo("ECHO " + original[0]) == 0 
				&& holder[lastIndex].compareTo("ECHO " + original[lastIndex]) == 0){
			
			//if (holder.length == original.length) {
			//if (counter == original[longestIndex].length()){
					match = true;
				//}
			}
			break;

		case "upslide":

			progress.add(UpSlideSubBuilder(original, counter));
			holder = progress.peekLast();

			if (holder[0].compareTo("ECHO " + original[0]) == 0 
				&& holder[lastIndex].compareTo("ECHO " + original[lastIndex]) == 0){
				//if (counter == original[longestIndex].length()){
					match = true;
				//}
			}
			break;

		case "rightslide":

			progress.add(RightSlideSubBuilder(original, counter, longestIndex));
			holder = progress.peekLast();

			if (holder[0].compareTo("ECHO " + original[0]) == 0
				&& holder[lastIndex].compareTo("ECHO " + original[lastIndex]) == 0){
				//if (counter == original[longestIndex].length()){
					match = true;
				//}
			}
			break;

		case "leftslide":

			progress.add(LeftSlideSubBuilder(original, counter, longestIndex));
			holder = progress.peekLast();

			//FIX CHECK

			if (holder[0].compareTo("ECHO " + original[0]) == 0
				&& holder[lastIndex].compareTo("ECHO " + original[lastIndex]) == 0){
				//if (counter == original[longestIndex].length()){
					match = true;
				//}
			}
			break;

	/*
	  The grammar does not require an input for the kind of animation.
	  So we default to DOWNWIPE for lack of anything better to do.
	  I think it is unlikely that a user would not specify what they
	  wanted I feel it is preferable that the program does not just fail if
	  they don't.
	*/
		default:
			progress.add(DownWipeSubBuilder(original, counter));
			holder = progress.peekLast();
			//if (holder[lastIndex].compareTo("ECHO " + original[lastIndex]) == 0){
			if(counter == lastIndex){
				match = true;
			}
			break;
			
		};// end switch

		counter++;

	}//end while
	
	//printQueue(progress);

	//if(progress.peekFirst() == null) {
	//	System.out.println("YOU DRAINED PROGRESS YOU IDIOT");
	//}


	// This was originally before the switch above, but as it turns out,
	// we want to treat escaped characters as though they were one character.
	// So I had to move it to the end, and when I changed that, I made it
	// more abstract.

	progress = escapeInstaller(progress);

	return progress;

}//end queueBuilder

	/*
	  I originally made the SubBuilders (which I called translators for some reason) into
	  seperate methods because I was having trouble with temporary holder variables
	  getting reused inside the builder.  By abusing by-value parameter passing, we can 
	  make sure that doesn't happen.  Now, it turns out this is just a better idea overall,
	  so I suppose it was just a happy accident.
	*/

//*******************************************************************//
//                        DOWNWIPESUBBUILDER                         //
//*******************************************************************//

private String[] DownWipeSubBuilder (String[] original, int c) {

	String[] holder = new String[original.length];

	for (int i = 0; i < original.length; i++) {

		if(c>i) {
			holder[i] = "ECHO " + original[i];
		}
		else {
			holder[i] = "ECHO.";
		}
	}

	return holder;

}//end DownWipeSubBuilder

//*******************************************************************//
//                          UPWIPESUBBUILDER                         //
//*******************************************************************//

private String[] UpWipeSubBuilder (String[] original, int c) {

	String[] holder = new String[original.length];

	for (int i = 0; i < original.length; i++) {

		if(original.length-c-1<i) {
			holder[i] = "ECHO " + original[i];
		}
		else {
			holder[i] = "ECHO.";
		}
	}//end for

	return holder;

}//end UpWipeSubBuilder

//*******************************************************************//
//                        RIGHTWIPESUBBUILDER                        //
//*******************************************************************//
private String[] RightWipeSubBuilder (String[] original, int c) {

	String[] holder = new String[original.length];

	for (int i = 0; i < original.length; i++) {
	
		if(original[i].length() <= c) {
		holder[i] = "ECHO " + original[i];
		}
		else {
		holder[i] = "ECHO " + original[i].substring(0,c);
		}

		boolean b = Pattern.matches("ECHO\\s*", holder[i]);

		if(b){
			holder[i] = "ECHO.";
		}

	}//end for loop

	return holder;

}//end RightWipeSubBuilder

//*******************************************************************//
//                         LEFTWIPESUBBUILDER                        //
//*******************************************************************//
private String[] LeftWipeSubBuilder (String[] original, int c, int l) {

//THIS DOESN"T WORK FOR BIG ONES?

	String[] holder = new String[original.length];
	int CurrentLine = l-c;

	for (int i = 0; i < original.length; i++) {
	
		if(CurrentLine < 1) {
		holder[i] = "ECHO " + original[i];
		}
		
		else if(original[i].length() < CurrentLine) {
		holder[i] = "ECHO.";
		}
		
		else if(original[i].length() >= CurrentLine) {
		holder[i] = "ECHO ";
		holder[i] += original[i].substring(0, CurrentLine-1).replaceAll("."," ");
		
			if(original[i].length() > CurrentLine) {
				holder[i] += original[i].substring(CurrentLine,original[i].length());	
			}	
		}

		// There is a slight problem with this implementation.  If you
		// have ECHO and a buncho of spaces, it will not print a blank
		// line, it will just tell you that ECHO is off on that line
		// instead.  So, we use some regular expression magic to find
		// if our new line matches it, and if it does, we replace it.

		// We might be able to do this better, but this is straightforward.

		boolean b = Pattern.matches("ECHO\\s*", holder[i]);

		if(b){
			holder[i] = "ECHO.";
		}

	}//end for

	return holder;

}//end LeftWipeSubBuilder

//*******************************************************************//
//                        DOWNSLIDESUBBUILDER                        //
//*******************************************************************//
private String[] DownSlideSubBuilder (String[] original, int c) {

	String[] holder = new String[original.length];
	int CurrentLine = original.length-c;

	//System.out.println("Inside DownSlideSubBuilder");

	for (int i = 0; i < original.length; i++) {
	
		if(i<c) {
			holder[i] = "ECHO " + original[CurrentLine+i];
		}
		else {
			holder[i] = "ECHO.";
		}

		boolean b = Pattern.matches("ECHO\\s*", holder[i]);

		if(b){
			holder[i] = "ECHO.";
		}

	}//end for

	return holder;

}// end DownSlideSubBuilder

//*******************************************************************//
//                         UPSLIDESUBBUILDER                         //
//*******************************************************************//
private String[] UpSlideSubBuilder (String[] original, int c) {

	String[] holder = new String[original.length];
	int CurrentLine = original.length-c;

	for (int i = 0; i < original.length; i++) {

		if(CurrentLine>i) {
			holder[i] = "ECHO.";
		}
		else {
			holder[i] = "ECHO " + original[i-CurrentLine];
		}
	}// end for

	return holder;

}// end UpSlideSubBuilder

//*******************************************************************//
//                        RIGHTSLIDESUBBUILDER                       //
//*******************************************************************//
private String[] RightSlideSubBuilder (String[] original, int c, int l) {

	String[] holder = new String[original.length];
	int Longest = original[l].length();
	int CurrentLine = Longest-c+1;

	for (int i = 0; i < original.length; i++) {

		//if(original[i].length() <= CurrentLine) {
		if(original[i].length() < CurrentLine) {
		holder[i] = "ECHO.";
		}
		else {
		holder[i] = "ECHO " + original[i].substring(CurrentLine,original[i].length());
		}

		boolean b = Pattern.matches("ECHO\\s*", holder[i]);

		if(b){
			holder[i] = "ECHO.";
		}

	}// end for loop

	return holder;

}// end RightSlideSubBuilder


//*******************************************************************//
//                         LEFTSLIDESUBBUILDER                       //
//*******************************************************************//
private String[] LeftSlideSubBuilder (String[] original, int c, int l) {

	String[] holder = new String[original.length];
	int Longest = original[l].length();
	int CurrentLine = 78-c;
	String spaces = "";

	for (int i = 0; i < CurrentLine; i++) {
		spaces += " ";
	}

	for (int i = 0; i < original.length; i++) {

		if(original[i].length() > c) {
			holder[i] = "ECHO ";
			holder[i] += spaces;
			holder[i] += original[i].substring(0,c);
		}
		else {
			holder[i] = "ECHO " + spaces + original[i];
		}
			

		boolean b = Pattern.matches("ECHO\\s*", holder[i]);

		if(b){
			holder[i] = "ECHO.";
		}

	}// end for loop

	return holder;

}// end LeftSlideSubBuilder



//*******************************************************************//
//                         OUTPUT    METHODS                         //
//*******************************************************************//

public String getCode() {

	String step = "";
	String code = "cls\nECHO OFF\n";
	String[] holder;

	switch(this.method.toLowerCase()){

	case "ping":
		step = "ping 1.1.1.1 -n 1 -w ";
		step += speed;
		step += " >nul\n";
		break;
	case "funct":
		step = "call:waitforawhile\n";
		break;
	default:
	/*
	  The grammar does not require an input for the method of animation.
	  So we default to PING 500 for lack of anything better.
	  I think it is unlikely that a user would not specify their method
	  but I feel it is preferable that the program does not just fail if
	  they do not specify.
	*/
	
		step = "ping 1.1.1.1 -n 1 -w 500 >nul\n";
	
	}//end switch


	if (this.tooLong || this.tooWide) {
		if(this.tooLong && this.tooWide) {
		code += "REM Your image is taller than 25 characters and wider than 79 characters.\n";
		}
		else if(this.tooLong) {
		code += "REM Your image is taller than 25 characters.\n";
		}

		else if(this.tooWide) {
		code += "REM Your image is wider than 79 characters.\n";
		}
		code += "REM It may not display or animate properly.\n";
		code += "REM Consider using images within the dimensions 79x25 to avoid problems.\n";
	}


	while(stepQueue.peekFirst() != null) {
	
		holder = stepQueue.removeFirst();

		for (int i = 0; i < holder.length; i++) {
			code += holder[i];
			code += "\n";
		}
		
		code += step;
		code += "cls \n";

	}//end while


	//We want to trim the last "cls \n" off.
	code = code.substring(0,code.length()-5);

	//And add a pause.
	code += "pause\n";

	if(this.method.toLowerCase() == "funct") {
		//We will only reach this goto:eof when we are done
		//walking through the entire thing.  If we don't do this,
		//we will run through waitforawhile one more time.
		//Which isn't the biggest deal, but might as well do it right.
		code += "goto:eof\n";

		code += ":waitforawhile\n";
		code += "set count="+speed+"\n";
		
		code += ":loop\n";
		code += "set /a count=%count%-1\n";
		code += "if %count% NEQ 0 goto loop\n";
		code += "goto:eof";
	}

	return code;

} // end getCode()


//*******************************************************************//
//                         DEBUGGING METHODS                         //
//*******************************************************************//

	//THESE METHODS WERE JUST TO ALLOW ME TO LOOK INSIDE MY DATA
	//MEMBERS FOR DEBUGGING PURPOSES.


public void printStrings() {

	//This method is just for debugging purposes.
	
	System.out.println("PRINTING STRING OBJECTS IN COMPILEVISITOR:");
	
	System.out.println("TYPE: "+type);
	System.out.println("METHOD: "+method);

	for (String element: imageMaster) {
	System.out.println(element);
	}

} // end printStrings()


public void printQueue(LinkedList<String[]> orig) {

	String[] holder;

		while(orig.peekFirst() != null) {
	
		holder = orig.removeFirst();

		for (int i = 0; i < holder.length; i++) {
		System.out.println(holder[i]);
		}
		
	}//end while


} //end printQueue


} //end CompileVisitor

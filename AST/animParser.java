// $ANTLR 3.5 anim.g 2015-12-12 22:22:52

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class animParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "NUM", "STRINGLINE", 
		"WS", "'='", "'\\n'", "'\\r'", "'downslide'", "'downwipe'", "'endimage'", 
		"'funct'", "'leftslide'", "'leftwipe'", "'method'", "'ping'", "'rightslide'", 
		"'rightwipe'", "'startimage'", "'type'", "'upslide'", "'upwipe'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int COMMENT=4;
	public static final int NUM=5;
	public static final int STRINGLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public animParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public animParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return animParser.tokenNames; }
	@Override public String getGrammarFileName() { return "anim.g"; }



	// $ANTLR start "prog"
	// anim.g:10:1: prog returns [AST ast] : ( term )* image ;
	public final AST prog() throws RecognitionException {
		AST ast = null;


		AST term1 =null;
		AST image2 =null;

		try {
			// anim.g:11:2: ( ( term )* image )
			// anim.g:11:4: ( term )* image
			{
			 ast = new Encoder(); 
			// anim.g:11:30: ( term )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==17||LA1_0==22) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// anim.g:11:32: term
					{
					pushFollow(FOLLOW_term_in_prog26);
					term1=term();
					state._fsp--;

					ast.addAST(term1);
					}
					break;

				default :
					break loop1;
				}
			}

			pushFollow(FOLLOW_image_in_prog37);
			image2=image();
			state._fsp--;

			ast.addAST(image2);
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "prog"



	// $ANTLR start "term"
	// anim.g:15:1: term returns [AST ast] : ( 'type' '=' m1= whatanim ( '\\r' )? ( '\\n' )? | 'method' '=' m2= whatmeth (n1= NUM )? ( '\\r' )? ( '\\n' )? );
	public final AST term() throws RecognitionException {
		AST ast = null;


		Token n1=null;
		AST m1 =null;
		AST m2 =null;

		try {
			// anim.g:16:2: ( 'type' '=' m1= whatanim ( '\\r' )? ( '\\n' )? | 'method' '=' m2= whatmeth (n1= NUM )? ( '\\r' )? ( '\\n' )? )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==22) ) {
				alt7=1;
			}
			else if ( (LA7_0==17) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// anim.g:16:4: 'type' '=' m1= whatanim ( '\\r' )? ( '\\n' )?
					{
					match(input,22,FOLLOW_22_in_term54); 
					match(input,8,FOLLOW_8_in_term56); 
					pushFollow(FOLLOW_whatanim_in_term60);
					m1=whatanim();
					state._fsp--;

					// anim.g:16:27: ( '\\r' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==10) ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// anim.g:16:27: '\\r'
							{
							match(input,10,FOLLOW_10_in_term62); 
							}
							break;

					}

					// anim.g:16:33: ( '\\n' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0==9) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// anim.g:16:33: '\\n'
							{
							match(input,9,FOLLOW_9_in_term65); 
							}
							break;

					}

					ast = new TypeInstr(m1);
					}
					break;
				case 2 :
					// anim.g:22:4: 'method' '=' m2= whatmeth (n1= NUM )? ( '\\r' )? ( '\\n' )?
					{
					match(input,17,FOLLOW_17_in_term85); 
					match(input,8,FOLLOW_8_in_term87); 
					pushFollow(FOLLOW_whatmeth_in_term91);
					m2=whatmeth();
					state._fsp--;

					ast = new MethodInstr(m2);
					// anim.g:23:4: (n1= NUM )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==NUM) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// anim.g:23:6: n1= NUM
							{
							n1=(Token)match(input,NUM,FOLLOW_NUM_in_term102); 
							NumExpr holder = new NumExpr((n1!=null?n1.getText():null)); ast.addAST(holder); 
							}
							break;

					}

					// anim.g:24:4: ( '\\r' )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==10) ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// anim.g:24:4: '\\r'
							{
							match(input,10,FOLLOW_10_in_term112); 
							}
							break;

					}

					// anim.g:24:10: ( '\\n' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==9) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// anim.g:24:10: '\\n'
							{
							match(input,9,FOLLOW_9_in_term115); 
							}
							break;

					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "term"



	// $ANTLR start "whatanim"
	// anim.g:34:1: whatanim returns [AST ast] : ( 'downwipe' | 'upwipe' | 'rightwipe' | 'leftwipe' | 'downslide' | 'upslide' | 'rightslide' | 'leftslide' );
	public final AST whatanim() throws RecognitionException {
		AST ast = null;


		try {
			// anim.g:35:2: ( 'downwipe' | 'upwipe' | 'rightwipe' | 'leftwipe' | 'downslide' | 'upslide' | 'rightslide' | 'leftslide' )
			int alt8=8;
			switch ( input.LA(1) ) {
			case 12:
				{
				alt8=1;
				}
				break;
			case 24:
				{
				alt8=2;
				}
				break;
			case 20:
				{
				alt8=3;
				}
				break;
			case 16:
				{
				alt8=4;
				}
				break;
			case 11:
				{
				alt8=5;
				}
				break;
			case 23:
				{
				alt8=6;
				}
				break;
			case 19:
				{
				alt8=7;
				}
				break;
			case 15:
				{
				alt8=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// anim.g:35:4: 'downwipe'
					{
					match(input,12,FOLLOW_12_in_whatanim157); 
					ast = new StringExpr("downwipe");
					}
					break;
				case 2 :
					// anim.g:36:4: 'upwipe'
					{
					match(input,24,FOLLOW_24_in_whatanim164); 
					ast = new StringExpr("upwipe");
					}
					break;
				case 3 :
					// anim.g:37:4: 'rightwipe'
					{
					match(input,20,FOLLOW_20_in_whatanim171); 
					ast = new StringExpr("rightwipe");
					}
					break;
				case 4 :
					// anim.g:38:4: 'leftwipe'
					{
					match(input,16,FOLLOW_16_in_whatanim178); 
					ast = new StringExpr("leftwipe");
					}
					break;
				case 5 :
					// anim.g:39:4: 'downslide'
					{
					match(input,11,FOLLOW_11_in_whatanim185); 
					ast = new StringExpr("downslide");
					}
					break;
				case 6 :
					// anim.g:40:4: 'upslide'
					{
					match(input,23,FOLLOW_23_in_whatanim192); 
					ast = new StringExpr("upslide");
					}
					break;
				case 7 :
					// anim.g:41:4: 'rightslide'
					{
					match(input,19,FOLLOW_19_in_whatanim200); 
					ast = new StringExpr("rightslide");
					}
					break;
				case 8 :
					// anim.g:42:4: 'leftslide'
					{
					match(input,15,FOLLOW_15_in_whatanim207); 
					ast = new StringExpr("leftslide");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "whatanim"



	// $ANTLR start "whatmeth"
	// anim.g:45:1: whatmeth returns [AST ast] : ( 'ping' | 'funct' );
	public final AST whatmeth() throws RecognitionException {
		AST ast = null;


		try {
			// anim.g:46:2: ( 'ping' | 'funct' )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==18) ) {
				alt9=1;
			}
			else if ( (LA9_0==14) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// anim.g:46:4: 'ping'
					{
					match(input,18,FOLLOW_18_in_whatmeth224); 
					ast = new StringExpr("ping");
					}
					break;
				case 2 :
					// anim.g:47:4: 'funct'
					{
					match(input,14,FOLLOW_14_in_whatmeth232); 
					ast = new StringExpr("funct");
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "whatmeth"



	// $ANTLR start "image"
	// anim.g:50:1: image returns [AST ast] : 'startimage' ( '\\r' )? '\\n' (s= STRINGLINE )+ 'endimage' ( '\\r' )? ( '\\n' )? ;
	public final AST image() throws RecognitionException {
		AST ast = null;


		Token s=null;

		try {
			// anim.g:51:2: ( 'startimage' ( '\\r' )? '\\n' (s= STRINGLINE )+ 'endimage' ( '\\r' )? ( '\\n' )? )
			// anim.g:51:4: 'startimage' ( '\\r' )? '\\n' (s= STRINGLINE )+ 'endimage' ( '\\r' )? ( '\\n' )?
			{
			 ast = new ImageExpr(); 
			match(input,21,FOLLOW_21_in_image255); 
			// anim.g:52:16: ( '\\r' )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==10) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// anim.g:52:16: '\\r'
					{
					match(input,10,FOLLOW_10_in_image257); 
					}
					break;

			}

			match(input,9,FOLLOW_9_in_image260); 
			// anim.g:53:4: (s= STRINGLINE )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==STRINGLINE) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// anim.g:53:5: s= STRINGLINE
					{
					s=(Token)match(input,STRINGLINE,FOLLOW_STRINGLINE_in_image268); 
					StringExpr StringHolder = new StringExpr((s!=null?s.getText():null));
					ast.addAST(StringHolder);
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			match(input,13,FOLLOW_13_in_image290); 
			// anim.g:57:14: ( '\\r' )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==10) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// anim.g:57:14: '\\r'
					{
					match(input,10,FOLLOW_10_in_image292); 
					}
					break;

			}

			// anim.g:57:20: ( '\\n' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==9) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// anim.g:57:20: '\\n'
					{
					match(input,9,FOLLOW_9_in_image295); 
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ast;
	}
	// $ANTLR end "image"

	// Delegated rules



	public static final BitSet FOLLOW_term_in_prog26 = new BitSet(new long[]{0x0000000000620000L});
	public static final BitSet FOLLOW_image_in_prog37 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_term54 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_term56 = new BitSet(new long[]{0x0000000001999800L});
	public static final BitSet FOLLOW_whatanim_in_term60 = new BitSet(new long[]{0x0000000000000602L});
	public static final BitSet FOLLOW_10_in_term62 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_9_in_term65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_term85 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_term87 = new BitSet(new long[]{0x0000000000044000L});
	public static final BitSet FOLLOW_whatmeth_in_term91 = new BitSet(new long[]{0x0000000000000622L});
	public static final BitSet FOLLOW_NUM_in_term102 = new BitSet(new long[]{0x0000000000000602L});
	public static final BitSet FOLLOW_10_in_term112 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_9_in_term115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_whatanim157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_whatanim164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_whatanim171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_whatanim178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_whatanim185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_whatanim192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_whatanim200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_whatanim207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_whatmeth224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_whatmeth232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_image255 = new BitSet(new long[]{0x0000000000000600L});
	public static final BitSet FOLLOW_10_in_image257 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_image260 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_STRINGLINE_in_image268 = new BitSet(new long[]{0x0000000000002040L});
	public static final BitSet FOLLOW_13_in_image290 = new BitSet(new long[]{0x0000000000000602L});
	public static final BitSet FOLLOW_10_in_image292 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_9_in_image295 = new BitSet(new long[]{0x0000000000000002L});
}

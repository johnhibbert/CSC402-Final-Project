// $ANTLR 3.5 anim.g 2015-12-12 22:22:52

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class animLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public animLexer() {} 
	public animLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public animLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "anim.g"; }

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:2:6: ( '=' )
			// anim.g:2:8: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:3:6: ( '\\n' )
			// anim.g:3:8: '\\n'
			{
			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:4:7: ( '\\r' )
			// anim.g:4:9: '\\r'
			{
			match('\r'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:5:7: ( 'downslide' )
			// anim.g:5:9: 'downslide'
			{
			match("downslide"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:6:7: ( 'downwipe' )
			// anim.g:6:9: 'downwipe'
			{
			match("downwipe"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:7:7: ( 'endimage' )
			// anim.g:7:9: 'endimage'
			{
			match("endimage"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:8:7: ( 'funct' )
			// anim.g:8:9: 'funct'
			{
			match("funct"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:9:7: ( 'leftslide' )
			// anim.g:9:9: 'leftslide'
			{
			match("leftslide"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:10:7: ( 'leftwipe' )
			// anim.g:10:9: 'leftwipe'
			{
			match("leftwipe"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:11:7: ( 'method' )
			// anim.g:11:9: 'method'
			{
			match("method"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:12:7: ( 'ping' )
			// anim.g:12:9: 'ping'
			{
			match("ping"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:13:7: ( 'rightslide' )
			// anim.g:13:9: 'rightslide'
			{
			match("rightslide"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:14:7: ( 'rightwipe' )
			// anim.g:14:9: 'rightwipe'
			{
			match("rightwipe"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:15:7: ( 'startimage' )
			// anim.g:15:9: 'startimage'
			{
			match("startimage"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:16:7: ( 'type' )
			// anim.g:16:9: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:17:7: ( 'upslide' )
			// anim.g:17:9: 'upslide'
			{
			match("upslide"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:18:7: ( 'upwipe' )
			// anim.g:18:9: 'upwipe'
			{
			match("upwipe"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:62:5: ( ( '0' .. '9' )+ )
			// anim.g:62:7: ( '0' .. '9' )+
			{
			// anim.g:62:7: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// anim.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "STRINGLINE"
	public final void mSTRINGLINE() throws RecognitionException {
		try {
			int _type = STRINGLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:64:12: ( '\"' ( . )* '\"' ( '\\r' )? '\\n' )
			// anim.g:64:15: '\"' ( . )* '\"' ( '\\r' )? '\\n'
			{
			match('\"'); 
			// anim.g:64:19: ( . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\"') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='\r') ) {
						int LA2_3 = input.LA(3);
						if ( (LA2_3=='\n') ) {
							alt2=2;
						}
						else if ( ((LA2_3 >= '\u0000' && LA2_3 <= '\t')||(LA2_3 >= '\u000B' && LA2_3 <= '\uFFFF')) ) {
							alt2=1;
						}

					}
					else if ( (LA2_1=='\n') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '\t')||(LA2_1 >= '\u000B' && LA2_1 <= '\f')||(LA2_1 >= '\u000E' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// anim.g:64:19: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match('\"'); 
			// anim.g:64:26: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// anim.g:64:26: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRINGLINE"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:66:10: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// anim.g:66:13: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// anim.g:66:18: (~ ( '\\n' | '\\r' ) )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// anim.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop4;
				}
			}

			// anim.g:66:32: ( '\\r' )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\r') ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// anim.g:66:32: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// anim.g:67:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// anim.g:67:8: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// anim.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | NUM | STRINGLINE | COMMENT | WS )
		int alt6=21;
		switch ( input.LA(1) ) {
		case '=':
			{
			alt6=1;
			}
			break;
		case '\n':
			{
			alt6=2;
			}
			break;
		case '\r':
			{
			alt6=3;
			}
			break;
		case 'd':
			{
			int LA6_4 = input.LA(2);
			if ( (LA6_4=='o') ) {
				int LA6_20 = input.LA(3);
				if ( (LA6_20=='w') ) {
					int LA6_24 = input.LA(4);
					if ( (LA6_24=='n') ) {
						int LA6_29 = input.LA(5);
						if ( (LA6_29=='s') ) {
							alt6=4;
						}
						else if ( (LA6_29=='w') ) {
							alt6=5;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 29, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 24, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 6, 20, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 6, 4, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'e':
			{
			alt6=6;
			}
			break;
		case 'f':
			{
			alt6=7;
			}
			break;
		case 'l':
			{
			int LA6_7 = input.LA(2);
			if ( (LA6_7=='e') ) {
				int LA6_21 = input.LA(3);
				if ( (LA6_21=='f') ) {
					int LA6_25 = input.LA(4);
					if ( (LA6_25=='t') ) {
						int LA6_30 = input.LA(5);
						if ( (LA6_30=='s') ) {
							alt6=8;
						}
						else if ( (LA6_30=='w') ) {
							alt6=9;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 30, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 25, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 6, 21, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 6, 7, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'm':
			{
			alt6=10;
			}
			break;
		case 'p':
			{
			alt6=11;
			}
			break;
		case 'r':
			{
			int LA6_10 = input.LA(2);
			if ( (LA6_10=='i') ) {
				int LA6_22 = input.LA(3);
				if ( (LA6_22=='g') ) {
					int LA6_26 = input.LA(4);
					if ( (LA6_26=='h') ) {
						int LA6_31 = input.LA(5);
						if ( (LA6_31=='t') ) {
							int LA6_36 = input.LA(6);
							if ( (LA6_36=='s') ) {
								alt6=12;
							}
							else if ( (LA6_36=='w') ) {
								alt6=13;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 36, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 31, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 6, 26, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 6, 22, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 6, 10, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 's':
			{
			alt6=14;
			}
			break;
		case 't':
			{
			alt6=15;
			}
			break;
		case 'u':
			{
			int LA6_13 = input.LA(2);
			if ( (LA6_13=='p') ) {
				int LA6_23 = input.LA(3);
				if ( (LA6_23=='s') ) {
					alt6=16;
				}
				else if ( (LA6_23=='w') ) {
					alt6=17;
				}

				else {
					int nvaeMark = input.mark();
					try {
						for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
							input.consume();
						}
						NoViableAltException nvae =
							new NoViableAltException("", 6, 23, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 6, 13, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=18;
			}
			break;
		case '\"':
			{
			alt6=19;
			}
			break;
		case '/':
			{
			alt6=20;
			}
			break;
		case '\t':
		case ' ':
			{
			alt6=21;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// anim.g:1:10: T__8
				{
				mT__8(); 

				}
				break;
			case 2 :
				// anim.g:1:15: T__9
				{
				mT__9(); 

				}
				break;
			case 3 :
				// anim.g:1:20: T__10
				{
				mT__10(); 

				}
				break;
			case 4 :
				// anim.g:1:26: T__11
				{
				mT__11(); 

				}
				break;
			case 5 :
				// anim.g:1:32: T__12
				{
				mT__12(); 

				}
				break;
			case 6 :
				// anim.g:1:38: T__13
				{
				mT__13(); 

				}
				break;
			case 7 :
				// anim.g:1:44: T__14
				{
				mT__14(); 

				}
				break;
			case 8 :
				// anim.g:1:50: T__15
				{
				mT__15(); 

				}
				break;
			case 9 :
				// anim.g:1:56: T__16
				{
				mT__16(); 

				}
				break;
			case 10 :
				// anim.g:1:62: T__17
				{
				mT__17(); 

				}
				break;
			case 11 :
				// anim.g:1:68: T__18
				{
				mT__18(); 

				}
				break;
			case 12 :
				// anim.g:1:74: T__19
				{
				mT__19(); 

				}
				break;
			case 13 :
				// anim.g:1:80: T__20
				{
				mT__20(); 

				}
				break;
			case 14 :
				// anim.g:1:86: T__21
				{
				mT__21(); 

				}
				break;
			case 15 :
				// anim.g:1:92: T__22
				{
				mT__22(); 

				}
				break;
			case 16 :
				// anim.g:1:98: T__23
				{
				mT__23(); 

				}
				break;
			case 17 :
				// anim.g:1:104: T__24
				{
				mT__24(); 

				}
				break;
			case 18 :
				// anim.g:1:110: NUM
				{
				mNUM(); 

				}
				break;
			case 19 :
				// anim.g:1:114: STRINGLINE
				{
				mSTRINGLINE(); 

				}
				break;
			case 20 :
				// anim.g:1:125: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 21 :
				// anim.g:1:133: WS
				{
				mWS(); 

				}
				break;

		}
	}



}

//### This file created by BYACC 1.8(/Java extension  1.13)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//###           14 Sep 06  -- Keltin Leung-- ReduceListener support, eliminate underflow report in error recovery
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 11 "Parser.y"
package decaf.frontend;

import decaf.tree.Tree;
import decaf.tree.Tree.*;
import decaf.error.*;
import java.util.*;
//#line 25 "Parser.java"
interface ReduceListener {
  public boolean onReduce(String rule);
}




public class Parser
             extends BaseParser
             implements ReduceListener
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

ReduceListener reduceListener = null;
void yyclearin ()       {yychar = (-1);}
void yyerrok ()         {yyerrflag=0;}
void addReduceListener(ReduceListener l) {
  reduceListener = l;}


//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:SemValue
String   yytext;//user variable to return contextual strings
SemValue yyval; //used to return semantic vals from action routines
SemValue yylval;//the 'lval' (result) I got from yylex()
SemValue valstk[] = new SemValue[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new SemValue();
  yylval=new SemValue();
  valptr=-1;
}
final void val_push(SemValue val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    SemValue[] newstack = new SemValue[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final SemValue val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final SemValue val_peek(int relative)
{
  return valstk[valptr-relative];
}
//#### end semantic value section ####
public final static short VOID=257;
public final static short BOOL=258;
public final static short INT=259;
public final static short STRING=260;
public final static short CLASS=261;
public final static short NULL=262;
public final static short EXTENDS=263;
public final static short THIS=264;
public final static short WHILE=265;
public final static short FOR=266;
public final static short IF=267;
public final static short ELSE=268;
public final static short RETURN=269;
public final static short BREAK=270;
public final static short NEW=271;
public final static short PRINT=272;
public final static short PRINTCOMP=273;
public final static short READ_INTEGER=274;
public final static short READ_LINE=275;
public final static short LITERAL=276;
public final static short IDENTIFIER=277;
public final static short AND=278;
public final static short OR=279;
public final static short STATIC=280;
public final static short INSTANCEOF=281;
public final static short LESS_EQUAL=282;
public final static short GREATER_EQUAL=283;
public final static short EQUAL=284;
public final static short NOT_EQUAL=285;
public final static short COMPLEX=286;
public final static short CASE=287;
public final static short DEFAULT=288;
public final static short SUPER=289;
public final static short DO=290;
public final static short OD=291;
public final static short DO_SEP=292;
public final static short DCOPY=293;
public final static short SCOPY=294;
public final static short UMINUS=295;
public final static short EMPTY=296;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    5,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   14,   14,
   14,   22,   27,   28,   26,   26,   29,   29,   23,   23,
   25,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   31,   31,   30,   30,   34,
   34,   16,   17,   21,   15,   36,   33,   32,   32,   35,
   35,   18,   18,   19,   20,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    1,
    2,    3,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    1,    2,    2,    2,    2,    1,    2,    3,    1,
    0,    4,    3,    2,    2,    0,    2,    0,    2,    4,
    5,    1,    1,    1,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    3,    3,    2,    2,
    2,    2,    2,    3,    3,    1,    1,    4,    5,    6,
    5,    8,    7,    4,    4,    1,    1,    1,    0,    3,
    1,    5,    9,    1,    6,    4,    4,    2,    1,    2,
    0,    2,    1,    4,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    3,    0,    2,    0,    0,   14,   18,
    0,    7,    8,    6,    9,    0,    0,   13,   10,   16,
    0,    0,   17,   11,    0,    4,    0,    0,    0,    0,
   12,    0,   22,    0,    0,    0,    0,    5,    0,    0,
    0,   27,   24,   21,   23,    0,   87,   76,    0,    0,
    0,    0,   94,    0,    0,    0,    0,    0,   86,    0,
    0,    0,    0,   25,    0,    0,    0,    0,   77,   46,
    0,    0,   28,   37,   26,    0,   30,   31,   32,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   54,    0,
    0,    0,   52,    0,   53,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   71,   73,   72,    0,
    0,    0,    0,   29,   33,   34,   35,   36,   38,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   47,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   74,   75,    0,    0,   68,    0,
    0,    0,   45,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   78,    0,    0,  104,  105,    0,
    0,    0,    0,   42,   44,   84,   85,   50,    0,    0,
   92,    0,    0,   79,    0,    0,   81,    0,   43,   51,
    0,    0,   95,   80,    0,    0,    0,    0,   99,    0,
  100,    0,    0,    0,   98,   83,    0,    0,    0,   82,
   93,   97,   96,
};
final static short yydgoto[] = {                          2,
    3,    4,   73,   21,   34,    8,   11,   23,   35,   36,
   74,   46,   75,   76,   77,   78,   79,   80,   81,   82,
   83,   84,   93,   86,   95,  111,  152,  153,   88,  189,
   89,  207,  208,  143,  203,  209,
};
final static short yysindex[] = {                      -240,
 -248,    0, -240,    0, -217,    0, -222,  -60,    0,    0,
  337,    0,    0,    0,    0, -200,  275,    0,    0,    0,
   23,  -82,    0,    0,  -73,    0,   49,   -7,   51,  275,
    0,  275,    0,  -71,   54,   57,   62,    0,  -19,  275,
  -19,    0,    0,    0,    0,    5,    0,    0,   58,   78,
   79,  119,    0,  369,   80,   81,   87,   89,    0,   92,
  119,  119,   77,    0,  119,  119,  119,   95,    0,    0,
   96,   97,    0,    0,    0,   83,    0,    0,    0,   85,
   86,   88,   91,   94,   44,  800,    0, -138,    0,  119,
  119,  119,    0,  800,    0,  100,   55,  119,  119,  107,
  110,  119,  -24,  -24, -121,  132,    0,    0,    0,  119,
  119,  119,  119,    0,    0,    0,    0,    0,    0,  119,
  119,  119,  119,  119,  119,  119,  119,  119,  119,  119,
  119,  119,  119,    0,  119,  117,  484,  102,  510,  122,
   98,  800,    8,   27,    0,    0,  521,  124,    0,  543,
  573, -198,    0,  611,  710,  800,  960,  939,  -10,  -10,
  -32,  -32,   11,   11,  -24,  -24,  -24,  -10,  -10,  770,
  119,   43,  119,   43,    0,  822,  119,    0,    0, -110,
  119,   45,   43,    0,    0,    0,    0,    0,  129,  127,
    0,  860,  -96,    0,  800,  135,    0, -237,    0,    0,
  119,   43,    0,    0,  123,  126, -237,   60,    0,  139,
    0,  119,  119,   61,    0,    0,   43,  881,  907,    0,
    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,  182,    0,   64,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  130,    0,    0,  147,
    0,  147,    0,    0,    0,  149,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -58,    0,    0,    0,    0,
    0,  -55,    0,    0,    0,    0,    0,    0,    0,    0,
  -81,  -81,  -81,    0,  -81,  -81,  -81,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  918,    0,  458,    0,    0,  -81,
  -58,  -81,    0,  146,    0,    0,    0,  -81,  -81,    0,
    0,  -81,  360,  384,    0,    0,    0,    0,    0,  -81,
  -81,  -81,  -81,    0,    0,    0,    0,    0,    0,  -81,
  -81,  -81,  -81,  -81,  -81,  -81,  -81,  -81,  -81,  -81,
  -81,  -81,  -81,    0,  -81,  156,    0,    0,    0,    0,
  -81,   29,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -17,   56,    3,   65,  790,
   67,  518,  969,  980,  413,  422,  449,  898, 1000,    0,
  -25,  -58,  -81,  -58,    0,    0,  -81,    0,    0,    0,
  -81,    0,  -58,    0,    0,    0,    0,    0,    0,  166,
    0,    0,  -33,    0,   31,    0,    0,    0,    0,    0,
  -22,  -58,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -81,  -81,    0,    0,    0,  -58,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  205,  198,   34,    6,    0,    0,    0,  178,    0,
   46,    0, -118,  -85,    0,    0,    0,    0,    0,    0,
    0,    0,  954, 1208, 1066,    0,    0,    0,    0,    0,
 -164,    0,    4,  -91,    0,   13,
};
final static int YYTABLESIZE=1421;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        101,
   41,  101,  101,  103,  131,  138,  101,  144,   28,  129,
  127,  101,  128,  134,  130,   89,   22,   28,   41,   28,
    1,  134,   25,   39,   47,  101,  131,  133,    5,  132,
  101,  129,  127,  206,  128,  134,  130,   62,   59,   66,
   67,   39,  206,   67,   63,    7,   67,  131,  178,   61,
  205,  177,  129,  191,    9,  193,  134,  130,  135,   97,
   67,   67,   10,   33,  199,   33,  135,  179,   65,   91,
  177,   90,   91,   44,   90,   62,   24,   66,   67,  190,
  135,   26,   63,  211,   43,   31,   45,   61,   30,  101,
   32,  101,  184,  185,   39,   67,   66,   90,  221,   66,
   40,  135,   41,   42,  120,   64,   65,   60,   64,   62,
   60,   66,   67,   66,   66,  210,   63,   91,   92,   98,
   99,   61,   64,   64,   60,   60,  100,   42,  101,   64,
   62,  102,   66,   67,  110,  112,  113,   63,  136,  140,
   65,  114,   61,  115,  116,  141,  117,  145,   66,  118,
  146,   62,  119,   66,   67,  148,  171,   64,   63,   60,
  173,   65,  175,   61,  181,   42,  196,  198,  131,  200,
  177,  202,  149,  129,  127,  204,  128,  134,  130,  217,
  212,    1,   65,  213,  216,  220,   15,   20,    5,   19,
   31,  133,   49,  132,   27,   48,   49,   49,   49,   49,
   49,   49,   49,   29,  102,   38,   88,    6,   20,   37,
  214,    0,    0,   49,   49,   49,   49,   49,   48,  215,
    0,   48,  135,  101,  101,  101,  101,  101,  101,    0,
  101,  101,  101,  101,    0,  101,  101,  101,  101,  101,
  101,  101,  101,  101,    0,    0,   49,  101,   49,  123,
  124,   48,  101,  101,   48,  101,  101,  101,  101,  101,
  101,   12,   13,   14,   15,   16,   47,    0,   48,   49,
   50,   51,    0,   52,   53,   54,   55,   56,   57,   58,
   59,   67,    0,    0,    0,   60,    0,    0,    0,    0,
   19,   68,    0,   69,   70,    0,    0,   71,   72,   12,
   13,   14,   15,   16,   47,    0,   48,   49,   50,   51,
    0,   52,   53,   54,   55,   56,   57,   58,   59,    0,
    0,    0,    0,   60,    0,    0,    0,    0,   19,   68,
    0,   69,   70,   66,   66,   71,   72,  105,   47,    0,
   48,    0,   64,   64,   60,   60,    0,   54,   64,   64,
   57,   58,   59,    0,    0,    0,    0,   60,    0,   47,
    0,   48,    0,   68,    0,   69,    0,    0,   54,   71,
   72,   57,   58,   59,    0,    0,    0,    0,   60,    0,
   47,    0,   48,    0,   68,    0,   69,    0,    0,   54,
   71,   72,   57,   58,   59,    0,   69,    0,    0,   60,
   69,   69,   69,   69,   69,   68,   69,   69,    0,  121,
  122,   71,   72,  123,  124,  125,  126,   69,   69,   69,
   70,   69,    0,    0,   70,   70,   70,   70,   70,    0,
   70,    0,    0,   49,   49,    0,    0,   49,   49,   49,
   49,   70,   70,   70,    0,   70,    0,    0,    0,   57,
    0,    0,   69,   57,   57,   57,   57,   57,   58,   57,
    0,   18,   58,   58,   58,   58,   58,    0,   58,    0,
   57,   57,   57,    0,   57,    0,   70,    0,    0,   58,
   58,   58,    0,   58,    0,   59,    0,    0,    0,   59,
   59,   59,   59,   59,   53,   59,    0,    0,   40,   53,
   53,    0,   53,   53,   53,   57,   59,   59,   59,    0,
   59,    0,    0,    0,   58,    0,   40,   53,    0,   53,
  131,    0,    0,    0,  172,  129,  127,    0,  128,  134,
  130,   12,   13,   14,   15,   16,    0,    0,    0,    0,
    0,   59,    0,  133,    0,  132,  131,    0,   53,    0,
  174,  129,  127,    0,  128,  134,  130,  131,   61,    0,
   19,   61,  129,  127,  180,  128,  134,  130,    0,  133,
    0,  132,    0,    0,  135,   61,   61,    0,    0,  131,
  133,    0,  132,  182,  129,  127,    0,  128,  134,  130,
    0,    0,    0,   12,   13,   14,   15,   16,    0,    0,
  135,    0,  133,    0,  132,    0,    0,    0,    0,  131,
   61,  135,    0,    0,  129,  127,   17,  128,  134,  130,
    0,    0,   19,    0,    0,   12,   13,   14,   15,   16,
  183,    0,  133,  135,  132,    0,    0,   69,   69,    0,
    0,   69,   69,   69,   69,   96,    0,  131,    0,    0,
    0,  186,  129,  127,   19,  128,  134,  130,    0,    0,
    0,   70,   70,  135,    0,   70,   70,   70,   70,    0,
  133,    0,  132,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   57,   57,    0,    0,   57,   57,   57,   57,    0,   58,
   58,  135,    0,   58,   58,   58,   58,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   59,   59,    0,    0,
   59,   59,   59,   59,    0,   53,   53,    0,    0,   53,
   53,   53,   53,    0,    0,    0,  131,    0,    0,    0,
  187,  129,  127,    0,  128,  134,  130,    0,    0,    0,
    0,  121,  122,    0,    0,  123,  124,  125,  126,  133,
    0,  132,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  121,  122,    0,
    0,  123,  124,  125,  126,   61,   61,    0,  121,  122,
  135,    0,  123,  124,  125,  126,  131,    0,    0,    0,
    0,  129,  127,    0,  128,  134,  130,    0,    0,    0,
  121,  122,    0,    0,  123,  124,  125,  126,    0,  133,
   65,  132,    0,   65,    0,    0,  131,    0,    0,    0,
    0,  129,  127,    0,  128,  134,  130,   65,   65,    0,
  121,  122,    0,    0,  123,  124,  125,  126,  131,  133,
  135,  132,  188,  129,  127,    0,  128,  134,  130,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  133,   65,  132,    0,    0,    0,    0,  121,  122,
  135,    0,  123,  124,  125,  126,  131,    0,    0,    0,
    0,  129,  127,    0,  128,  134,  130,    0,    0,    0,
    0,    0,  135,    0,  194,    0,    0,  131,  201,  133,
    0,  132,  129,  127,    0,  128,  134,  130,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   63,  222,
  133,   63,  132,  131,    0,    0,    0,    0,  129,  127,
  135,  128,  134,  130,   52,   63,   63,    0,    0,   52,
   52,    0,   52,   52,   52,  223,  133,    0,  132,    0,
    0,  135,    0,    0,    0,  131,    0,   52,    0,   52,
  129,  127,    0,  128,  134,  130,    0,  121,  122,    0,
   63,  123,  124,  125,  126,    0,  131,  135,  133,   85,
  132,  129,  127,    0,  128,  134,  130,    0,   52,   55,
    0,   55,   55,   55,    0,    0,    0,    0,    0,  133,
   56,  132,   56,   56,   56,    0,   55,   55,   55,  135,
   55,    0,    0,    0,    0,    0,    0,   56,   56,   56,
   62,   56,    0,   62,   85,    0,    0,  121,  122,    0,
  135,  123,  124,  125,  126,    0,    0,   62,   62,    0,
    0,   55,    0,    0,    0,    0,    0,   65,   65,    0,
    0,    0,   56,   65,   65,    0,    0,  121,  122,    0,
    0,  123,  124,  125,  126,    0,    0,    0,    0,    0,
    0,    0,   62,    0,    0,    0,    0,    0,    0,  121,
  122,    0,    0,  123,  124,  125,  126,    0,    0,    0,
    0,   87,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   85,    0,   85,    0,    0,
    0,    0,    0,    0,    0,    0,   85,  121,  122,    0,
    0,  123,  124,  125,  126,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   85,   85,   87,    0,  121,  122,
    0,    0,  123,  124,  125,  126,    0,    0,    0,    0,
   85,    0,    0,    0,    0,   63,   63,    0,    0,    0,
    0,   63,   63,    0,  121,  122,    0,    0,  123,  124,
  125,  126,    0,    0,    0,   52,   52,    0,    0,   52,
   52,   52,   52,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  121,    0,    0,    0,
  123,  124,  125,  126,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   87,    0,   87,
    0,  123,  124,  125,  126,    0,   55,   55,   87,    0,
   55,   55,   55,   55,    0,    0,    0,   56,   56,   94,
    0,   56,   56,   56,   56,    0,   87,   87,  103,  104,
  106,    0,  107,  108,  109,    0,    0,   62,   62,    0,
    0,    0,   87,   62,   62,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  137,    0,  139,
    0,    0,    0,    0,    0,  142,  142,    0,    0,  147,
    0,    0,    0,    0,    0,    0,    0,  150,  151,  154,
  155,    0,    0,    0,    0,    0,    0,  156,  157,  158,
  159,  160,  161,  162,  163,  164,  165,  166,  167,  168,
  169,    0,  170,    0,    0,    0,    0,    0,  176,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  142,    0,
  192,    0,    0,    0,  195,    0,    0,    0,  197,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  218,
  219,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   59,   35,   36,   59,   37,   91,   40,   99,   91,   42,
   43,   45,   45,   46,   47,   41,   11,   91,   41,   91,
  261,   46,   17,   41,  262,   59,   37,   60,  277,   62,
   64,   42,   43,  198,   45,   46,   47,   33,  276,   35,
   36,   59,  207,   41,   40,  263,   44,   37,   41,   45,
  288,   44,   42,  172,  277,  174,   46,   47,   91,   54,
   58,   59,  123,   30,  183,   32,   91,   41,   64,   41,
   44,   41,   44,   40,   44,   33,  277,   35,   36,  171,
   91,   59,   40,  202,   39,   93,   41,   45,   40,  123,
   40,  125,  291,  292,   41,   93,   41,   40,  217,   44,
   44,   91,   41,  123,   61,   41,   64,   41,   44,   33,
   44,   35,   36,   58,   59,  201,   40,   40,   40,   40,
   40,   45,   58,   59,   58,   59,   40,  123,   40,  125,
   33,   40,   35,   36,   40,   40,   40,   40,  277,   40,
   64,   59,   45,   59,   59,   91,   59,   41,   93,   59,
   41,   33,   59,   35,   36,  277,   40,   93,   40,   93,
   59,   64,   41,   45,   41,  123,  277,  123,   37,   41,
   44,  268,   41,   42,   43,   41,   45,   46,   47,   41,
   58,    0,   64,   58,  125,  125,  123,   41,   59,   41,
   93,   60,   37,   62,  277,  277,   41,   42,   43,   44,
   45,   46,   47,  277,   59,  277,   41,    3,   11,   32,
  207,   -1,   -1,   58,   59,   60,   61,   62,  277,  207,
   -1,  277,   91,  257,  258,  259,  260,  261,  262,   -1,
  264,  265,  266,  267,   -1,  269,  270,  271,  272,  273,
  274,  275,  276,  277,   -1,   -1,   91,  281,   93,  282,
  283,  277,  286,  287,  277,  289,  290,  291,  292,  293,
  294,  257,  258,  259,  260,  261,  262,   -1,  264,  265,
  266,  267,   -1,  269,  270,  271,  272,  273,  274,  275,
  276,  279,   -1,   -1,   -1,  281,   -1,   -1,   -1,   -1,
  286,  287,   -1,  289,  290,   -1,   -1,  293,  294,  257,
  258,  259,  260,  261,  262,   -1,  264,  265,  266,  267,
   -1,  269,  270,  271,  272,  273,  274,  275,  276,   -1,
   -1,   -1,   -1,  281,   -1,   -1,   -1,   -1,  286,  287,
   -1,  289,  290,  278,  279,  293,  294,  261,  262,   -1,
  264,   -1,  278,  279,  278,  279,   -1,  271,  284,  285,
  274,  275,  276,   -1,   -1,   -1,   -1,  281,   -1,  262,
   -1,  264,   -1,  287,   -1,  289,   -1,   -1,  271,  293,
  294,  274,  275,  276,   -1,   -1,   -1,   -1,  281,   -1,
  262,   -1,  264,   -1,  287,   -1,  289,   -1,   -1,  271,
  293,  294,  274,  275,  276,   -1,   37,   -1,   -1,  281,
   41,   42,   43,   44,   45,  287,   47,  289,   -1,  278,
  279,  293,  294,  282,  283,  284,  285,   58,   59,   60,
   37,   62,   -1,   -1,   41,   42,   43,   44,   45,   -1,
   47,   -1,   -1,  278,  279,   -1,   -1,  282,  283,  284,
  285,   58,   59,   60,   -1,   62,   -1,   -1,   -1,   37,
   -1,   -1,   93,   41,   42,   43,   44,   45,   37,   47,
   -1,  125,   41,   42,   43,   44,   45,   -1,   47,   -1,
   58,   59,   60,   -1,   62,   -1,   93,   -1,   -1,   58,
   59,   60,   -1,   62,   -1,   37,   -1,   -1,   -1,   41,
   42,   43,   44,   45,   37,   47,   -1,   -1,   41,   42,
   43,   -1,   45,   46,   47,   93,   58,   59,   60,   -1,
   62,   -1,   -1,   -1,   93,   -1,   59,   60,   -1,   62,
   37,   -1,   -1,   -1,   41,   42,   43,   -1,   45,   46,
   47,  257,  258,  259,  260,  261,   -1,   -1,   -1,   -1,
   -1,   93,   -1,   60,   -1,   62,   37,   -1,   91,   -1,
   41,   42,   43,   -1,   45,   46,   47,   37,   41,   -1,
  286,   44,   42,   43,   44,   45,   46,   47,   -1,   60,
   -1,   62,   -1,   -1,   91,   58,   59,   -1,   -1,   37,
   60,   -1,   62,   41,   42,   43,   -1,   45,   46,   47,
   -1,   -1,   -1,  257,  258,  259,  260,  261,   -1,   -1,
   91,   -1,   60,   -1,   62,   -1,   -1,   -1,   -1,   37,
   93,   91,   -1,   -1,   42,   43,  280,   45,   46,   47,
   -1,   -1,  286,   -1,   -1,  257,  258,  259,  260,  261,
   58,   -1,   60,   91,   62,   -1,   -1,  278,  279,   -1,
   -1,  282,  283,  284,  285,  277,   -1,   37,   -1,   -1,
   -1,   41,   42,   43,  286,   45,   46,   47,   -1,   -1,
   -1,  278,  279,   91,   -1,  282,  283,  284,  285,   -1,
   60,   -1,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  278,  279,   -1,   -1,  282,  283,  284,  285,   -1,  278,
  279,   91,   -1,  282,  283,  284,  285,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  278,  279,   -1,   -1,
  282,  283,  284,  285,   -1,  278,  279,   -1,   -1,  282,
  283,  284,  285,   -1,   -1,   -1,   37,   -1,   -1,   -1,
   41,   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,
   -1,  278,  279,   -1,   -1,  282,  283,  284,  285,   60,
   -1,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  278,  279,   -1,
   -1,  282,  283,  284,  285,  278,  279,   -1,  278,  279,
   91,   -1,  282,  283,  284,  285,   37,   -1,   -1,   -1,
   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,
  278,  279,   -1,   -1,  282,  283,  284,  285,   -1,   60,
   41,   62,   -1,   44,   -1,   -1,   37,   -1,   -1,   -1,
   -1,   42,   43,   -1,   45,   46,   47,   58,   59,   -1,
  278,  279,   -1,   -1,  282,  283,  284,  285,   37,   60,
   91,   62,   93,   42,   43,   -1,   45,   46,   47,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   60,   93,   62,   -1,   -1,   -1,   -1,  278,  279,
   91,   -1,  282,  283,  284,  285,   37,   -1,   -1,   -1,
   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,
   -1,   -1,   91,   -1,   93,   -1,   -1,   37,   59,   60,
   -1,   62,   42,   43,   -1,   45,   46,   47,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   41,   59,
   60,   44,   62,   37,   -1,   -1,   -1,   -1,   42,   43,
   91,   45,   46,   47,   37,   58,   59,   -1,   -1,   42,
   43,   -1,   45,   46,   47,   59,   60,   -1,   62,   -1,
   -1,   91,   -1,   -1,   -1,   37,   -1,   60,   -1,   62,
   42,   43,   -1,   45,   46,   47,   -1,  278,  279,   -1,
   93,  282,  283,  284,  285,   -1,   37,   91,   60,   46,
   62,   42,   43,   -1,   45,   46,   47,   -1,   91,   41,
   -1,   43,   44,   45,   -1,   -1,   -1,   -1,   -1,   60,
   41,   62,   43,   44,   45,   -1,   58,   59,   60,   91,
   62,   -1,   -1,   -1,   -1,   -1,   -1,   58,   59,   60,
   41,   62,   -1,   44,   91,   -1,   -1,  278,  279,   -1,
   91,  282,  283,  284,  285,   -1,   -1,   58,   59,   -1,
   -1,   93,   -1,   -1,   -1,   -1,   -1,  278,  279,   -1,
   -1,   -1,   93,  284,  285,   -1,   -1,  278,  279,   -1,
   -1,  282,  283,  284,  285,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   93,   -1,   -1,   -1,   -1,   -1,   -1,  278,
  279,   -1,   -1,  282,  283,  284,  285,   -1,   -1,   -1,
   -1,   46,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  172,   -1,  174,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  183,  278,  279,   -1,
   -1,  282,  283,  284,  285,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  201,  202,   91,   -1,  278,  279,
   -1,   -1,  282,  283,  284,  285,   -1,   -1,   -1,   -1,
  217,   -1,   -1,   -1,   -1,  278,  279,   -1,   -1,   -1,
   -1,  284,  285,   -1,  278,  279,   -1,   -1,  282,  283,
  284,  285,   -1,   -1,   -1,  278,  279,   -1,   -1,  282,
  283,  284,  285,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  278,   -1,   -1,   -1,
  282,  283,  284,  285,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  172,   -1,  174,
   -1,  282,  283,  284,  285,   -1,  278,  279,  183,   -1,
  282,  283,  284,  285,   -1,   -1,   -1,  278,  279,   52,
   -1,  282,  283,  284,  285,   -1,  201,  202,   61,   62,
   63,   -1,   65,   66,   67,   -1,   -1,  278,  279,   -1,
   -1,   -1,  217,  284,  285,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   90,   -1,   92,
   -1,   -1,   -1,   -1,   -1,   98,   99,   -1,   -1,  102,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  110,  111,  112,
  113,   -1,   -1,   -1,   -1,   -1,   -1,  120,  121,  122,
  123,  124,  125,  126,  127,  128,  129,  130,  131,  132,
  133,   -1,  135,   -1,   -1,   -1,   -1,   -1,  141,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  171,   -1,
  173,   -1,   -1,   -1,  177,   -1,   -1,   -1,  181,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  212,
  213,
};
}
final static short YYFINAL=2;
final static short YYMAXTOKEN=296;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,"'#'","'$'","'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,"':'",
"';'","'<'","'='","'>'",null,"'@'",null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"VOID","BOOL","INT","STRING",
"CLASS","NULL","EXTENDS","THIS","WHILE","FOR","IF","ELSE","RETURN","BREAK",
"NEW","PRINT","PRINTCOMP","READ_INTEGER","READ_LINE","LITERAL","IDENTIFIER",
"AND","OR","STATIC","INSTANCEOF","LESS_EQUAL","GREATER_EQUAL","EQUAL",
"NOT_EQUAL","COMPLEX","CASE","DEFAULT","SUPER","DO","OD","DO_SEP","DCOPY",
"SCOPY","UMINUS","EMPTY",
};
final static String yyrule[] = {
"$accept : Program",
"Program : ClassList",
"ClassList : ClassList ClassDef",
"ClassList : ClassDef",
"VariableDef : Variable ';'",
"Variable : Type IDENTIFIER",
"Type : INT",
"Type : VOID",
"Type : BOOL",
"Type : STRING",
"Type : COMPLEX",
"Type : CLASS IDENTIFIER",
"Type : Type '[' ']'",
"ClassDef : CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ExtendsClause : EXTENDS IDENTIFIER",
"ExtendsClause :",
"FieldList : FieldList VariableDef",
"FieldList : FieldList FunctionDef",
"FieldList :",
"Formals : VariableList",
"Formals :",
"VariableList : VariableList ',' Variable",
"VariableList : Variable",
"FunctionDef : STATIC Type IDENTIFIER '(' Formals ')' StmtBlock",
"FunctionDef : Type IDENTIFIER '(' Formals ')' StmtBlock",
"StmtBlock : '{' StmtList '}'",
"StmtList : StmtList Stmt",
"StmtList :",
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : PrintCompStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : StmtBlock",
"Stmt : DoStmt ';'",
"SimpleStmt : LValue '=' Expr",
"SimpleStmt : Call",
"SimpleStmt :",
"DoStmt : DO DoBranchList DoSubStmt OD",
"DoSubStmt : Expr ':' Stmt",
"DoBranch : DoSubStmt DO_SEP",
"DoBranchList : DoBranchList DoBranch",
"DoBranchList :",
"Receiver : Expr '.'",
"Receiver :",
"LValue : Receiver IDENTIFIER",
"LValue : Expr '[' Expr ']'",
"Call : Receiver IDENTIFIER '(' Actuals ')'",
"Expr : LValue",
"Expr : Call",
"Expr : Constant",
"Expr : Expr '+' Expr",
"Expr : Expr '-' Expr",
"Expr : Expr '*' Expr",
"Expr : Expr '/' Expr",
"Expr : Expr '%' Expr",
"Expr : Expr EQUAL Expr",
"Expr : Expr NOT_EQUAL Expr",
"Expr : Expr '<' Expr",
"Expr : Expr '>' Expr",
"Expr : Expr LESS_EQUAL Expr",
"Expr : Expr GREATER_EQUAL Expr",
"Expr : Expr AND Expr",
"Expr : Expr OR Expr",
"Expr : '(' Expr ')'",
"Expr : '-' Expr",
"Expr : '!' Expr",
"Expr : '@' Expr",
"Expr : '$' Expr",
"Expr : '#' Expr",
"Expr : READ_INTEGER '(' ')'",
"Expr : READ_LINE '(' ')'",
"Expr : THIS",
"Expr : SUPER",
"Expr : NEW IDENTIFIER '(' ')'",
"Expr : NEW Type '[' Expr ']'",
"Expr : INSTANCEOF '(' Expr ',' IDENTIFIER ')'",
"Expr : '(' CLASS IDENTIFIER ')' Expr",
"Expr : CASE '(' Expr ')' '{' CaseItems DefaultItem '}'",
"Expr : CASE '(' Expr ')' '{' DefaultItem '}'",
"Expr : DCOPY '(' Expr ')'",
"Expr : SCOPY '(' Expr ')'",
"Constant : LITERAL",
"Constant : NULL",
"Actuals : ExprList",
"Actuals :",
"ExprList : ExprList ',' Expr",
"ExprList : Expr",
"WhileStmt : WHILE '(' Expr ')' Stmt",
"ForStmt : FOR '(' SimpleStmt ';' Expr ';' SimpleStmt ')' Stmt",
"BreakStmt : BREAK",
"IfStmt : IF '(' Expr ')' Stmt ElseClause",
"CaseItem : Constant ':' Expr ';'",
"DefaultItem : DEFAULT ':' Expr ';'",
"CaseItems : CaseItems CaseItem",
"CaseItems : CaseItem",
"ElseClause : ELSE Stmt",
"ElseClause :",
"ReturnStmt : RETURN Expr",
"ReturnStmt : RETURN",
"PrintStmt : PRINT '(' ExprList ')'",
"PrintCompStmt : PRINTCOMP '(' ExprList ')'",
};

//#line 526 "Parser.y"
    
	/**
	 * 打印当前归约所用的语法规则<br>
	 * 请勿修改。
	 */
    public boolean onReduce(String rule) {
		if (rule.startsWith("$$"))
			return false;
		else
			rule = rule.replaceAll(" \\$\\$\\d+", "");

   	    if (rule.endsWith(":"))
    	    System.out.println(rule + " <empty>");
   	    else
			System.out.println(rule);
		return false;
    }
    
    public void diagnose() {
		addReduceListener(this);
		yyparse();
	}
//#line 715 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    //if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      //if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        //if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        //if (yychar < 0)    //it it didn't work/error
        //  {
        //  yychar = 0;      //change it to default string (no -1!)
          //if (yydebug)
          //  yylexdebug(yystate,yychar);
        //  }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        //if (yydebug)
          //debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      //if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0 || valptr<0)   //check for under & overflow here
            {
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            //if (yydebug)
              //debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            //if (yydebug)
              //debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0 || valptr<0)   //check for under & overflow here
              {
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        //if (yydebug)
          //{
          //yys = null;
          //if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          //if (yys == null) yys = "illegal-symbol";
          //debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          //}
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    //if (yydebug)
      //debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    if (reduceListener == null || reduceListener.onReduce(yyrule[yyn])) // if intercepted!
      switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 62 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 68 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 72 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 82 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 88 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 92 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 96 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 100 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 10:
//#line 104 "Parser.y"
{
                        yyval.type = new Tree.TypeIdent(Tree.COMPLEX,val_peek(0).loc);
                    }
break;
case 11:
//#line 108 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 12:
//#line 112 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 13:
//#line 118 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
					}
break;
case 14:
//#line 124 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 128 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 134 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 138 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 142 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 150 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 157 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 161 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 168 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 172 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 178 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 184 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 188 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 28:
//#line 195 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 29:
//#line 200 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 39:
//#line 217 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 40:
//#line 221 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 41:
//#line 225 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 42:
//#line 231 "Parser.y"
{
                        yyval.stmt = new Tree.DoStmt(val_peek(2).subStmtList,val_peek(1).doSubStmt,val_peek(3).loc);
                    }
break;
case 43:
//#line 236 "Parser.y"
{
                        yyval.doSubStmt = new Tree.DoSubStmt(val_peek(2).expr,val_peek(0).stmt,val_peek(2).loc);
                    }
break;
case 44:
//#line 242 "Parser.y"
{
                        yyval.doSubStmt = val_peek(1).doSubStmt;
                    }
break;
case 45:
//#line 248 "Parser.y"
{
                        yyval.subStmtList.add(val_peek(0).doSubStmt);
                    }
break;
case 46:
//#line 252 "Parser.y"
{
                    yyval = new SemValue();
                    yyval.subStmtList = new ArrayList<DoSubStmt>();
                }
break;
case 48:
//#line 260 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 49:
//#line 266 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 50:
//#line 273 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 51:
//#line 279 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 52:
//#line 288 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 55:
//#line 294 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 56:
//#line 298 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 57:
//#line 302 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 58:
//#line 306 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 59:
//#line 310 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 314 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 318 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 322 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 326 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 330 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 334 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 338 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 67:
//#line 342 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 346 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 69:
//#line 350 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 354 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 358 "Parser.y"
{
                        yyval.expr = new Tree.Unary(Tree.RE, val_peek(0).expr, val_peek(1).loc);
                    }
break;
case 72:
//#line 362 "Parser.y"
{
                        yyval.expr = new Tree.Unary(Tree.IM, val_peek(0).expr, val_peek(1).loc);
                    }
break;
case 73:
//#line 366 "Parser.y"
{
                        yyval.expr = new Tree.Unary(Tree.COMPCAST, val_peek(0).expr, val_peek(1).loc);
                    }
break;
case 74:
//#line 370 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 75:
//#line 374 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 76:
//#line 378 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 77:
//#line 382 "Parser.y"
{
                        yyval.expr = new Tree.SuperExpr(val_peek(0).loc);
                    }
break;
case 78:
//#line 386 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 79:
//#line 390 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 80:
//#line 394 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 81:
//#line 398 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 82:
//#line 402 "Parser.y"
{
                        yyval.expr = new Tree.Case(val_peek(5).expr,val_peek(2).caseItems,val_peek(1).defaultItem,val_peek(7).loc);
                    }
break;
case 83:
//#line 406 "Parser.y"
{
                        yyval.expr = new Tree.Case(val_peek(4).expr,null,val_peek(1).defaultItem,val_peek(6).loc);
                    }
break;
case 84:
//#line 410 "Parser.y"
{
                        yyval.expr = new Tree.Dcopy(val_peek(1).expr,val_peek(3).loc);
                    }
break;
case 85:
//#line 414 "Parser.y"
{
                        yyval.expr = new Tree.Scopy(val_peek(1).expr,val_peek(3).loc);
                    }
break;
case 86:
//#line 421 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
                        yyval.constantValue = val_peek(0).literal;
					}
break;
case 87:
//#line 426 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 89:
//#line 433 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 90:
//#line 440 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 91:
//#line 444 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 92:
//#line 451 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 93:
//#line 457 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 94:
//#line 463 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 95:
//#line 469 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 96:
//#line 474 "Parser.y"
{
                        yyval.caseItem = new Tree.CaseItem(val_peek(3).expr,val_peek(1).expr,val_peek(3).constantValue, val_peek(3).loc);
                    }
break;
case 97:
//#line 479 "Parser.y"
{
                        yyval.defaultItem = new Tree.DefaultItem(val_peek(1).expr,val_peek(3).loc);
                    }
break;
case 98:
//#line 484 "Parser.y"
{
                        yyval.caseItems.add(val_peek(0).caseItem);
                    }
break;
case 99:
//#line 488 "Parser.y"
{
                        yyval.caseItems = new ArrayList<Tree.CaseItem>();
                        yyval.caseItems.add(val_peek(0).caseItem);
                    }
break;
case 100:
//#line 495 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 101:
//#line 499 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 102:
//#line 505 "Parser.y"
{
                       yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 103:
//#line 509 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 104:
//#line 515 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
case 105:
//#line 521 "Parser.y"
{
                        yyval.stmt = new PrintComp(val_peek(1).elist, val_peek(3).loc);
                    }
break;
//#line 1419 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    //if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      //if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        //if (yychar<0) yychar=0;  //clean, if necessary
        //if (yydebug)
          //yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      //if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
//## The -Jnorun option was used ##
//## end of method run() ########################################



//## Constructors ###############################################
//## The -Jnoconstruct option was used ##
//###############################################################



}
//################### END OF CLASS ##############################

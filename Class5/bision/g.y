%{
#include<stdio.h>
#include<ctype.h>
%}

%token DIGITO

%%
linha : expr '\n' {printf ("%d\n",$1);}
      ;
expr  :  expr '+' termo {$$ = $1 + $3;}
      |  termo
      ;
termo : termo '*' fator {$$ = $1 *$3;}
      | fator
      ;
fator : '(' expr ')' { $$ =$2;}
      | DIGITO
      ;

%%

yyerror(char *s)
{ fprintf (stderr, "%s\n",s);}

main (void)
{
 yyparse();
}

yylex (){
	int c;
        c = getchar();
        if (isdigit(c)){
	  yylval = c -'0';
	  return DIGITO;
        }
        return c;
      }

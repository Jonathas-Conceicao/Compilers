DIGITO	[0-9]
LETRA	[a-zA-Z]
ID	{LETRA}({LETRA}|{DIGITO})*
OP "+"|"-"|"*"|"/"|">"|"<"|"&&"|"||"|"=="
MAIN "main"

%%
{MAIN}                  {printf("Palavra reservada: %s", yytext);}
{DIGITO}+               {printf("Inteiro: %s\n", yytext);}
{DIGITO}+"."{DIGITO}+   {printf("Real: %s\n", yytext);} 
{ID}                    {printf("var: %s\n", yytext);}
{OP}                    {printf("Operador Binário: %s\n", yytext);}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}

OPA "+"|"-"|"*"|"/"
OPL ">"|"<"|"&&"|"||"|"=="
APAR "("
FPAR ")"
ACHV "{"
FCHV "}"
ATRIB ":="
FL ";"
IF "if"
WHILE "while"
DO "do"
RETURN "return"
PRINT "print"
MAIN "main"
DIGITO   [0-9]
DIGITOS  {DIGITO}+
REAIS    {DIGITOS}("."{DIGITOS})
LETRA    [a-zA-Z]
ID       {LETRA}({LETRA}|{DIGITO})*
PRESEV {IF}|{WHILE}|{DO}|{RETURN}|{PRINT}|{MAIN}

%%
{PRESEV}                {printf("Palavra reservada: %s", yytext);}
{DIGITOS}               {printf("Inteiro: %s\n", yytext);}
{REAIS}                 {printf("Real: %s\n", yytext);} 
{ID}                    {printf("Var: %s\n", yytext);}
{OPA}                   {printf("Operador Binário: %s\n", yytext);}
{OPL}                   {printf("Operador lógico: %s\n", yytext);}
{ATRIB}                 {printf("Atribuição: %s\n", yytext);}
{FL}                    {printf("Final de linha: %s\n", yytext);}
{APAR}                  {printf("Abre parênteses: %s", yytext);}
{FPAR}                  {printf("Fecha parênteses: %s", yytext);}
{ACHV}                  {printf("Abre chaves: %s", yytext);}
{FCHV}                  {printf("Fecha chaves: %s", yytext);}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}

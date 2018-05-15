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
INT "int"
BOOL "bool"
FUNC "function"
CONSTB   "true"|"false"
DIGITO   [0-9]
DIGITOS  {DIGITO}+
REAIS    {DIGITOS}("."{DIGITOS})
LETRA    [a-zA-Z]
ID       {LETRA}({LETRA}|{DIGITO})*
PRESEV   {IF}|{WHILE}|{DO}|{RETURN}|{PRINT}|{MAIN}|{INT}|{BOOL}|{FUNC}

SKIPED   " "|\t|\n

%%
{CONSTB}                {printf("Constante booleana: %s\n", yytext);}
{PRESEV}                {printf("Palavra reservada: %s\n", yytext);}
{DIGITOS}               {printf("Inteiro: %s\n", yytext);}
{REAIS}                 {printf("Real: %s\n", yytext);} 
{ID}                    {printf("Var: %s\n", yytext);}
{OPA}                   {printf("Operador aritmético: %s\n", yytext);}
{OPL}                   {printf("Operador lógico: %s\n", yytext);}
{ATRIB}                 {printf("Atribuição: %s\n", yytext);}
{FL}                    {printf("Final de linha: %s\n", yytext);}
{APAR}                  {printf("Abre parênteses: %s\n", yytext);}
{FPAR}                  {printf("Fecha parênteses: %s\n", yytext);}
{ACHV}                  {printf("Abre chaves: %s\n", yytext);}
{FCHV}                  {printf("Fecha chaves: %s\n", yytext);}
{SKIPED}                {printf("");}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}

import java.io.*;

enum TokenType{ NUM, SOMA, SUB, MULT, DIV, APar, FPar, EOF}

class Token{
  String lexema;
  TokenType token;

 Token (String l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	Token getNextToken() throws Exception
	{	
		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  arquivo.read();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
			if(currchar1 != eof && currchar1 !=10) {
				if (currchar >= '0' && currchar <= '9') {
					String numero;
					do {
						numero += currchar;
						currchar1 =  arquivo.read();
						currchar = (char) currchar1;
					} while (currchar >= '0' && currchar <= '9');
					return (new Token (numero, TokenType.NUM));
				} else {
					switch (currchar){
						case '(':
							return (new Token (new String(currchar),TokenType.APar));
						case ')':
							return (new Token (new String(currchar),TokenType.FPar));
						case '+':
							return (new Token (new String(currchar),TokenType.SOMA));
						case '-':
							return (new Token (new String(currchar),TokenType.SUB));
						case '/':
							return (new Token (new String(currchar),TokenType.DIV));
						case '*':
							return (new Token (new String(currchar),TokenType.MULT));
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
				}
			}

			arquivo.close();
			
		return (new Token(currchar,TokenType.EOF));
		
	}
}

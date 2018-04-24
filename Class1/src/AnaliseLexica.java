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
  int buffer = 0;

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	int consumir() throws Exception {
		if (buffer == 0)
			return arquivo.read();
		else {
		  int buffer = this.buffer;
			this.buffer = 0;
			return buffer;
		}
	}

	void devolver(int c) {
		this.buffer = c;
	}

	Token getNextToken() throws Exception {

		Token token;
		int eof = -1;
		char currchar;
		int currchar1;

			do{
				currchar1 =  this.consumir();
				currchar = (char) currchar1;
			} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');

			if(currchar1 != eof && currchar1 !=10) {
				// System.out.printf("Found %c\n", currchar);
				if (currchar >= '0' && currchar <= '9') {
					String numero = new String();
					do {
						numero += currchar;
						currchar1 = this.consumir();
						currchar = (char) currchar1;
					} while (currchar >= '0' && currchar <= '9');
					this.devolver(currchar1);
					return (new Token (numero, TokenType.NUM));
				} else {
					switch (currchar){
						case '(':
							return (new Token (String.valueOf(currchar), TokenType.APar));
						case ')':
							return (new Token (String.valueOf(currchar), TokenType.FPar));
						case '+':
							return (new Token (String.valueOf(currchar), TokenType.SOMA));
						case '-':
							return (new Token (String.valueOf(currchar), TokenType.SUB));
						case '/':
							return (new Token (String.valueOf(currchar), TokenType.DIV));
						case '*':
							return (new Token (String.valueOf(currchar), TokenType.MULT));
						default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
					}
				}
			}

			arquivo.close();
			return (new Token(String.valueOf(currchar), TokenType.EOF));
	}
}

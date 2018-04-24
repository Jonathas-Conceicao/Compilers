class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen();
			CodeInterpret interpreter = new CodeInterpret();
			String codigo = backend.geraCodigo(arv);
			int value = interpreter.interpret(arv);
			System.out.println(codigo + "\nInterpreted value:" + value);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}

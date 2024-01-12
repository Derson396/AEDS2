class IsR{
	public static void main (String[] args){//metodo principal que vai chamar a recursividade
		String word = MyIO.readLine();
		recursivo(word);
	}
	public static void recursivo (String word){
		if(!word.equals("FIM")){//repete ate a palavra for diferente de FIM
			MyIO.println(result(word));
			word = MyIO.readLine();
			recursivo(word);
		}
	}
	public static String result (String word){//metodo que imprime as respostas
		String print = "";
		if (eVog(word)){
            print+="SIM ";
        }else{
            print+="NAO ";
        }
		if (eConsoante(word)){
            print+="SIM ";
        }else{
            print+="NAO ";
        }
		if (eInteiro(word)){
            print+="SIM ";
        }else{
            print+="NAO ";
        }
		if (eRea(word)){
            print+="SIM";
        }else{
            print+="NAO";
        }
		return print;
	}
	public static boolean eVog (String word){//testa se é vogal
		boolean teste = false;
		if (word.length()>0)
			teste = true;
		for (int i=0; i<word.length() && teste; i++){
			if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u'){
			    if(word.charAt(i) != 'A' && word.charAt(i) != 'E' && word.charAt(i) != 'I' && word.charAt(i) != 'O' && word.charAt(i) != 'U'){	
				teste = false;
				}
			}
		}
		return teste;
	}
	public static boolean eConsoante (String word){//testa se e consoante
		boolean teste = false;
		if (word.length()>0)
			teste = true;
		for (int i=0; i<word.length() && teste; i++){
			if (!('a'<word.charAt(i) && word.charAt(i)<='z') && !('A'<word.charAt(i) && word.charAt(i)<='Z'))
				teste = false;
			if (word.charAt(i) == 'a' && word.charAt(i) == 'e' && word.charAt(i) == 'i' && word.charAt(i) == 'o' && word.charAt(i) == 'u'&& word.charAt(i) == 'A' && word.charAt(i) == 'E' && word.charAt(i) == 'I' && word.charAt(i) == 'O' && word.charAt(i) == 'U'){
				teste = false;
		}
		}
		return teste;
	}
	public static boolean eInteiro (String word){//testa se e inteiro
                boolean teste = false;
                if (word.length()>0)
                        teste = true;
 
                for (int i=0; i<word.length() && teste; i++){
                         if (!('0'<=word.charAt(i) && word.charAt(i)<='9'))
                                 teste = false;
                }
                return teste;
        }
	public static boolean eRea (String word){//testa se e real
		boolean teste = false;
		int sinal = 0;
		if (word.length()>0)
			teste = true;
		
		for (int i=0; i<word.length() && teste; i++){
			if (word.charAt(i) == '.' || word.charAt(i) == ','){
				sinal++;
				if (sinal>1)
					teste = false;
			}
			else
				if(!('0'<=word.charAt(i) && word.charAt(i)<='9')){
					teste = false;
				}
		}
		return teste;
	}
}
class palindronoR{
    public static boolean palindromo (String word){
      int contagem = 0;
      boolean resultado = false;
      int atras = word.length() - 1;//ultima posicao do palidrono
      if(word.length()>0){
         resultado = true;
      }
      while(resultado && contagem<atras){
        if(word.charAt(contagem)==' '||word.charAt(atras)==' ')//testa se ha espaços em branco
        {
            if(word.charAt(contagem)==' '){contagem++;}
            if(word.charAt(atras)==' '){atras--;}
        }
        else{
         resultado = word.charAt(contagem)==word.charAt(atras);//Se der falso para o ciclo while
         contagem++;atras--;}
      }
      return resultado;
   }
   	public static void Recursivo(String word){
   		if(!word.equals("FIM")){//testa a primeira string
   			if (palindromo(word)){
            	MyIO.println("SIM");
         	}
         	else { MyIO.println("NAO");}
   			word = MyIO.readLine();//Lê a proxima string
   			Recursivo(word);
   		}
   	}
   public static void main (String[] args){
      String word = " ";
      word = MyIO.readLine();//lê a primeira string
      Recursivo(word);
   }
}
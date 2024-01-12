/**
 * TP01 - Questao 9
 * @author Wanderson De Souza Pessoa
 * Matrícula: 775097
 */
public class is{
    public static boolean eVogal(String word)//um metodo que verifica se é vogais
    {
        int numeroVogal=0;
        for(int i=0; i<word.length();i++)
        {
            if(word.charAt(i) == 'a' || word.charAt(i) == 'e'
			   || word.charAt(i) == 'i' || word.charAt(i) == 'o'
			   || word.charAt(i) == 'u'|| word.charAt(i) == 'A' || word.charAt(i) == 'E'
			   || word.charAt(i) == 'I' || word.charAt(i) == 'O'|| word.charAt(i) == 'U')
			{
				numeroVogal++;
			}
        }
        if (numeroVogal == word.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean eConsoante(String word) // um metodo que verifica se é consoantes
	{	int numeroConso = 0;
		for (int i = 0; i < word.length(); i++)
		{
			if (!('a'<word.charAt(i) && word.charAt(i)<='z') 
				&& ('A'<word.charAt(i) && word.charAt(i)<='Z'))
			{
			if (!(word.charAt(i) == 'a' || word.charAt(i) == 'e' ||
				word.charAt(i)== 'i' || word.charAt(i) == 'o' ||
				word.charAt(i) == 'u' || word.charAt(i) == 'A' || word.charAt(i) == 'E'
			   || word.charAt(i) == 'I' || word.charAt(i) == 'O'|| word.charAt(i) == 'U'))
			{
				numeroConso++;
			}
			}
		}
		if (numeroConso == word.length())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean eInteiro (String word) // um metodo que verifica se é inteiro
		{
            for (int j = 0; j < word.length(); j++)
            {
		        if (!(word.charAt(j) == ',' || word.charAt(j) == '.'))
			    {
			        return false;
			    }
            }
		    for (int i = 0; i < word.length(); i++)
            {
			    if(word.charAt(i) >= '0' && word.charAt(i) <= '9')
                {
                    return true;
			    }
		    }
        return false;
	}
	public static boolean eReal (String word) // um metodo que verifica se é real
	{
        for (int i = 0; i < word.length(); i++)
		{
			if (word.charAt(i) == ',' || word.charAt(i) == '.')
			{
				return true;
			}
		}
		return false;
	}
    
    public static void main(String[] args) {
        String word="";
        do{
            word=MyIO.readLine();
            if(eVogal(word))
            {
                MyIO.print("SIM ");
            }
            else
            {
                MyIO.print("NAO ");
            }
            if(eConsoante(word))
            {
                MyIO.print("SIM ");
            }
            else
            {
                MyIO.print("NAO ");
            }
            if(eInteiro(word))
            {
                MyIO.print("SIM ");
            }
            else
            {
                MyIO.print("NAO ");
            }
            if(eReal(word))
            {
                MyIO.print("SIM \n");
            }
            else
            {
                MyIO.print("NAO \n");
            }
        }while(!word.equals("FIM"));
    }
}
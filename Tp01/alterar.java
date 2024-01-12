/**
 * TP01 - Questao 4
 * @author Wanderson de Souza Pessoa
 * Matrícula: 775097
 */
import java.util.Random; // para funcoes de randomização
public class alterar{
    public static String StringAltered (String word, Random generator)//altera a string
    {
        char random1 = (char) ('a' + (Math.abs(generator.nextInt()) % 26));
        char random2 = (char) ('a' + (Math.abs(generator.nextInt()) % 26));
        String alteredWord = "";
                for (int i = 0; i < word.length(); i++)
                {
                        if (word.charAt(i) == random1)
                        {
                                alteredWord = alteredWord + random2;
                        }
                        else
                        {
                                alteredWord = alteredWord +  word.charAt(i);
                        }
                }
                return alteredWord;
    
    }
        public static void main (String[] args)//metodo principal
        {
                Random generator = new Random();
                generator.setSeed(4);
                String word = MyIO.readLine();
                do
                {
                MyIO.println(StringAltered(word, generator));
                word = MyIO.readLine();
                }while(!word.equals("FIM"));
        }
}
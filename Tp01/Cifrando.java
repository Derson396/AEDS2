/**
 * TP01 - Questao 3
 * @author Wanderson de Souza Pessoa
 * Matrícula: 775097
 */
public class Cifrando
{
    public static String criptografando(String letter)//metodo pra criptografar pelo ciframento de César
    {
        String Cifrada = " ";
        for (int i = 0; i < letter.length(); i++)
		{
			Cifrada += ((char)(letter.charAt(i)+3));
		}
		return Cifrada;
	}
    public static void main(String[] args) {//metodo principal
        String word=MyIO.readLine();
        do
		{
            MyIO.println(criptografando(word));
            word = MyIO.readLine();
		}while(!word.equals("FIM"));
    }
}
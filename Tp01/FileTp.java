/**
 * TP01 - Questao 9
 * @author Wanderson De Souza Pessoa
 * Matrícula: 775097
 */
import java.io.RandomAccessFile;

public class FileTp{
	
	public static void main (String[] args){
		int numero = MyIO.readInt();
		double l;
		try{	
			RandomAccessFile Arquivo = new RandomAccessFile ("arquivo", "rw"); // abrir para escrever
			for (int i = 0; i < numero; i++){
				
				l = MyIO.readDouble();
				Arquivo.writeDouble(l);
			}
			Arquivo.close(); // fechar arquivo

			RandomAccessFile file = new RandomAccessFile ("arquivo", "r"); // abrir para leitura
			file.seek(numero * 8 - 8);	
			for (int j = 1; j < numero; j++){
				l = file.readDouble();
				if (l % 1 == 0)
					MyIO.println((int)l);
				else
					MyIO.println(l);
				file.seek(file.getFilePointer() - 16);
			}
			MyIO.println(file.readDouble());
			file.close(); // fechar arquivo	
		}
			catch (Exception exc){
				MyIO.println("Exception Caugh: " + exc);
			}	
}
	}
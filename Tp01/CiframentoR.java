public class CiframentoR {
	public static StringBuilder CifrasR (String word, StringBuilder tmp, int size, int count) {
		char x = (word.charAt(count));//na primeira chamada o count é igual a 0
		x += 3;
		if (count < size-1){
			tmp.append(x);
			CifrasR(word, tmp, size, count+=1);//vai fazer em loop ate o count chegar na ultima letra
		}
		else{
			x = (word.charAt(count));
			x += 3;
			tmp.append(x);
		}
		return (tmp);
	}
    public static void main (String[] args){//metodo principal
      String word;
      StringBuilder tmp = new StringBuilder();
      int size;
      do {
         word = MyIO.readLine();
         size = word.length();
         String sb = (CifrasR(word, tmp, size, 0)).toString();
         MyIO.println(sb);
         tmp.setLength(0);
      } while (!word.equals("FIM"));//para se achar a palavra FIM
    }
}
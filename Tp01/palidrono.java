public class palidrono{
    static boolean checarPalid(String palavra)//classe para checar se e um palindromo
    {
        String palavrateste="";
        String palavraReversa="";
        char testar;
        for(int i=(palavra.length())-1;i>=0;i--)
        {
            testar= palavra.charAt(i);
            if(testar!=' '){//tira os espaços
                palavraReversa += palavra.charAt(i);//inverte a ordem das letras
            }
        }
        for(int i=0;i<palavra.length();i++)
        {
            testar= palavra.charAt(i);
            if(testar!=' '){//tira os espaços
                palavrateste += palavra.charAt(i);//salva em uma nova variavel
            }
        }
        if(palavrateste.equals(palavraReversa)){//testa se a palavra é palindromo
        return true;
        }
        else{
        return false;
        }
    }

    public static void main(String[] args) 
    {
        String palavra="";
        palavra= MyIO.readLine();
        do
        {
            if(checarPalid(palavra)){
                System.out.print("SIM\n");// printa na tela se é palindrome
            }
            else{
                System.out.print("NAO\n");// printa na tela se nao e palindrome
            }
            palavra= MyIO.readLine();
        }while(!palavra.equals("FIM"));//repete ate achar a palavra FIM
    }
}
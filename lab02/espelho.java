import java.util.Scanner;

class espelho{
    public static void espelha(int x, int y)
    {
        for(int i=x;i<=y;i++)
        {
            MyIO.print(i);//imprime ate o valor desejado
        }
        int a=0;
        int b=0;
        for(int numero=y;numero>=x;numero--)
        {
            a=numero;
            b=numero;
            if(a>9)//verifica se e maior q 9
            {
                if(numero<100){//verifica se e menor q 100
                    MyIO.print(a%10);//imprime o resto da divisao por 10
                    MyIO.print(b/10);//imprime a divisao por 10
                }
                else if(numero<1000)//verifica se e menor q 1000
                {
                    MyIO.print(a%10);//imprime o resto da divisao por 10
                    MyIO.print((b%100)/10); //imprime o resto da divisao por 100 dividido por 10
                    MyIO.print(b/100);// imprime o valor da divisao por 100
                }
            }
            else{
            MyIO.print(numero);//imprime o numero
            }
        }
        MyIO.print("\n");//quebra a linha
    }
    public static void main(String[] args) {//principal
        int x=0,y=0;
        Scanner leitor = new Scanner(System.in);
        do{
			x = leitor.nextInt();
            y = leitor.nextInt();//le os dois inteiros e chama o metodo para espelhar
            espelha(x,y);
        }while(leitor.hasNext());
        leitor.close();
    }
}
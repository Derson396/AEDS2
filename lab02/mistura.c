#include <string.h>
#include <stdio.h>
void mistureba(char word[], char word2[])
{
    char mistura[999]=" ";
    int n = strlen(word) + strlen(word2);
    int x = strlen(word);
    int y = strlen(word2);
    int a=0,b=0,c=0,i=0;
    if(x<y)
    {
        c=y-x;
    }
    if(x>y)         //verifica se ha diferença de tamanho entre as variaveis e a armazena em uma variavel
    {
        c=x-y;
    }
    for (i=0; i < n-c;i ++)
    {
        if(i%2==0)
        {
        mistura[i] = word[a];//quando for par armazena a letra de word
        a++;
        }
        else
        {
            mistura[i]=word2[b];b++;//quando for impar armazena a letra de word2
        }
    }
    while(c!=0)//enquanto a diferença nao for igual a 0 repete
    {
        if(a!=x)//se o valor de a for diferente do tamanho total de word coloca as letras da variavel word na palavra
        {
            mistura[i] = word[a];
        a++;
        }
        if(b!=y)//se o valor de b for diferente do tamanho total de word2 coloca as letras da variavel word2 na palavra
        {
           mistura[i]=word2[b];b++;
        }
        i++;//aumenta o indice de i
        c--;//diminui a diferença
    }
    mistura[n]='\0';
    printf("%s\n", mistura);//imprime a palavra
}
int main()//principal
{
    char word[999];
    char word2[999];
    while (scanf("%s",word)==1){//le as entradas
        scanf("%s",word2);
        mistureba(word, word2);  
    }
    return 0;
}

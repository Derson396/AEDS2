#include <stdio.h>
#include <stdbool.h>
#include <string.h>
bool palindromo(char *word)
{
    bool resultado = true;
    int i = 0;
    int j = strlen(word) - 1; // ultima posiçao

    while (i <= j && resultado)
    {
        if (word[i] == ' ' || word[j] == ' ')//testa se ha espaços vazios
        {
            if (word[i] == ' ')
            {
                i++;
            }
            if (word[j] == ' ')
            {
                j--;
            }
        }
        else
        {
            resultado = (word[i] == word[j]);//se der falso para o while
            i++;
            j--;
        }
    }
    return resultado;
}
bool FIM(char word[]){//testa se a palavra e FIM
	bool teste = false;
	if (word[0] =='F' && word[1] =='I' && word[2] =='M')
	{
		teste = true;
	}
	return teste;
}
void recursivo(char word[])
{
    if(!FIM(word))
    { // testa a primeira palavra
        if (palindromo(word))
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
scanf(" %[^\n]s", word); //lê a proxima palavra
        recursivo(word);
    }
}
int main(int argc, char *argv[])
{
    char word[700];
    scanf(" %[^\n]s", word); //lê a primeira palavra
    recursivo(word);
}
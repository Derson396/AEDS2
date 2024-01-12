/**
 * TP01 - Questao 9
 * @author Wanderson De Souza Pessoa
 * Matrícula: 775097
 */
#include <stdlib.h> // fgets
#include <stdio.h> // entrada e saida
#include <stdbool.h> // bool
#include <string.h> // strlen
bool eVogal(char word[]) //um metodo que verifica se é vogais
	{                          
		int numeroVogal = 0;
		for (int i = 0; i < strlen(word); i++)
		{
			if(word[i] == 'a' || word[i] == 'e'
			   || word[i] == 'i' || word[i] == 'o'
			   || word[i] == 'u'|| word[i] == 'A' || word[i] == 'E'
			   || word[i] == 'I' || word[i] == 'O'|| word[i] == 'U')
			{
				numeroVogal++;
			}

		}
		if (numeroVogal == strlen(word))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
     bool eConsoante(char word[])// um metodo que verifica se é consoantes
	{                                      
		int numeroConso = 0;
		for (int i = 0; i < strlen(word); i++)
		{
			if ((word[i] >= 'a' && word[i] <= 'z')
				|| (word[i] >= 'A' && word[i] <= 'Z'))
			{
			if (!(word[i] == 'a' || word[i] == 'e' ||
				word[i]== 'i' || word[i] == 'o' ||
				word[i] == 'u' || word[i] == 'A' || word[i] == 'E'
			   || word[i] == 'I' || word[i] == 'O'|| word[i] == 'U'))
			{
				numeroConso++;
			}
			}
		}
		if (numeroConso == strlen(word))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
    bool eInteiro (char word[])  // um metodo que verifica se é inteiro
	{                              
		for (int j = 0; j < strlen(word); j++)
        {
		if (!(word[j]== ',' || word[j] == '.'))
			{
			return false;
			}
        }
		for (int i = 0; i < strlen(word); i++)
        {
			if(word[i] >= '0' && word[i] <= '9')
			{
				return true;
			}
		}
		return false;
	}
	bool eReal (char word[])// um metodo que verifica se é real
	{                           
		for (int i = 0; i < strlen(word); i++)
		{
			if ((word[i] >= 'a' && word[i] <= 'z')
				|| (word[i] >= 'A' && word[i] <= 'Z'))
			{
				return false;
			}
		}
		for (int j = 0; j < strlen(word); j++)
		{
			if (word[j] == ',' || word[j] == '.')
			{
				return true;
			}
		}
		return false;
	}
	int size (char* word){ // Ver tamanho da string
	     	int tamanho = 0;
	     	//testar input
	     	if (word != NULL){
	     		while (word[tamanho] != '\0'){
	     			++tamanho;
	     		}
	     	}
	     	return tamanho;
	     }
    bool isFim (char word[]){   // Metodo para verificar se "FIM" foi entrado
	return (strlen(word) == 3 && word[0] == 'F' &&
		word[1] == 'I' && word[2] == 'M');
	}
	int main ()
	{
		char* word = (char*) malloc (sizeof(char)*1000);
		do
		{
		fgets(word, 999, stdin);
		word[size(word)-1] = '\0';

		if(eVogal(word))
		{
			printf("SIM ");
		}
		else
		{
			printf("NAO ");
		}
		if(eConsoante(word))
		{
			printf("SIM ");
		}
		else
		{
			printf("NAO ");
		}
		if(eInteiro(word))
		{
			printf("SIM ");
		}
		else
		{
			printf("NAO ");
		}
		if(eReal(word))
		{
			printf("SIM \n");
		}
		else
		{
			printf("NAO \n");
		}
		}while(!isFim(word));
	}


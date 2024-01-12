/**
 * TP01 - Questao 10
 * @author Wanderson De Souza Pessoa
 * Matrícula: 775097
 */
#include <stdio.h>
double escreverArquivo (int numero)
{
	double x = 0.0;
	FILE* arquivo = fopen("arquivo", "wb"); // abrir arquivo para escrita
			for (int i = 0; i < numero; i++){
				scanf("%lf", &x);
				fwrite(&x, sizeof(double), 1, arquivo);
			}
			fclose(arquivo);
			return x;
}
void lerArquivo (int numero, double x)
{
	FILE* arquivo = fopen("arquivo", "rb"); // abrir arquivo para leitura
	fseek(arquivo, -1 * sizeof(double), SEEK_END);
	for (int i = 1; i < numero; i++){
		fread (&x, sizeof(double), 1, arquivo);
		printf("%g\n", x);
		fseek(arquivo, -2 * sizeof(double), SEEK_CUR);
	}
	fread(&x, sizeof(double), 1, arquivo);
	printf("%g\n", x);
	fclose(arquivo);
}
int main (){ // Metodo principal
	int numero = 0;
	double x = 0.;
	scanf("%d", &numero);
	escreverArquivo(numero);
	lerArquivo (numero, x);
}

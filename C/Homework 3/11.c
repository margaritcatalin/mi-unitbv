#include<stdio.h>
#include<string.h>
#include<conio.h>
void main()
{
	int i, n;
	printf_s("Introduceti cati elevi aveti in clasa:");
	scanf_s("%d", &n);
	double m[20];
	char* numele[20][20], prenumele[20][20], materia[20][20];
	for (i = 1; i <= n; i++)
	{
		printf_s("Introduceti Numele si Prenumele elevului:");
		scanf_s("%s", numele[i],sizeof numele[i]);
		scanf_s("%s", prenumele[i], sizeof prenumele[i]);
		printf_s("Introduceti Materia elevului:");
		scanf_s("%s", materia[i], sizeof materia[i]);
		printf_s("Introduceti nota elevului(cu 2 zecimale):");
		scanf_s("%lf", &m[i]);
	}
	printf_s("__________________________________________\n");
	printf_s("|Numar |Numele si Prenumele|Materia|Nota|\n");
	printf_s("|curent|                   |       |    |\n");
	printf_s("__________________________________________\n");
	for (i = 1; i <= n; i++)
	{
		printf_s("|%d     | %s %s     | %s   | %.2lf  |\n", i, numele[i], prenumele[i], materia[i], m[i]);
		printf_s("__________________________________________\n");
	}
	_getch();
}

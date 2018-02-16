#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<conio.h>
typedef struct student
{ 
	char nume[20], prenume[20]; 
	struct
	{
		unsigned zi, luna, an;
	} data_n;
	float nota1, nota2, medie;
}student;
void main() 
{ 
	student *v; 
	int i, n; 
	printf("Numar de studenti="); 
	scanf_s("%d", &n); 
	v = (student *)malloc(n * sizeof(student));
	for (i = 0; i<n; i++) 
	{ 
		printf("STUDENTUL NUMARUL %d",i);
		printf("\n");
		printf("\nNumele studentului=");
		scanf_s("%s", v[i].nume, sizeof v[i].nume);
		printf("\nPrenumele studentului=");
		scanf_s("%s", v[i].prenume, sizeof v[i].prenume);
		printf("\nData nasterii a studentului");
		printf("\nZiua Nasterii=");
		do
		{
			scanf_s("%u", &v[i].data_n.zi);
		} while (v[i].data_n.zi > 31);
		printf("\nLuna Nasterii=");
		do
		{
			scanf_s("%u", &v[i].data_n.luna);
		} while (v[i].data_n.luna > 12);
		printf("\nAnul Nasterii=");
		scanf_s("%u", &v[i].data_n.an);
		printf("\nPrima nota a studentului=");
		scanf_s("%f", &v[i].nota1);
		printf("\nA doua nota a studentului=");
		scanf_s("%f", &v[i].nota2);
		v[i].medie = (v[i].nota1 + v[i].nota2) / 2;
	} 
	for (i = 0; i < n; i++)
	{
		printf("|%s %s || %u.%u.%u || %f|\n", v[i].nume, v[i].prenume, v[i].data_n.zi, v[i].data_n.luna, v[i].data_n.an, v[i].medie);
	}
	_getch();
}
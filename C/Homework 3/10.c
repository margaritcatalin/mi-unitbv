#include<stdio.h>
#include<string.h>
void main()
{
	int nc,i;
	char nume, prenume;
	float nota;
	printf("-----------------------------------------");
	printf("\n|Nr.c|Nume|Prenume|Nota|");
	printf("\n-----------------------------------------");
	for (i = 1; i <= 4; i++)
	{
		scanf("%d %c %c %f", &nc, &nume, &prenume, &nota);
		printf("\n|%d|%c|%c|%f|", nc, nume, prenume, nota);
	}
}



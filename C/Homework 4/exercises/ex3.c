#include <stdio.h>
#include<string.h>
#include<conio.h>
void main()
{
	char string[1][30];
	int i,j,ok,nr=0,n1=0;
	printf_s("Intruduceti cuvantul pe care vreti sa il cautati,apasati ENTER si apoi introduceti propozitia in care cautati cuvantul!\n ");
	for (i = 0; i < 2; i++)
	{
		scanf_s("%[^\n]s", string[i], sizeof string[i]);
	}
	while (string[0][n1] != 0)//deducerea dimensiunii cuvantului cautat
	{
		n1++;
	}
	printf_s("%d\n", n1);
	i = 0;
	for (i <= sizeof(string[1]))	{		ok = 1;		if (string[1][i] == ' ')			if ((i - 1) == n1)			{				j = 0;				while (j <= (i - 1) && ok)				{					if (string[1][j] != string[0][j])						ok = 0;					j++;				}				if (ok == 1)					nr++;				i++;//trecem la urmatorul caracter deoarece i ramane pe spatiure			}		i++;	}	printf_s("%s\n", string[0]);	printf_s("%s\n", string[1]);	printf_s("Cuvantul %s apare de %d ori in fraza", string[0], nr);	_getch();}
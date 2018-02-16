#include<stdio.h>
#include<string.h>
void main()
{
	unsigned n,i,nr=0;
	char s,c;
	printf_s("Dati sirul s:");
	scanf_s("%s", &s);
	printf_s("Introduceti caracterul cautat:");
	scanf_s("%c", &c);
	n = strlen(s);
	i = 0;
	while (i <= n - 1)
	{
		if (s[i] == c)
			nr++;
		i++;
	}
	getch();
}
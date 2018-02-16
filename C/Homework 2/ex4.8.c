#include <stdio.h>
int myStrLen(char *s)
{
	int nr = 0;
	while (*(s + nr) != 0)
	{
		nr++;
	}
	return nr;
}
int main()
{
	char cstring[50];
	printf_s("introduceti sirul: ");
	scanf_s("%[^\n]s", cstring, sizeof cstring); // [^\n] pentru a citi mai multe cuvinte intr-o variabila string
	printf_s("Lungimea sirului de caractere este: %d \n", myStrLen(cstring));
	getch();
	return 0;
}
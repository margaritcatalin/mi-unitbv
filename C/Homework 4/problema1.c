//1. Se da un numar. Sa se afiseze toate numerele pe care le obtinem excluzand ultima cifra din numar. ex: 7166 716 71 7
#include <stdio.h>
int main()
{
	int nr;
	scanf_s("%d", &nr);
	while (nr)
	{
		printf_s("%d\n", nr);
		nr = nr / 10;
	}
	printf_s("Done!");
}
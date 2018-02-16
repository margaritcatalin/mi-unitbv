#include <stdio.h>

int main()
{
	unsigned i, n;
	int nr[80];
	printf_s("Dati valoarea lui n:");
	scanf_s("%u", &n);
	for (i = 0; i <= n-1; i++)
	{
		printf_s("nr[%u]=", i);
		scanf_s("%d", nr+i);
		printf_s("\n");
	}
	printf_s("----\n");
	for (i = 0; i <= n-1; i++)
		if (*(nr+i) % 2 == 0)
		{
			printf_s("nr[%u]=%d", i, nr[i]);
			printf_s("\n");
		}
	getch();
	return 0;
}

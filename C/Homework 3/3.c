#include <stdio.h>

int main()
{
	unsigned i,n;
	int nr[];
	printf_s("Dati valoarea lui n:");
	scanf_s("%u", n);
	for (i = 0 ; i <= n; i++ )
	{
		printf_s("nr[%u]=", i);
		scanf_s("%d", nr[i]);
		printf_s("\n");
	}
	printf_s("----");
	for (i = 0 ; i <= n; i++)
	{
		printf_s("nr[%u]=%d", i,v[i]);
		printf_s("\n");
	}
	getch();
	return 0;
}

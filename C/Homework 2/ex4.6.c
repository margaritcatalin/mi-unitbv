#include<stdio.h>
int countEven(int*v, int n)
{
	int nr=0,i;
	for (i = 0; i <= n-1; i++)
		if (*(v + i) % 2 == 0)
			nr++;
	return nr;
}
void main()
{
	int n,i, v[20];
	printf_s("Dati valoarea lui n:");
	scanf_s("%u", &n);
	for (i = 0; i <= n - 1; i++)
	{
		printf_s("v[%u]=", i);
		scanf_s("%d", v + i);
		printf_s("\n");
	}
	printf_s("%d\n", countEven(v, n));
	getch();
}
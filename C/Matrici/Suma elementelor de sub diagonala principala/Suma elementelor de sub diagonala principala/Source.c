#include<stdio.h>
void main()
{
	int n, i, j, s = 0, a[100][100];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		for (j = 1; j <= n; j++)
			scanf_s("%d", &a[i][j]);
	for (i = 2; i <= n; i++)
		for (j = 1; j <= i - 1; j++)
			s = s + a[i][j];
	printf("Suma este: %d", s);

}
#include<stdio.h>
void main()
{
	int n, i, j, s[100], a[100][100];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		for (j = 1; j <= n; j++)
			scanf_s("%d", &a[i][j]);
	for (i = 1; i <= n / 2; i++)
	{
		s[i] = 0;
		for (j = i; j <= n + 1 - i; j++)
			s[i] = s[i] + a[i][j] + a[j][i] + a[n + 1 - i][j] + a[j][n + 1 - i];
		s[i] = s[i] - a[i][i] - a[n + 1 - i][i] - a[i][n + 1 - i] - a[n + 1 - i][n + 1 - i];
	}
	if (n % 2 == 1)
		s[n / 2 + 1] = a[n / 2 + 1][n / 2 + 1];
	for (i = 1; i <= n / 2; i++)
		printf("%d ", s[i]);
	if (n % 2 == 1)
		printf("%d \n", s[n / 2 + 1]);
}
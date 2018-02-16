#include<stdio.h>
int max(int *a, int n)
{
	int max = a[1], i;
	for (i = 2; i <= n; i++)
		if (max<a[i]) max = a[i];
	return max;
}
void main()
{
	int a[100], i, j, n, b[100], c[100], k;
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	k = max(a, n);
	for (i = 1; i <= k; i++)
		c[i] = 0;
	for (j = 1; j <= n; j++)
		c[a[j]] = c[a[j]] + 1;
	for (i = 2; i <= k; i++)
		c[i] = c[i] + c[i - 1];
	for (j = n; j >= 1; j--)
	{
		b[c[a[j]]] = a[j];
		c[a[j]] = c[a[j]] - 1;
	}
	for (i = 1; i <= n; i++)
		printf("%d ", b[i]);
}
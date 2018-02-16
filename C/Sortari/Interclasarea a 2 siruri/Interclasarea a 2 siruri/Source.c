#include<stdio.h>
void main()
{
	int n, m, i, j, k, a[100], b[100], c[200];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	printf("m=");
	scanf_s("%d", &m);
	for (i = 1; i <= m; i++)
		scanf_s("%d", &b[i]);
	k = 0;
	i = 1;
	j = 1;
	while (i <= n && j <= m)
	{
		k++;
		if (a[i] <= b[j])
		{
			c[k] = a[i];
			i++;
		}
		else
		{
			c[k] = b[j];
			j++;
		}
	}
	while (i <= n)
	{
		k++;
		c[k] = a[i];
		i++;
	}
	while (j <= m)
	{
		k++;
		c[k] = b[j];
		j++;
	}
	for (i = 1; i <= k; i++)
		printf("%d ", c[i]);
}
#include<stdio.h>
void main()
{
	int n, i, j, nr, a[100], b[100];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	for (i = 1; i <= n; i++)
	{
		nr = 0;
		for (j = 1; j<i; j++)
			if (a[i] >= a[j])
				nr++;
		for (j = i + 1; j <= n; j++)
			if (a[i]>a[j])
				nr++;
		b[nr + 1] = a[i];
	}
	for (i = 1; i <= n; i++)
		printf("%d ", b[i]);
}
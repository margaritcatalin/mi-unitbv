#include<stdio.h>
void main()
{
	int n, i, j, aux, a[100], pmin;
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	for (i = 1; i<n; i++)
	{
		pmin = i;
		for (j = i + 1; j <= n; j++)
			if (a[pmin]>a[j])
				pmin = j;
		aux = a[pmin];
		a[pmin] = a[i];
		a[i] = aux;
	}
	for (i = 1; i <= n; i++)
		printf("%d ", a[i]);
}
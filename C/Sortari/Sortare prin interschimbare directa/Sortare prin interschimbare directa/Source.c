#include<stdio.h>
void main()
{
	int n, i, j, aux, a[100];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	for (i = 1; i<n; i++)
		for (j = i + 1; j <= n; j++)
			if (a[i]>a[j])
			{
				aux = a[i];
				a[i] = a[j];
				a[j] = aux;
			}
	for (i = 1; i <= n; i++)
		printf("%d ", a[i]);
}
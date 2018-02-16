#include<stdio.h>
void main()
{
	int n, i, aux, ok, a[100];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	do
	{
		ok = 1;
		for (i = 1; i<n; i++)
			if (a[i]>a[i + 1])
			{
				aux = a[i];
				a[i] = a[i + 1];
				a[i + 1] = aux;
				ok = 0;
			}
	} while (ok == 0);
	for (i = 1; i <= n; i++)
		printf("%d ", a[i]);
}
#include <stdio.h>
#include <malloc.h>
#include<conio.h>

void main()
{
	int **a, n, i, j, *b,k, aux, m;
	printf("Dati numarul de linii=");
	scanf_s("%d", &n);
	a = (int **)malloc(n * sizeof(int*));
	b = (int *)malloc(n * sizeof(int));
	for (i = 0; i < n; i++)
	{
		printf("Dati dimensiunea liniei [%d]=", i);
		scanf_s("%d", &b[i]);
		a[i] = (int *)malloc(b[i] * sizeof(int));
	}
	for (i = 0; i<n; i++)
		for (j = 0; j < b[i]; j++)
		{
			printf("a[%d][%d]=", i, j);
			scanf_s("%d", &a[i][j]);
		}
	printf("\nMatricea initiala este:\n");
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < b[i]; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}
	for (k = 0; k < n; k++)
		for (m = 0; m < b[k]; m++)
		for (i = 0; i<n; i++)
			for (j = 0; j < b[i]; j++)
				if (a[k][m]<a[i][j])
				{
					aux = a[k][m];
					a[k][m] = a[i][j];
					a[i][j] = aux;
				}
	printf("\nMatricea sortata este:\n");
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < b[i]; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}
	for (j = 0; i<n; j++)
		for (i = 0; i<b[j]; i++)
			free(a[i]);
	free(a);
	free(b);
	_getch();

}

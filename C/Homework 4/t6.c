#include <stdio.h>
#include <malloc.h>
#include<stdbool.h>
#include<conio.h>
void main()
{
	int **a, n, m, i, j, d;
	printf("Dati numarul de linii=");
	scanf_s("%d", &n);
	printf("Dati numarul de coloane=");
	scanf_s("%d", &m);
	a = (int **)malloc(n * sizeof(int*));
	for (i = 0; i < n; i++)
		a[i] = (int *)malloc(m * sizeof(int));
	for (i = 0; i < n; i++)
		for (j = 0; j < m; j++)
		{
			printf("a[%d][%d]=", i, j);
			scanf_s("%d", &a[i][j]);
		}
	printf("\nMatricea initiala este:\n");
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}
	for (i = 0; i < n; i++)
	{
		int ok = 1;
		for (j = 1; j < n; j++)
			if (a[i][j-1] > a[i][j])
				ok = 0;
		if (ok == 1)
		{
			for (j = i; j < n - 1; j++)
				for (d = 0; d < m; d++)
					a[j][d] = a[j + 1][d];
			n--;
			a = (int **)realloc(a, n * sizeof(int*));
		}
	}
	for (j = 0; j < m; j++)
	{
		int ok = 1;
		for (i = 1; i < n; i++)
			if (a[i-1][j] > a[i][j])
				ok = 0;
		if (ok == 1)
		{
			for (i = j; i < m - 1; i++)
				for (d = 0; d < n; d++)
					a[d][i] = a[d][i + 1];
			m--;
			for (d = 0; d < n; d++)//trebuie sa realocam memorie pentru toate liniile
				a[d] = (int *)realloc(a[d], m * sizeof(int));
		}
	}
	printf("\nMatricea rezultat este:\n");
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}
	for (i = 0; i<m; i++) //eliberarea memoriei
		free(a[i]);
	free(a);
	_getch();
}

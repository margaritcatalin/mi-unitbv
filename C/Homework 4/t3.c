#include <stdio.h>
#include <malloc.h>
#include<stdbool.h>
#include<conio.h>
bool nrprim(int x)
{
	int div, ok;
	ok = 1;
	div = 2;
	while (div <= x / 2)
	{
		if (x%div == 0)
			ok = 0;
		div += 1;
	}
	if (ok == 1)
		return true;
	else
		return false;
}
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
	for (i = 0; i<n; i++)
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
		if (nrprim(a[i][0]) == true)
		{
			for (j = i; j < n - 1; j++)
				for (d = 0; d < m; d++)
					a[j][d] = a[j + 1][d];
			n--;
			a = (int **)realloc(a, n * sizeof(int*));
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

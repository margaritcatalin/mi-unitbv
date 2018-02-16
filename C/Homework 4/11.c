#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	int **a;
	int n,m, i, j;
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
	printf("\nMatricea initiala:\n");
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}

	for (i = 0; i<m; i++)
	{
		int nr = a[0][i];
		int pas = 0;
		while (nr)
		{
			m++;
			int g, d;
			for (d = 0; d < n; d++)
				a[d] = (int *)realloc(a[d], m * sizeof(int));
			for (j = m - 1; j > i; j--)
			{
				for(g=0;g<n;g++)
				a[g][j + 1] = a[g][j];
			}
			for (g = 0; g < n; g++)
			a[g][i + 1] = 0;
			nr /= 10;
			pas++;
		}
		i += pas;
	}
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
			printf("%d ", a[i][j]);
		printf("\n");
	}
	for (i = 0; i<m; i++)
		free(a[i]);
	free(a);
	_getch();
}




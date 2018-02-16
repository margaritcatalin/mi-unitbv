#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	FILE *f, *g;
	int n, m, **a, i, j, min, S, nr;
	float ma;
	f = fopen("Datein.txt", "r");
	if (!f)
		printf("Nu exista fisierul!");
	else
	{
		fscanf(f, "%d%d", &n, &m);
		a = (int**)malloc(n * sizeof(int*));
		for (i = 0; i < n; i++)
			a[i] = (int*)malloc(m * sizeof(int));
		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++)
				fscanf(f, "%d", &a[i][j]);
		g = fopen("Dateout.txt", "w");
		for (i = 0; i < n; i++)
		{
			S = 0;
			min = a[i][0];
			nr = 0;
			for (j = 0; j < m; j++)
				if (a[i][j] % 2 == 1)
				{
					S = S + a[i][j];
					nr++;
				}
				else if (a[i][j] < min)
					min = a[i][j];
			if (S != 0)
			{
				ma = (float)S / nr;
				fprintf(g, "%f\n", ma);
			}
			else
				fprintf(g, "%d\n", min);
		}
		for (i = 0; i < n; i++)
			free(a[i]);
		free(a);
		fclose(g);
	}
	fclose(f);
}
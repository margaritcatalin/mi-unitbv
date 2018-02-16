#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	FILE *f,*g;
	int **v, i,j, n,m, lin,col;
	f = fopen("datein.txt", "r");
	if (!f)
	{
		printf_s("Nu exista fisierul!");

	}
	else
	{
		fscanf(f, "%d%d", &n,&m);
		v = (int**)malloc(n * sizeof(int*));
		for(i=0;i<n;i++)
			v[i] = (int*)malloc(m * sizeof(int));
		for (i = 0; i < n; i++)
			for(j=0;j<m;j++)
			fscanf(f, "%d", &v[i][j]);
		do {
			printf_s("\nDati linia pe care doriti sa o stergeti:");
			scanf_s("%d", &lin);
		} while (lin<0 || lin>n);
		do {
		printf_s("\nDati coloana pe care doriti sa o stergeti:");
		scanf_s("%d", &col);
		} while (col<0 || col>m);
		for (i = lin; i < n-1; i++)
			for (j = 0; j < m; j++)
				v[i][j] = v[i + 1][j];
		n--;
		realloc(v, n * sizeof(int*));
		for (i = 0; i < n - 1; i++)
			for (j = col; j < m; j++)
				v[i][j] = v[i][j+1];
		m--;
		for(i=0;i<n;i++)
			realloc(v[i], m * sizeof(int));
		g = fopen("Dateout.txt", "w");
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < m; j++)
				fprintf_s(g,"%d ", v[i][j]);
			fprintf_s(g, "\n");
		}
		fclose(g);
		for (i = 0; i < n; i++)
			free(v[i]);
		free(v);
	}
	fclose(f);
}
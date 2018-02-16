#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	FILE *f;
	int **v, i, j, n,ok;
	f = fopen("datein.txt", "r");
	if (!f)
	{
		printf_s("Nu exista fisierul!");

	}
	else
	{
		fscanf(f, "%d", &n);
		v = (int**)malloc(n * sizeof(int*));
		for (i = 0; i < n; i++)
			v[i] = (int*)malloc(n * sizeof(int));
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				fscanf(f, "%d", &v[i][j]);
		printf("Elevii care se agreeaz reciproc:");
		for (i = 0; i < n; i++)
		{
			for (j = i; j < n; j++)
				if (i != j)
				{
					if (v[i][j] == 1)
					{
						if(v[j][i]==1)
							printf_s("(%d,%d) ", i + 1, j + 1);
					}
				}
		}
		printf("\nElevii care nu agreeaza pe nimeni:");
		for (i = 0; i < n; i++)
		{
			ok = 0;
			for (j = 0; j < n; j++)
				if (i != j)
				{
					if (v[i][j] == 1)
					{
						ok = 1;
					}
				}
				if (ok == 0)
					printf("%d ", i + 1);

		}
		printf("\nElevii care nu sunt agreati pe nimeni:");
		for (i = 0; i < n; i++)
		{
			ok = 0;
			for (j = 0; j < n; j++)
				if (i != j)
				{
					if (v[j][i] == 1)
					{
						ok = 1;
					}
				}
					if (ok == 0)
						printf("%d ", i + 1);

		}
		for (i = 0; i < n; i++)
			free(v[i]);
		free(v);
	}
	fclose(f);
	_getch();
}
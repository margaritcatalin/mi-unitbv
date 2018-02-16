#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
int verificare(int n, int **v)
{
	int i, j;
	for (i = 0; i < n; i++)
		for (j = i + 1; j < n - 1; j++)
			if (v[i][j] != 0)
				return 1;
	return 0;
}
void main()
{
	FILE *f, *g;
	int **v1,**v2,*d1,*d2;
	int n, n2, m1 = 0, m2 = 0, i, j;
	f = fopen("matrice1.txt", "r");
	if (!f)
	{
		printf_s("Nu exista fisierul!");
	}
	else
	{
		fscanf(f, "%d", &n);
		v1 = (int**)malloc(n * sizeof(int*));
		for (i = 0; i < n; i++)
		{
			v1[i] = (int*)malloc(n * sizeof(int));
		}
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				fscanf(f, "%d", &v1[i][j]);
		g = fopen("matrice2.txt","r");
		if (!g)
		{
			printf_s("Nu exista fisierul2!");
		}
		else
		{
			fscanf(g, "%d", &n2);
			v2 = (int**)malloc(n2 * sizeof(int*));
			for (i = 0; i < n2; i++)
			{
				v2[i] = (int*)malloc(n2 * sizeof(int));
			}
			for (i = 0; i < n2; i++)
				for (j = 0; j < n2; j++)
					fscanf(g, "%d", &v2[i][j]);
			if (verificare(n, v1) == 1 && verificare(n2, v2) == 1)
			{
				printf_s("Nu se poate realiza deoarece una dintre matrici nu este subdiagonala!");
			}
			else
			{
				int s;
				m1 = n(n + 1) / 2;
				s = 0;
				d1 = (int*)malloc(m1 * sizeof(int));
				for (i = 0; i < n; i++)
					for (j = 0; j <= i; j++)
					{
						d1[s] = v1[i][j];
						s++;
					}
				//tramformare matrice 2
				m2 = n2(n2 + 1) / 2;
				s = 0;
				d2 = (int*)malloc(m2 * sizeof(int));
				for (i = 0; i < n2; i++)
					for (j = 0; j <= i; j++)
					{
						d1[s] = v1[i][j];
						s++;
					}

			}
		}
	}
	}
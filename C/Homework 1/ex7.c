#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	int n, i, j, *s, **a;
	FILE *f;
	f = fopen("datein.txt", "r");
	if (!f)
	{
		printf_s("Fisierul nu exista!");
	}
	else
	{
		fscanf(f,"%d", &n);
		a = (int**)malloc(n * sizeof(int*));
		for (i = 0; i < n; i++)
			a[i] = (int*)malloc(n * sizeof(int));
		for (i = 0; i < n; i++)
			for (j = 0; j <n; j++)
				fscanf(f,"%d", &a[i][j]);
		int dim;
		dim = n/2+1;
		s = (int*)malloc(dim * sizeof(int));
		for (i = 0; i < n / 2; i++)
		{
			s[i] = 0;
			for (j = i; j < n - i; j++)
				s[i] = s[i] + a[i][j] + a[j][i] + a[n - 1 - i][j] + a[j][n-1 - i];
			s[i] = s[i] - a[i][i] - a[n - 1 - i][i] - a[i][n - 1 - i] - a[n - 1 - i][n - 1 - i];
		}
		if (n % 2 == 1)
			s[n / 2] = a[n / 2][n / 2];
		for (i = 0; i < n / 2; i++)
			printf("%d ", s[i]);
		if (n % 2 == 1)
			printf("%d \n", s[n / 2]);
		for (i = 0; i < n; i++)
			free(a[i]);
		free(a);
		free(s);
	}
	fclose(f);
	_getch();
}
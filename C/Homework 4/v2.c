#include<stdio.h>
#include<malloc.h>
#include<conio.h>
int palindrom(int nr)
{
	int aux, d = 0;
	aux = nr;
	while (nr != 0) 
	{
		d = d * 10 + nr % 10;
		nr = nr / 10;
	}
	if (d == aux)
		return 1;
	else
		return 0;
}
void main()
{
	int **v;
	int n,m, i,j;
	printf_s("Introduceti cate linii are matricea:");
	scanf_s("%d", &n);
	printf_s("Introduceti cate coloane are matricea:");
	scanf_s("%d", &m);
	v = (int*)malloc(n * sizeof(int*));
	for (i = 0; i < n; i++)
	{
		v[i] = (int*)malloc(m * sizeof(int));
		for (j = 0; i < m; j++)
		{
			printf_s("V[%d][%d]=", i,j);
			scanf_s("%d", v[i][j]);
		}
	}
	printf_s("Liniile ce indeplinesc conditia sunt:");
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		if (palindrom(v[i][0])==1 && palindrom(v[i][m-1]) == 1 )
		{
			printf_s(" %d ", i);
			break;
		}
	}

	_getch();
	free(v);
}
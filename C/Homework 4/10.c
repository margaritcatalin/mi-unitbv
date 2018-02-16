//#include <stdio.h>
//#include <malloc.h>
//#include<conio.h>
//void sortlinie(int **a, int d, int n)
//{
//	int i,aux,j;
//	for (i = 0; i<n-1; i++)
//		for (j = i + 1; j <= n-1; j++)
//			if (a[d][i]>a[d][j])
//			{
//				aux = a[d][i];
//				a[d][i] = a[d][j];
//				a[d][j] = aux;
//			}
//}
//void sortcoloana(int **a, int d, int n)
//{
//	int i, aux, j;
//	for (i = 0; i<n - 1; i++)
//		for (j = i + 1; j <= n - 1; j++)
//			if (a[i][d]>a[j][d])
//			{
//				aux = a[i][d];
//				a[i][d] = a[j][d];
//				a[j][d] = aux;
//			}
//}
//
//void main()
//{
//	int **a, n, i, j, *b,min,ok=1;
//	printf("Dati numarul de linii=");
//	scanf_s("%d", &n);
//	a = (int **)malloc(n * sizeof(int*));
//	b = (int *)malloc(n * sizeof(int));
//	for (i = 0; i < n; i++)
//	{
//		printf("Dati dimensiunea liniei [%d]=",i);
//		scanf_s("%d", &b[i]);
//		a[i] = (int *)malloc(b[i] * sizeof(int));
//	}
//	for (i = 0; i<n; i++)
//		for (j = 0; j < b[i]; j++)
//		{
//			printf("a[%d][%d]=", i, j);
//			scanf_s("%d", &a[i][j]);
//		}
//	printf("\nMatricea initiala este:\n");
//	for (i = 0; i < n; i++)
//	{
//		for (j = 0; j < b[i]; j++)
//			printf("%d ", a[i][j]);
//		printf("\n");
//	}
//	while (ok == 1)
//	{
//		for (i = 0; i < n; i++)
//			sortlinie(a, i, b[i]);
//		min = b[0];
//		for (i = 0; i < n; i++)
//			if (b[i] < min)
//				min = b[i];
//		for (i = 0; i < min; i++)
//			sortcoloana(a, i, n);
//		ok = 0;
//		for (i = 0; i < n; i++)
//			for (j = 0; j < b[i] - 1; j++)
//				if (a[i][j] > a[i][j + 1])
//					ok = 1;
//	}
//	printf("\nMatricea finala este:\n");
//	for (i = 0; i < n; i++)
//	{
//		for (j = 0; j < b[i]; j++)
//			printf("%d ", a[i][j]);
//		printf("\n");
//	}
//	for(j = 0; i<n; j++)
//	for (i = 0; i<b[j]; i++) //eliberarea memoriei
//		free(a[i]);
//	free(a);
//	free(b);
//	_getch();
//
//}

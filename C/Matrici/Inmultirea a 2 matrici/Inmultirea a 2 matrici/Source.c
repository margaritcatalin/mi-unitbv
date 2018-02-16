#include<stdio.h>
void main()
{
	int a[100][100], b[100][100], c[100][100], n1, m1, n2, m2, i, j, l;
	printf("Matricea a: ");
	scanf_s("%d %d", &n1, &m1);
	for (i = 0; i<n1; i++)
		for (j = 0; j<m1; j++)
			scanf_s("%d", &a[i][j]);
	printf("Matricea b: ");
	scanf_s("%d %d", &n2, &m2);
	for (i = 0; i<n2; i++)
		for (j = 0; j<m2; j++)
			scanf_s("%d", &b[i][j]);
	if (m1 != n2)
		printf("Nu se pot inmulti\n");
	else
	{
		for (i = 0; i<n1; i++)
			for (j = 0; j<m2; j++)
			{
				c[i][j] = 0;
				for (l = 0; l<m1; l++)
					c[i][j] = c[i][j] + a[i][l] * b[l][j];

			}
		printf("Matricea a*b:\n");
		for (i = 0; i<n1; i++)
		{
			for (j = 0; j<m2; j++)
				printf("%d ", c[i][j]);
			printf("\n");
		}
	}
}
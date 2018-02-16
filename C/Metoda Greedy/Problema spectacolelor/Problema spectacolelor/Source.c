#include<stdio.h>
void sortare(int n, int *s, int*t)
{
	int i, j, aux;
	for (i = 1; i<n; i++)
		for (j = i + 1; j <= n; j++)
			if (t[i]>t[j])
			{
				aux = t[i];
				t[i] = t[j];
				t[j] = aux;
				aux = s[i];
				s[i] = s[j];
				s[j] = aux;

			}
}
void main()
{
	int s[100], t[100], i, nr, n, u;
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d %d", &s[i], &t[i]);
	sortare(n, s, t);
	printf("\n Spectacolele sunt : \n");
	nr = 1;
	printf("%d-%d \n", s[1], t[1]);
	u = t[1];
	for (i = 2; i <= n; i++)
		if (s[i] >= u)
		{
			nr = nr + 1;
			printf("%d-%d \n", s[i], t[i]);
			u = t[i];
		}
	printf("In total sunt %d spectacole  \n", nr);
}
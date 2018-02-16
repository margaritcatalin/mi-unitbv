#include<stdio.h>
int st[100], n, m;
int valid(int k, int c)
{
	if ((k>1) && (c <= st[k - 1]))
		return 0;
	return 1;
}
void afisare()
{
	for (int i = 1; i <= m; i++)
		printf("%d ", st[i]);
	printf("\n");
}
void back(int k)
{
	if (k == m + 1)
		afisare();
	else
		for (int c = 1; c <= n; c++)
			if (valid(k, c) == 1)
			{
				st[k] = c;
				back(k + 1);
			}
}
void main()
{
	printf("n=");
	scanf_s("%d", &n);
	printf("m=");
	scanf_s("%d", &m);
	back(1);
	int i;
	scanf_s("%d", &i);
}

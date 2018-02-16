#include<stdio.h>
int st[100], n;
int valid(int k, int c)
{
	for (int i = 1; i <= k - 1; i++)
		if (st[i] == c)
			return 0;
	return 1;
}
void afisare()
{
	for (int i = 1; i <= n; i++)
		printf("%d ", st[i]);
	printf("\n");
}
void back(int k)
{
	if (k == n + 1)
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
	back(1);
	int i;
	scanf_s("%d", &i);
}

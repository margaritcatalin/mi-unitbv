#include<stdio.h>
int st[100], n, nr = 0;
int valid(int k, int c)
{
	int i;
	for (i = 1; i <= k - 1; i++)
		if ((st[i] == c) || (st[i] - c == k - i) || (c - st[i] == k - i))
			return 0;
	return 1;
}
void afisare()
{
	nr++;
	printf("\nModul de aranjare %d \n\n", nr);
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
			if (st[j] == i)
				printf("D ");
			else
				printf("X ");
		printf("\n");
	}

}
void back(int k)
{
	if (k>n)
		afisare();
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

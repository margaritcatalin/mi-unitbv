#include<stdio.h>
int minim(int *v, int ls, int ld)
{
	int m, a, b;
	if (ls == ld) return v[ls];
	m = (ls + ld) / 2;
	a = minim(v, ls, m);
	b = minim(v, m + 1, ld);
	if (a<b) return a;
	else return b;
}
void main()
{
	int a[100], n, i;
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	printf("Minimul este %d \n", minim(a, 1, n));
	_getch();
}
#include<stdio.h>
int putere(int x, int n)
{
	int p;
	if (n == 0) return 1;
	else if (n % 2 == 0) {
		p = putere(x, n / 2);
		return p*p;
	}
	else return x*putere(x, n - 1);
}
void main()
{
	int nr, p;
	printf("nr=");
	scanf_s("%d", &nr);
	printf("p=");
	scanf_s("%d", &p);
	printf("%d la puterea %d=%d \n", nr, p, putere(nr, p));
}
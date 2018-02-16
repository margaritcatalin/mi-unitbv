#include<stdio.h>
int F(int n)
{
	if (n == 0) return 0;
	if (n == 1) return 1;
	return F(n - 1) + F(n - 2);
}
void main()
{
	int n;
	printf("n=");
	scanf_s("%d", &n);
	printf("Termenul %d din sir este %d \n", n, F(n));
}
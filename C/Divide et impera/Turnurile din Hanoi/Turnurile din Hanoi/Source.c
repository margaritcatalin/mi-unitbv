#include<stdio.h>
void H(unsigned n, unsigned x, unsigned y, unsigned  z)
{
	if (n>0)
	{
		H(n - 1, x, z, y);
		printf("Muta primul disc de pe tija %u pe tija %u \n", x, z);
		H(n - 1, y, x, z);
	}
}
void main()
{
	unsigned n;
	printf("Numarul de discuri de pe prima tija:");
	scanf_s("%u", &n);
	H(n, 1, 2, 3);
}
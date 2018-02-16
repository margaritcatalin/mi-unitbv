#include<stdio.h>
void main()
{
    unsigned i=0,ii=2,n;
	printf_s("Introduceti valoarea lui n:");
	scanf_s("%u", &n);
	while(i<=2*n-1)
    {
    printf_s(" %u  ", i);
    i+=4;
    }
    printf_s("\n");
	while(ii<=2*n-1)
    {
    printf_s("   %u", ii);
    ii+=4;
    }
	getch();
}

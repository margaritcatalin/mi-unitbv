#include<stdio.h>
void main()
{
    int i;
	unsigned n,k,m;
	printf_s("Introduceti valoarea lui n:");
	scanf_s("%u", &n);
	printf_s("\nIntroduceti valoarea lui k:");
	scanf_s("%u", &k);
	printf_s("\n");
	m=n;
	for (i = (int)m-(int)k; i <= (int)m+ (int)k; i++)
	{

		printf_s("%d", i);
		if(i!=n+k)
            printf_s(",");
	}
	getch();
}

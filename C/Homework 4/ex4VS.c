#include<stdio.h>
void main()
{
	unsigned x,n;
    printf_s("Introduceti valoarea lui x:");
    scanf_s("%u",&x);
    printf_s("\n");
    printf_s("Introduceti valoarea lui n:");
    scanf_s("%u",&n);
    x=x>>n;
    printf_s("Rezultatul este: %u", x);
	getch();

}

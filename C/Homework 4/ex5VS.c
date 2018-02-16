#include<stdio.h>
void main()
{
	unsigned x;
    printf_s("Introduceti valoarea lui x:");
    scanf_s("%d",&x);
    printf_s("Relatia returneaza:%d", x & 1 ? 1 : 0);//1 impar,0 par
	getch();
}

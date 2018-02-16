#include<stdio.h>
void main()
{
int *p;
int i;
int k;
i = 42;
printf_s("\n%d", i);
k = i;
p = &i;
*p = 75;//modificam valoarea lui i in 75
printf_s("\n%d |%d|%d |%p", i, k,*p,p);
getch();
}

//Raspuns corect D
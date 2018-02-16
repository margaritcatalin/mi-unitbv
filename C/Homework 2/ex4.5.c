#include<stdio.h>
void main()
{
	char s[10] = "abcde";
	char* cptr;
	int nr = 0,i;
	while (*s++ != 0)//aflarea dimensiuni sirului
	{
		nr++;
	}
	cptr = s+nr;
	for (i = nr; i >= 0; i--)
	{
			printf_s("%c", *cptr--);
	}
	getch();
}
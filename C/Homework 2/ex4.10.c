#include <stdio.h>
void revString(char *a)
{
	int i = 0;
	while (*(a + i) != 0)
	{
		i++;
	}
	while (i >= 0)
	{
		printf("%c", *(a + i));
		i--;
	}
}
int main()
{
	char s[10] = "abcde", *ptr;
	ptr = s;
	revString(ptr);
	printf_s("\n");
	getch();
	return 0;
}
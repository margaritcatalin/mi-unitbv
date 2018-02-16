#include <stdio.h>
int main()
{
	unsigned int n;
	printf_s("Introduceti valoarea lui n: ");
	scanf_s("%u", &n);
	if (n < 60)
		printf_s("F");
	else if ((n >= 60) && (n <= 69))
		printf_s("D");
	else if ((n >= 70) && (n <= 79))
		printf_s("C");
	else if ((n >= 80) && (n <= 89))
		printf_s("B");
	else if ((n >= 90) && (n < 100))
		printf_s("A");
	else if (n == 100)
		printf_s("Ai ajuns la scorul maxim!");
	else if (n>100)
		printf_s("Numarul de puncte este prea mare!");
	printf_s("\n");
	return 0;
}
#include <stdio.h>
int main()
{
	int NrInt, *ptrInt;
	double NrDouble, *ptrDouble;
	printf_s("NrInt= ");
	scanf_s("%d", &NrInt);
	printf_s("NrDouble= ");
	scanf_s("%lf", &NrDouble);
	ptrInt = &NrInt;
	ptrDouble = &NrDouble;
	printf_s("Adresa variabilei de tip int: %p \n", ptrInt);
	printf_s("Adresa variabilei de tip double: %p \n", ptrDouble);
	printf_s("Adresa pointerului incrementata cu 1 este: %p \n", ptrInt + 1);
	printf_s("Adresa pointerului incrementata cu 3 este: %p \n", ptrInt + 3);
	printf_s("Adresa pointerului de tip double incrementata cu 1 este: %p \n", ptrDouble + 1);
	printf_s("Adresa pointerului de tip double incrementata cu 3 este: %p \n", ptrDouble + 3);
	printf_s("Spatiu de memorie ocupat de variabila de tip int este : %d octeti \n", sizeof (NrInt));
	printf_s("Spatiu de memorie ocupat de variabila de tip double este: %d octeti \n", sizeof (NrDouble));
	getch();
	return 0;
}
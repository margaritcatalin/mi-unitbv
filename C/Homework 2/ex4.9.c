#include<stdio.h>
int contains(char*s, char c)
{
	int dimensiune = 0,nr=0;
	while (*(s + dimensiune) != 0)//deducerea dimensiuni sirului
	{
		dimensiune++;
	}
	for(int i=0;i<dimensiune;i++)//parcurgerea sirului
	if (*(s + i) == c)//cautarea caracterului
	{
		nr++;
	}
	if (nr == 2)//verificam daca caracterul apare de exact 2 ori
		return 1;
	else
		return 0;
}
void main()
{
	char a[50] = { "Catalin" }, c;
	printf_s("Ce caracter doriti sa cautati?\n");
	scanf_s("%c", &c);
	printf_s("\n");
	if (contains(a, c) == 1)
		printf_s("\nTrue");
	else
		printf_s("\nFalse");
	getch();
}
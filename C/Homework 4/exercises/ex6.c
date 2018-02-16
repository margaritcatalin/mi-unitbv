#include<stdio.h>
void send(int *to,int * from, int count)
{
	int n = (count + 7) / 8;
	switch (count % 8)//daca dimensiunea este divizibila cu 8 intra pe cazul 0
	{
	case 0: do {
		*to++ = *from++;//muta valoarea aflata la adresa indicata de pointerul from catre adresa indicata de pointerul to apoi trece la urmatorul element
	case 7:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	case 6:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	case 5:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	case 4:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	case 3:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	case 2:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	case 1:*to++ = *from++;//muta urmatoarea valoare apoi trece din nou la urmatoarea valoare
	} while (--n > 0);
	}
}
void main()
{
	int s1[20], s2[20],n,i;
	printf_s("Introduceti cate valori aveti in vector:");
	scanf_s("%d", &n);
	printf_s("\n");
	for (i = 0; i < n; i++)
	{

		printf_s("from[%d]=", i);
		scanf_s("%d", &s1[i]);
		printf_s("\n");
	}
	send(&s2, &s1, n);
	for (i = 0; i < n; i++)
	{
		printf_s("from[%d]=%d \n", i, s1[i]);
	}
	for (i = 0; i < n; i++)
	{
		printf_s("to[%d]=%d \n", i, s2[i]);
	}
	getch();
}
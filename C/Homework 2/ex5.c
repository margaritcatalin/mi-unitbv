#include<stdio.h>
void main()
{
	int  count = 10, *temp, sum = 0;
	temp = &count;//pointerul de tip intreg ia adresa lui count
	*temp = 20;//valoarea aflata pe adresa indicata de pointer(adresa lui count) se schimba in 20
	temp = &sum;//pointerul ia adresa variabilei sum
	*temp = count;//valoarea de pe adresa indicata de pointer(adresa lui sum) se schimba in 20(noua valoare a lui count)
	printf("count = %d, *temp = %d, sum = %d\n", count, *temp, sum);//afiseaza 20|20|20
	getch();
}
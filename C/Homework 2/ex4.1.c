#include<stdio.h>
void main()
{
	char c = 'T', d = 'S';
	char *p1 = &c;
	char *p2 = &d;
	char *p3;
	p3 = &d;
	printf_s("*p3 = %c", *p3);   // afiseaza valoarea aflata la adresa indicata de pointerul p3(adica adresa lui d)Afiseaza S
	p3 = p1;//pointerul p3 ia adresa pointerului p1(adresa lui c)
	printf_s("\n*p3 = %c | p3=%p", *p3,p3);   // afiseaza valoarea aflata la adresa indicata de pointerul p3(adica adresa lui c)Afiseaza T apoi afiseaza adresa indicata de pointerul p3
	*p1 = *p2;//valoarea aflata la adresa pointerului p1(pe adresa lui c) se modifica in valoarea aflata pe adresa indicata de pointerul p2(pe adresa lui d). Deci in stringul c va fi tot S 
	printf_s("\n*p1 = %c | p1=%p", *p1, p1);   // afiseaza valoarea aflata la adresa indicata de pointerul p1(adica adresa lui c)Afiseaza S apoi afiseaza adresa indicata de pointerul p1
	getch();
}
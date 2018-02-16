#include<stdio.h>
int main()
{
	char blocks[3] = { 'A','B','C' };
	char *ptr = &blocks[0];//ia adresa primului element, ar fi mai elegant sa se scrie simplu blocks in loc de &blocks[0]
	char temp;

	temp = blocks[0];//temp este egal cu ce se afla pe prima pozitie din vectorul de stringuri(A)
	temp = *(blocks + 2);//temp este egal cu ce se afla pe a 3 a potie din vectorul de stringuri(C)
	temp = *(ptr + 1);////temp este egal cu ce se afla pe a 2 a potie din vectorul de stringuri(B)
	temp = *ptr;//temp este egal cu valoare ce se afla pe adresa indicata de pointerul ptr(adresa primului element din vector)(A)
	ptr = blocks + 1;//pointerul ptr ia adresa celui de-al doilea element din vector
	temp = *ptr;////temp este egal cu valoare ce se afla pe adresa indicata de pointerul ptr(adresa celui de-al doilea element din vector)(B)
	temp = *(ptr + 1);//temp este egal cu valoarea ce se afla pe adresa pointerului incrementat(adresa celui de-al treilea element din vector)(C)
	ptr = blocks;//pointerul ptr ia adresa primului element din vector
	temp = *++ptr;//temp este egal cu valoarea aflata pe adresa pointerului incrementat(adresa lui ptr+1)(B)
	//pointerul este acum pe adresa celui de-al doilea element din vector
	temp = ++*ptr;//temp este egal cu valoarea aflata pe adresa pointerului incrementat(adresa lui ptr+1)(C)
	//pointerul este tot pe adresa celui de-al doilea element din vector
	temp = *ptr++;//temp este egal cu valoarea ce se afla pe adresa pointerului incrementat(adresa lui ptr+1)(C)
	//pointerul este acum pe adresa celui de-al treilea element din vector
	temp = *ptr;//temp este egal cu valoare ce se afla pe adresa indicata de pointerul ptr(adresa dupa incrementari)(C)
	return 0;
}
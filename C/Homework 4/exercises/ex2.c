#include <stdio.h>
#include <string.h>

#define MAX_BUF 256//o macrocomanda cu numele MAX_BUF care este definit ca si dimensiune 256

char arr2[5][20] = { "Mickey Mouse",//(vector de stringuri)o matrice de tip char cu 5 linii si 20 de coloane(reprezinta dimensiunea maxima de caractere ce se pot introduce pe o linie)

"Donald Duck",

"Minnie Mouse",

"Goofy",

"Ted Jensen" };

void bubble(void *p, int width, int N);// o functie pentru a fi apelata trebuie declarata inainte de apelul functiei
int compare(void *m, void *n);

int main(void)
{
	int i;
	putchar('\n');//scrie un caracter la output(Aici trece la randul urmator). Se poate inlocui cu printf_s("\n");

	for (i = 0; i < 5; i++)//parcurgerea  vectorului de stringuri(matricii de tip caracter)
	{
		printf("%s\n", arr2[i]);//afiseaza caracterele ce se afla pe linia i si apoi trece la randul urmator
	}
	bubble(arr2, 20, 5);//apelul functiei bubble cu adresa primei linii din vectorul de stringuri ,diensiunea maxima a fiecarei linii si nr de linii
	putchar('\n\n');//scrie un caracter la output(Aici trece de 2 ori la randul urmator). Se poate inlocui cu printf_s("\n");

	for (i = 0; i < 5; i++)//afisarea vectorului de stringuri dupa sortare
	{
		printf("%s\n", arr2[i]);//afiseaza caracterele ce se afla pe linia i si apoi trece la randul urmator
	}
	getch();
	return 0;
}

void bubble(void *p, int width, int N)
{
	int i, j, k;
	unsigned char buf[MAX_BUF];
	unsigned char *bp = p;//un pointer de tip unsigned char ce este initializat cu adresa variabilei pointerului p(primului element din vectorul de stringuri)

	for (i = N - 1; i >= 0; i--)//parcurgerea vectorului de la ultimul element la primul
	{
		for (j = 1; j <= i; j++)//parcurgerea vectorului de pa primul element pana la i
		{
			k = compare((void *)(bp + width*(j - 1)), (void *)(bp + j*width));//ia valoarea returnata de functie.
			//Se face conversia in void * deoarece variabilei de tip void* i se poate atribui orice alt tip de pointer fara conversie de tip explicitata.
			if (k > 0)
			{
				memcpy(buf, bp + width*(j - 1), width);//copiaza sirul. (destinatie, locatia de unde se copiaza, dimensiunea sirului) si apoi returneaza destinatia
				memcpy(bp + width*(j - 1), bp + j*width, width);
				memcpy(bp + j*width, buf, width);
			}
		}
	}
}

int compare(void *m, void *n)// o functie de tip int cu parametri formali pointeri catre niste variabile de tip int.
							//Este la fel ca o functie cu parametri transmisi prin referinta.
{
	char *m1 = m;//un pointer de tip char ce ia adresa paramentrului m
	char *n1 = n;//un pointer de tip char ce ia adresa paramentrului n
	return (strcmp(m1, n1));//returneaza o valoare mai mica decat 0 daca sirul m1 este mai mic decat sirul n1 ,0 daca sirul m1 este egal cu sirul n1,si o valoarea mai mare decat 0 daca sirul m1 este mai mare decat sirul n1
}

#include <stdio.h>

int arr[10] = { 3,6,1,2,3,8,4,1,7,2 };//initializarea vectorului de dimensiune 10

void bubble(int *p, int N);// o functie pentru a fi apelata trebuie declarata inainte de apelul functiei
int compare(int *m, int *n);

int main(void)
{
	int i;
	putchar('\n');//scrie un caracter la output(Aici trece la randul urmator). Se poate inlocui cu printf_s("\n");

	for (i = 0; i < 10; i++)//parcurgerea vectorului pentru afisare
	{
		printf_s("%d ", arr[i]);
	}
	bubble(arr, 10);//sortarea vectorului arr( apelul este cu adresa primului element si dimensiunea vectorului
	putchar('\n');//scrie un caracter la output(Aici trece la randul urmator). Se poate inlocui cu printf_s("\n");

	for (i = 0; i < 10; i++)//parcurgerea vectorului pentru afisarea sa dupa sortare
	{
		printf_s("%d ", arr[i]);
	}
	return 0;
}

void bubble(int *p, int N)//o functie cu parametri formali de tip int (*p care este un pointer catre o variabila de 
						//tip int, si N care este dimensiunea vectorului)Este la fel ca o functie cu parametri transmisi prin referinta.
{
	int i, j, t;
	for (i = N - 1; i >= 0; i--)//parcurgerea vectorului de la ultimul element la primul
	{
		for (j = 1; j <= i; j++)//parcurgerea vectorului de pa primul element pana la i
		{
			if (compare(&p[j - 1], &p[j]))//Deoarece parametri formali ai functiei compare sunt pointeri de tip int , 
										  //apelul se realizeaza cu adresa  elementelor din vector.
			{                            
				t = p[j - 1];//interschimbare ce se realizeaza prin introducerea unei variabile auxiliare
				p[j - 1] = p[j];
				p[j] = t;
			}
		}
	}
}

int compare(int *m, int *n)// o functie de tip int cu parametri formali pointeri catre niste variabile de tip int.
							//Este la fel ca o functie cu parametri transmisi prin referinta.
{
	return (*m > *n);//verifica care dintre valori este mai mare si returneaza 1 daca valoarea aflata la adresa 
					//indicata de pointerul m este mai mare decat cea aflata la adresa indicata de pointerul n si 0 in caz contrar.
}                    

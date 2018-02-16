#include < stdio.h>
#include < conio.h>
#include < string.h>

void main()
{
	char s1[20], s2[20];
	int aparitii = 0;
	printf(" Introduceti propozitia!\n");
	scanf_s("%[^\n]s", s1, sizeof s1);
	printf("Introduceti cuvantul!\n");
	scanf_s("%s", s2, sizeof s2);

	char *ps1 = s1;
	char *ps2 = s2;
	int nr = 0, ok = 0;
	int m = 0;
	while (*ps2++ != 0)//aflarea dimensiuni cuvantului
	{
		m++;
	}
	while (1)
	{
		while (1)
		{

			char caracter = *ps1;
			if (caracter == ' ')//daca s-a gasit caracterul spatiu iesim loop
				break;
			if (caracter == NULL)//daca s-a ajuns la sfarsitul sirului de caractere iesim din loop
			{
				ok = 1;
				break;
			}
			if (*ps1 == *ps2)
			{

				*ps1++;
				*ps2++;
				nr++;//numaram caracterele asemenea

			}
			else
			{
				nr--;
				*ps1++;
			}
		}

		if (ok != 1)
		{
			if (*ps1 == ' ')
				ps1++;
			if (nr == m)//daca nr de caractere gasite asemenea este acelasi cu dimensiunea cuvantuluii
			{
				aparitii++;
			}
			ps2 = s2;
			nr = 0;
		}
		else
		{
			if (nr == m)
			{
				aparitii++;
			}
			break;

		}
	}
	if (aparitii != 0)
	{
		printf(" Cuvantul %s apare de %d ori in propozitia:%s",s2, aparitii,s1);
	}
	else
	{
		printf("Cuvantul nu apare in propozitie.");
	}
	_getch();
}
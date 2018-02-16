#include <stdio.h>

int main()
{
	int ages[] = { 23, 43, 12, 89, 2 };
	char *names[] = { 
		"Alan", "Frank",
		"Mary", "John", "Lisa"
	};

	int count = sizeof(ages) / sizeof(int);//seziof(ages)=20 si sizeof(int)=4(4 octeti ocupati in memoria calculatorului). Se impart pentru a da dimensiunea exacta a vectorului
	int i = 0;

	for (i = 0; i < count; i++) {
		printf("%s has %d years alive.\n",
			names[i], ages[i]);
	}

	printf("---\n");

	int *cur_age = ages;
	char **cur_name = names;//un pointer catre un alt pointer

	for (i = 0; i < count; i++) {
		printf("%s is %d years old.\n",
			*(cur_name + i), *(cur_age + i));//afisarea elementelor din vector de pe pozitia i
	}

	printf("---\n");

	for (i = 0; i < count; i++) {
		printf("%s is %d years old again.\n",
			cur_name[i], cur_age[i]);// 
	}

	printf("---\n");

	for (cur_name = names, cur_age = ages;//pointerul(cur name) catre pointerul name ia adre primului element din vectorul de stringuri(la fel si cur_ages)
		(cur_age - ages) < count;//se scade pentru a 
		cur_name++, cur_age++)
	{
		printf("%s lived %d years so far.\n",
			*cur_name, *cur_age);// afiseaza valoarea de la adresa pointerului
	}
	getch();
	return 0;

}

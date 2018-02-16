#include <stdio.h>

int main()
{
	int ages[] = { 23, 43, 12, 89, 2 };
	char *names[] = {
		"Alan", "Frank",
		"Mary", "John", "Lisa"
	};

	int count = sizeof(ages) / sizeof(int);//sizeof(ages)=20 iar pentru a fi dimensiunea 5 se imparte la sizeof(int)(dimensiunea de memorie a tipurilor int)=4
	int i = 0;

	for (i = 0; i < count; i++) {
		printf_s("%s has %d years alive.\n",
			names[i], ages[i]);
	}

	printf_s("---\n");

	int *cur_age = ages;
	char **cur_name = names;

	for (i = 0; i < count; i++) {
		printf_s("%s is %d years old.\n",
			*(cur_name + i), *(cur_age + i));
	}

	printf("---\n");

	for (i = 0; i < count; i++) {
		printf_s("%s is %d years old again.\n",
			cur_name[i], cur_age[i]);
	}

	printf_s("---\n");

	for (cur_name = names, cur_age = ages;
		(cur_age - ages) < count;
		cur_name++, cur_age++)
	{
		printf_s("%s lived %d years so far.\n",
			*cur_name, *cur_age);
	}
	printf_s("---\n");
		for (cur_name = names;sizeof(names) < count; cur_name++)
			for (cur_age = ages;(cur_age - ages) < count;cur_age++)
			{
				printf_s("%s lived %d years so far.\n",
					*cur_name, *cur_age);
			}
	getch();
	return 0;
}

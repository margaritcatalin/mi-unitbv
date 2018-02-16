
/* Program 2.1 from PTRTUT10.HTM 6/13/97 */
#include <stdio.h>
int my_array[] = { 1,23,17,4,-5,100 };
int *ptr;
int main(void)
{
	int i;
	ptr = my_array; /* point our pointer to the first
						element of the array */
	printf_s("\n\n");
	for (i = 0; i < 6; i++)
	{
		printf_s("my_array[%d] = %d ", i, my_array[i]); /*<-- A */
		printf_s("\n);
		printf_s("ptr + %d = %d\n", i, *(ptr + i)); /*<-- B */
	}
	getch();
	return 0;
}
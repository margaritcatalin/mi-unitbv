#include<iostream>
#include <stdlib.h>
#include <time.h>
using namespace std;
void main()
{
	int i1, i2;
	int x = rand();
	cout << "Introduceti primul capat:";
	cin >> i1;
	cout << "Introduceti al doilea capat:";
	cin >> i2;
	if (i1 < i2)
	{
		if (x >= i1 && x <= i2)
			cout << x << "apartine intervalului [" << i1 << '[' << i2 << ']';
	}
	else
	{
		if (x <= i1 && x >= i2)
			cout << x << "apartine intervalului [" << i2 << '[' << i1 << ']';
	}
	getch();
}
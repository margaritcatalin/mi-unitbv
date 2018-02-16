#include <iostream>
#include <string>
#include <fstream>
using namespace std;
int main()
{
	char s[100], aux[100], *c;
	ifstream f("Ex4.txt");
	f.getline(s, 100);
	f.close();
	cout << s << endl;
	char b;
	for (int i = 0, j = (strlen(s) - 1); i < j; i++, j--)
	{
		b = s[i];
		s[i] = s[j];
		s[j] = b;
	}
	cout << s << endl;
	c = strstr(s, "SA");
	while (c)
	{
		strcpy(aux, "aaa");
		strcat(aux, c + 2);
		strcpy(c, aux);
		c = strstr(c + 2, "SA");
	}
	cout << s << endl;
}
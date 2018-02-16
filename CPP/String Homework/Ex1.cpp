#include<iostream>
#include<string>
using namespace std;
int main()
{
	char s[60], c;
	int j;
	cout << "Introduceti sirul = "; 
	cin.getline(s, 60);
	cout << "Introduceti caracterul = "; 
	c = getchar();
	j = 0;
	for (int i = 0; i <= strlen(s)-1; i++)
	{
		if (s[i] == c)
			j++;
	}
	if(j)
	cout << "Caracterul " << c <<" apare in sir de "<< j << " ori " << endl;
	else cout << "Caracterul " << c << " nu apare in sir " << endl;
	return 0;
}

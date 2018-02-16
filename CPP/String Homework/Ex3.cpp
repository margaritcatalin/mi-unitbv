#include <iostream>
#include <string>
#include <fstream>
using namespace std;
int main()
{
	char s[256],cuv[40];
	ifstream f("Ex3alf.txt");
	f.getline(s, 256);
	f.close();
	cout << "Introduceti cuvantul = "; 
	cin.getline(cuv, 40);
	int nr = 0;
	for (int i = 0; i < strlen(cuv); i++)
		for (int j = 0;j < strlen(s); j++)
		if(s[j]==cuv[i])
			nr++;
	if(nr==strlen(cuv))
	cout << "Cuvantul apartine alfabetului V." << endl;
	else
		cout << "Cuvantul este peste alfabetul V." << endl;
}
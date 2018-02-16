#include<iostream>
#include <string>
using namespace std;
int dimensiune(char sir[])
{
	return strlen(sir);
}
int main()
{
	char s[256];
	cout << "Introduceti sirul = "; 
	cin.getline(s, 256);
	cout<<"Sirul dat are dimensiunea "<< dimensiune(s);
}
#include<iostream>
#include<string>
using namespace std;
void main()
{	
	char s[35];
	cout << "Introduceti sirul = ";
	cin.getline(s, 35);
	for (int i = 0; i<strlen(s); i++) {
		for (int j = 0; j <= i; j++)
			cout << s[j];
		cout << endl;
	}
}

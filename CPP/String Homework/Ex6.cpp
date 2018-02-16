#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#define _CRT_SECURE_NO_WARNINGS
using namespace std;
int main()
{
	char s[256];
	cin.getline(s, 256);
	vector<string> cuvinte;
	char *a = strtok(s, " ,.?!");
	while (a != NULL) {
		cuvinte.push_back(a);
		a = strtok(NULL, " ,.?!");
	}
	cout << "Lista de cuvinte inainte de sortarea crescatoare:" << endl;
	for (vector<string>::iterator it = cuvinte.begin(); it != cuvinte.end(); ++it)
		cout << ' ' << *it;
	cout << endl;
	cout << "Lista de cuvinte dupa sortarea crescatoare:"<<endl;
	sort(cuvinte.begin(), cuvinte.end());
	for (vector<string>::iterator it = cuvinte.begin(); it != cuvinte.end(); ++it)
		cout << ' ' << *it;
	cout << endl;
	return 0;
}
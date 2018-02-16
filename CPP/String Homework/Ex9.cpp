#include<iostream>
#include<string>
using namespace std;
void main()
{	
	char s1[50], s2[50];
	cout << "Introduceti primul cuvant = ";
	cin.getline(s1, 50);
	cout << "Introduceti al doilea cuvant = ";
	cin.getline(s2, 50);
	int i = strlen(s1) - 1,ok=0;
	while (i > strlen(s1) - 3) {
		for (int j = strlen(s2) - 1; j > strlen(s2) - 3; j--)
			if (s1[i] != s2[j])
			{
				ok = 1;
				break;
			}
			else i--;
			break;
	}
	if (ok)
		cout << "Cuvintele nu rimeaza" << endl;
	else
		cout << "Civintele rimeaza" << endl;
}

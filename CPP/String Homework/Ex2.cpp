#include<iostream>
#include<string>
using namespace std;
int main()
{
	char s[40];
	int j = 0, k = 0, ok = 0, g = 0;
	cout << "Introduceti sirul = ";
	cin.getline(s, 40);
	for (int i = 0; i < strlen(s); i++)
	{
		if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= 'A' && s[i] <= 'Z')
		{
			ok++;
			break;
		}
		if (s[i] == '.')
			j++;
		if (s[i] == '-')
			g++;
	}
	if(ok)
		cout << "Sirul nu este un numar. " << endl;
	else
	{	
		for (int i = 0; i < strlen(s); i++)
		{
			if (s[i] == '.')
				k++;
		}
		if (j == 0)
			cout << "Sirul este numar natural. " << endl;
		else if (k == 0)
			cout << "Sirul este un numar intreg." << endl;
		else if (j==1 && g==1)
			cout << "Sirul este un numar real. " << endl;
		else if (j > 1 || g > 1)
			cout << "Sirul nu este un numar. " << endl;
	}
	return 0;
}

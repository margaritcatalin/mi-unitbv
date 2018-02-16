#include <iostream>
#include <string>
#include <fstream>
using namespace std;
int main()
{
	char s[256];
	ifstream f("Ex5.txt");
	f.getline(s, 256);
	f.close();
	int nr = 0;
	char *a = strtok(s, " ,.?!");
	while (a != NULL) {
		nr++;
		cout << a << endl;
		a = strtok(NULL, " ,.?!");
	}
	cout << "In sirul de caractere sunt " << nr << " cuvinte." << endl;
}
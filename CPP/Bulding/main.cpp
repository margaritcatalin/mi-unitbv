#include"cladire.h"
void main()
{
	cladire *a;
	int n;
	cout << "n=";
	cin >> n;
	a = new cladire[n];
	for (int i = 0; i<n; i++)
		cin >> a[i];
	for (int i = 0; i<n; i++)
		cout << a[i];
	cout << endl << "Cladirea cu pretul maxim este:" << a[pmax(a, n)];
	cout << endl << "Cladirea cu apartamentele cele mai scumpe este:" << a[cladirescumpa(a, n)];
	delete[] a;
}
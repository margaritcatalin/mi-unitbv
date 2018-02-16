#include"cerc.h"
void main()
{
	Cerc *a;
	int n;
	cout << "n=";
	cin >> n;
	a = new Cerc[n];
	for(int i=0;i<n;i++)
		cin >> a[i];
	for (int i = 0; i<n; i++)
		cout << a[i];
	cout << "Ariile:";
	for (int i = 0; i<n; i++)
		cout<<endl << !a[i];
	sort(a + 0, a + n);
	for (int i = 0; i<n; i++)
		cout << a[i];
	cout << endl<<"Cercul cu raza maxima este:" << a[rmax(a, n)];
	for (int i = 0; i < n; i++)
	{
		if (numarprim(a[i]) == true)
		{
			actualizare(a[i]);
			cout << endl << "Cercul care s-a actualizat:" << a[i];
		}
	}

	delete[] a;
}
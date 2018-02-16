#include<iostream>
using namespace std;
struct cerc
{
	float raza;
	int cordx, cordy;
	double operator !() {
		return raza*raza*3.14;
	}
};
istream& operator >> (istream& flux, cerc &c)
{
	cout << endl << "Care este raza cercului? ";
	flux >> c.raza;
	cout << endl << "D ati coordonata x: ";
	flux >> c.cordx;
	cout << endl << "Dati coordonata y: ";
	flux >> c.cordy;
	return flux;
}
ostream& operator <<(ostream& flux, cerc c)
{
	flux << endl << "cu raza "<<c.raza<<" coordonata x:"<<c.cordx<<"coordonata y:"<<c.cordy;
	return flux;
}
void main()
{
//	cerc *v;
	cerc n;
	cin >> n;
	//v = new cerc[n];
	//for (int i = 0; i < n; i++)
		//cin >> v[i];
	//for (int i = 0; i < n; i++)
	//{
		cout << endl << "Aria cercului" << n << "este :"<<!n;
	//}
	//delete[] v;
}
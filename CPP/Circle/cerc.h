#pragma once
#include<iostream>
#include<algorithm>
using namespace std;
class Cerc
{
private:int raza, cordx, cordy;
public: double operator !();
		friend istream& operator >>(istream& flux, Cerc &p);
		friend ostream& operator <<(ostream& flux, Cerc p);
		bool operator<(Cerc& c);
		friend int rmax(Cerc c[], int n);
		friend bool numarprim(Cerc c);
		friend void actualizare(Cerc &c);
};
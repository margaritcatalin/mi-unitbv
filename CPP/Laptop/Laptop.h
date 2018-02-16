#pragma once
#include <iostream>

using namespace std;

class Laptop {
private:
	float pret;
	char* marca;
public:
	Laptop();
	~Laptop();
	friend istream& operator >> (istream &flux, Laptop &l);
	friend ostream& operator << (ostream &flux, Laptop l);

};
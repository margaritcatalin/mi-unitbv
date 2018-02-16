#pragma once
#include <iostream>

using namespace std;

class Peek {
private:
	char name[31]="";
	int h;
public:
	Peek();
	~Peek();
	friend istream& operator >> (istream &flux, Peek &p);
	friend ostream& operator << (ostream &flux, Peek p);
	bool operator<(Peek p);
	char* getName();
	int getH();
};
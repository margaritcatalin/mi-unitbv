#pragma once
#include <iostream>
#include "Peek.h"

using namespace std;

class Mountain {
private:
	char name[31]="";
	int nrPeeks;
	
public:
	Mountain();
	~Mountain();
	Peek *P;
	friend istream& operator >> (istream &flux, Mountain &m);
	friend ostream& operator << (ostream &flux, Mountain m);
	char* getName();
	int get_nrPeeks();
	Peek get_Max_H_Peek();
};
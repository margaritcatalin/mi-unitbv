#pragma once
#include<iostream>
#include<algorithm>
#include<string>
using namespace std;
class cladire
{
private:float pret;
		int nrap,nretaje;
		char locatie;
public: friend istream& operator >> (istream& flux, cladire &p);
		friend ostream& operator <<(ostream& flux, cladire p);
		friend int pmax(cladire *c, int n);
		friend int cladirescumpa(cladire *c, int n); 
		//friend char  locatie(cladire *c,int n);
};
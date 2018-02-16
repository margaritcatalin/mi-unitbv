#include<iostream>
using namespace std;

class Nod
{
public:
	int info;
	char color;
	Nod *st, *dr, *p;
	Nod(const Nod & ceva);
	Nod();
	~Nod();

};
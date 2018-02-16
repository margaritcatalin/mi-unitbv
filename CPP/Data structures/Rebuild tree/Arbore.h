#include<iostream>
#include"Nod.h"
using namespace std;
class Arbore {
private:
	Nod *rad;
public:
	Arbore();
	~Arbore();
	Nod* getRad();
	void setRad(Nod* a);
};
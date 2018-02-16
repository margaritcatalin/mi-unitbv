#include<iostream>
#include"Nod.h"
using namespace std;

class ARN
{
private:
	Nod    *rad;
	Nod    *Nil;

public:
	ARN();
	~ARN();
	Nod* succesor(Nod* x);
	Nod* predecesor(Nod* x);
	Nod* min(Nod* x);
	Nod* max(Nod* x);
	Nod* cautare(int k);
	int RotatieStanga(Nod *x);
	int RotatieDreapta(Nod *x);
	int insert(Nod *z);
	int fixup(Nod *z);
	int transplant(Nod *u, Nod *v);
	int sterge(Nod *z);
	int delete_fixup(Nod *x);
	void SRD(Nod *n);
	void SDR(Nod *n);
	void RSD(Nod *n);
	void postOrderDelete(Nod *n);
	Nod* getRad();
};
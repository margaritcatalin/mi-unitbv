#include <iostream>
using namespace std;
class Nod {
private:
	int data;
	Nod *stanga, *dreapta;
public:
	Nod();
	~Nod();
	Nod operator =(Nod *n);
	Nod* getStanga();
	Nod* getDreapta();
	int getData();
	void setStanga(Nod* a);
	void setDreapta(Nod* a);
	void setData(int a);
};
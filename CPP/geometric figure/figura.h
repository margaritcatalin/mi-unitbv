#include<iostream>
class Figura
{
protected:
	char den[20];
public:
	Figura();
	Figura(char* den);
	~Figura();
	virtual float arie() = 0;
	virtual void afisare() = 0;
	virtual float perim() = 0;
	char *getDenumire();
};
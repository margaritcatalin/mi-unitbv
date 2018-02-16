#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
class NrRat
{
private:
	int numarator;
	int numitor;
public:
	NrRat();
	~NrRat();
	NrRat(int a, int b);
	friend std::istream& operator >> (std::istream &flux, NrRat &NR);
	friend std::ostream& operator <<(std::ostream &flux, NrRat NR);
	NrRat operator +(NrRat &nr);
	NrRat operator -(NrRat &nr);
	NrRat operator *(NrRat &nr);
	NrRat operator /(NrRat &nr);
	NrRat operator!();//fac inversul pentru impartire
	bool operator<(NrRat nr);
	int getNumarator();
	int getNumitor();
	void setNumarator(int a);
	void setNumitor(int a);
};
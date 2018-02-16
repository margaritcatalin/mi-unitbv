#include <iostream>
using namespace std;

class baza{
public:
	int i;
};

class derivat1:virtual public baza{
public:
	int j;
};

class derivat2:virtual public baza{
public:
	int k;
};

class derivat3:public derivat1, public derivat2{
public:
	int sum;
};
int main()
{
	derivat3 ob;
	//??cum rezolvati problema?
	
	ob.i=10;//care i???
	ob.j=20;
	ob.k=30;

	ob.sum=ob.i+ob.j+ob.k;//care i??

	cout<<ob.i<<"";

	cout<<ob.j<<""<<ob.k<<"";
	cout<<ob.sum;

	return 0;
}


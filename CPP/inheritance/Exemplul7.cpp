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

//??ce semnifica virtual?
//??explicati modul de functionare ptr program utilizand clase de baza virtuale
//??exista vreo diferenta intre o clasa normala si o clasa virtuala? 
// Ce se intampla in cazul in care baza este mostenita o singura data? Dar atunci cand este mostenita mai mult decat o singura data?

int main()
{
	derivat3 ob;

	ob.i=10;
	ob.j=20;
	ob.k=30;

	ob.sum=ob.i+ob.j+ob.k;

	cout<<ob.i<<" ";

	cout<<ob.j<<" "<<ob.k<<" ";
	cout<<ob.sum;

	return 0;
}


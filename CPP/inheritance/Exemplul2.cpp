#include <iostream>
using namespace std;

class baza{
protected:
	int i,j;
public:
	void pune(int a, int b){ i=a;j=b;}
	void arata(){cout<<i<<""<<j<<"\n";}
};
//i si j mosteniti ca protejati
class derivat1:protected baza{
	int k;
public:
	void punek(){k=i*j;}//legal
	void aratak(){cout<<k<<"\n";}
};
//i si j mosteniti indirect prin derivat1
class derivat2:public derivat1{
	int m;
public:
	void punem(){m=i-j;}//legal
	void aratam(){cout<<m<<"\n";}
};
//??daca baza este mostenita ca fiind private
int main()
{
	derivat1 ob1;
	derivat2 ob2;

	ob1.pune(2,3);
	ob1.arata();

	ob1.punek();
	ob1.aratak();

	ob2.pune(3,6);
	ob2.arata();
	ob2.punek();
	ob2.punem();
	ob2.aratak();
	ob2.aratam();

	return 0;
}
#include <iostream>
using namespace std;
class baza{
public:
	virtual void func(){
		cout<<"Aceasta este func() din baza"<<endl;
	}
};
class derivat1:public baza{
public:
	void func(){
		cout<<"Aceasta este func() din derivat1"<<endl;
	}
};
class derivat2:public baza{
public:
	void func(){
		cout<<"Aceasta este func() din derivat2"<<endl;
	}
};

int main()
{
	baza *p, b;
	derivat1 d1;
	derivat2 d2;

	//indica spre baza
	p=&b;
	p->func();//acces la func() din baza

	//indica spre derivat1
	p=&d1;
	p->func();//acces la func() din derivat1

	//indica spre derivat2
	p=&d2;
	p->func();

	return 0;
}
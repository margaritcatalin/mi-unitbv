#include <iostream>
using namespace std;
class baza{
public:
	baza(){cout<<"Construieste baza"<<endl;}
	~baza(){cout<<"Distruge baza"<<endl;}
};
class derivat:public baza{
public:
	derivat(){cout<<"Construieste derivat"<<endl;}
	~derivat(){cout<<"Distruge derivat"<<endl;}
};
//??explicati maniera in care sunt apelati constructorii, destructorii in cazul mostenirii
int main()
{
	derivat ob;
	//nu face nimic, decat sa construiasca si sa distruga ob
	return 0;
}
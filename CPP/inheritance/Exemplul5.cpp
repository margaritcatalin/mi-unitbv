#include <iostream>
using namespace std;

class baza{
public:
	baza(){cout<<"construieste baza"<<endl;}
	~baza(){cout<<"distruge baza"<<endl;}
};
class derivat1:public baza{
public:
	derivat1(){cout<<"construieste derivat1"<<endl;}
	~derivat1(){cout<<"distruge derivat1"<<endl;}
};
class derivat2:public derivat1{
public:
	derivat2(){cout<<"construieste derivat2"<<endl;}
	~derivat2(){cout<<"distruge derivat2"<<endl;}
};

//acelasi lucru cand apar clase de baza multiple
//??explicati maniera in care sunt apelati constructorii, destructorii in cazul mostenirii multiple
int main()
{
	derivat2 ob;
	//construieste si distruge ob
	return 0;
}


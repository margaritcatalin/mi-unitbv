#include <iostream>
using namespace std;

class baza1{
protected:
	int x;
public:
	void aratax(){cout<<x<<"\n";}
};
class baza2{
protected:
	int y;
public:
	void aratay(){cout<<y<<"\n";}
};

//mostenire din multiple clase de baza
class derivat:public baza1, public baza2{
public:
	void pune(int i, int j){x=i;y=j;}
};

int main()
{
	derivat ob;
	ob.pune(10,20);//asigurat prin derivat
	ob.aratax();//din baza1
	ob.aratay();//din baza2

	return 0;
}
#include <iostream>
using namespace std;

class baza{
	int i,j;
public:
	void pune(int a, int b){ i=a;j=b;}
	void arata(){cout<<i<<""<<j<<"\n";}
};
class derivat:public baza{//clasa derivat provine public din clasa baza
	int k;
public:
	derivat(int x){k=x;}
	void aratak(){cout<<k<<"\n";}
};
//??cand clasa de baza este mostenita prin utiliz lui private
//argumentele functiei indiferent de tipul(public,protected,private)lor ele vor fi private.
// ce se intampla cand se foloseste celalte tipuri de mosteniri?
//??cand clasa de baza este mostenita prin utiliz lui protected
//public=protected,private=protected
//??daca i,j sunt declarati protected si baza este mostenita protected
//i,j vor fi tot protected
//??daca i,j sunt declarati protected si baza este mostenita public.
//i,j vor fi protected
// Ce folos gasiti pentru cazul anterior?
//??daca i,j sunt declarati private si baza este mostenita public
//i,j sunt protected
int main()
{
	derivat ob(3);
	ob.pune(1,2);
	ob.arata();
	ob.aratak();
	return 0;
}
#include"laptop.h"
#include<string.h>
notebook::notebook()
{

}
notebook::~notebook()
{

}
int notebook::get_value()
{
    return value;
}
char *notebook::get_brand()
{
    return brand;
}

istream &operator>>(istream &flux, notebook &N)
{
    char s[20];
    flux>>s;
    N.set_name(s);
    int n;
    flux>>n;
    N.set_value(n);
    return flux;
}
ostream &operator<<(ostream &flux, notebook N)
{
    flux<<N.get_brand()<<" "<<N.get_value()<<endl;
    return flux;
}
bool operator<(notebook n1, notebook n2)
{
    if(n1.get_value()<n2.get_value())
        return true;
    return false;
}

void notebook::set_value(int nr)
{
    value = nr;
}
void notebook::set_name(char *s)
{
    strcpy(brand, s);
}

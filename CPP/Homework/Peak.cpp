#include"Peak.h";
#include<string.h>

Peak::Peak()
{

}
Peak::~Peak()
{

}
void Peak::set_name(char *s)
{
    strcpy(name,s);
}
void Peak::set_height(int h)
{
    height = h;
}
char *Peak::get_name()
{
    return name;
}
int Peak::get_height()
{
    return height;
}
istream &operator>>(istream &flux, Peak &P)
{
    int H;
    char S[20];
    flux>>S>>H;
    P.set_name(S);
    P.set_height(H);
    return flux;
}
ostream &operator<<(ostream &flux, Peak P)
{
    flux<<P.get_name()<<" - "<<P.get_height();
    return flux;
}
bool operator<(Peak p1, Peak p2)
{
    return p1.get_height()<p2.get_height();
}

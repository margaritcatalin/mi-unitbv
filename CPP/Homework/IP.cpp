#include"IP.h"

IP::IP()
{

}
IP::~IP()
{

}
void IP::set_adress(int a[4])
{
    for(int i=0;i<4;++i)
        adress[i]=a[i];
}
bool IP::is_broadcast(int a[4],int s[4])
{
    for(int i=0;i<4;++i)
    {
        if(a[i]!=(adress[i]|(~s[i])))
            return false;
    }
    return true;
}
istream &operator>>(istream &flux, IP &P)
{
    int a[4];
    for(int i=0;i<4;++i)
    {
        while(1)
        {
            flux>>a[i];
            if(a[i]<0||a[i]>255)
            {
                cout<<"Invalid adress! Read again!\n";
            }
            else
                break;
        }
    }
    P.set_adress(a);
    return flux;
}
ostream &operator<<(ostream &flux, IP P)
{
    for(int i=0;i<4;++i)
        flux<<P.adress[i]<<".";
    flux<<endl;
    return flux;
}

void IP::copy_adress(int a[4])
{
    for(int i=0;i<4;++i)
        a[i]=adress[i];
}

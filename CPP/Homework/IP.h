#include<iostream>
using namespace std;

class IP
{
    public:
        IP();
        ~IP();
        void set_adress(int a[4]);
        void copy_adress(int a[4]);
        bool is_broadcast(int a[4],int s[4]);
        friend istream &operator>>(istream &flux, IP &P);
        friend ostream &operator<<(ostream &flux, IP P);
    private:
        int adress[4];
};

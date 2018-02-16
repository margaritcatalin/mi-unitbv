#include<iostream>
using namespace std;
class Peak
{
    public:
        Peak();
        ~Peak();
        void set_name(char *s);
        void set_height(int h);
        char *get_name();
        int get_height();
        friend istream &operator>>(istream &flux, Peak &P);
        friend ostream &operator<<(ostream &flux, Peak P);
        friend bool operator<(Peak p1, Peak p2);
    private:
        char name[20];
        int height;
};

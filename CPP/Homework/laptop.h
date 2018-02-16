#include<iostream>
using namespace std;

class notebook
{
    public:
        notebook();
        ~notebook();
        void set_value(int nr);
        void set_name(char *s);
        int get_value();
        char *get_brand();
        friend istream &operator>>(istream &flux, notebook &N);
        friend ostream &operator<<(ostream &flux, notebook N);
        friend bool operator<(notebook n1,notebook n2);
    private:
        int value;
        char brand[20];
};

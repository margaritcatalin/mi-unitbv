#include"laptop.cpp"
#include<vector>
#include<algorithm>

void read(vector<notebook> &C);
void sort_by_value(vector<notebook> &C);
notebook find_most_expensive(vector<notebook> C);
int found(vector<char*> s, char* str);

int main()
{
    vector<notebook> C;
    read(C);
    sort_by_value(C);
    cout<<"Marca ce se repeta cel mai des si cel mai mare pret al acesteia:\n";
    cout<<find_most_expensive(C);
}

void read(vector<notebook> &C)
{
    int n;
    cout<<"nr. Laptopuri: ";
    cin>>n;
    cout<<endl;
    for(int i=0;i<n;++i)
    {
        notebook ntb;
        cin>>ntb;
        C.push_back(ntb);
    }
}

void sort_by_value(vector<notebook> &C)
{
    int k=0;
    for(vector<notebook>::iterator it=C.begin();it!=C.end();++it)
        ++k;
    sort(C.begin(), C.end());
}

notebook find_most_expensive(vector<notebook> C)
{
    vector<char*> s;
    vector<int> ct;
    for(int i=0;i<C.size();++i)
    {
        int pos=found(s, C[i].get_brand());
        if(pos==-1)
        {
            s.push_back(C[i].get_brand());
            ct.push_back(1);
        }
        else
        {
            ct[pos]++;
        }
    }
    char B[20];
    int ct_max=0;
    for(int i=0;i<ct.size();++i)
    {
        if(ct[i]>ct_max)
        {
            ct_max=ct[i];
            strcpy(B,s[i]);
        }
    }
    for(int i=C.size()-1;i>=0;--i)
    {
        if(strcmp(B,C[i].get_brand())==0)
            return C[i];
    }
}

int found(vector<char*> s, char *str)
{
    int k=0;
    for(vector<char*>::iterator it=s.begin();it!=s.end();++it)
    {
        if(strcmp(*it,str)==0)
            return k;
        ++k;
    }
    return -1;
}

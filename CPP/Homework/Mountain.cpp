#include"Mountain.h"
#include<algorithm>
Mountain::Mountain()
{

}
Mountain::~Mountain()
{

}

void Mountain::sort_peaks()
{
    sort(Pks.begin(),Pks.end());
}

istream &operator>>(istream &flux, Mountain &M)
{
    int n;
    char S[20];
    cout<<"\nMountain's name: ";
    flux>>S;
    strcpy(M.Mt_Name,S);
    cout<<endl<<"Number of peaks: ";
    flux>>n;
    cout<<endl<<"The peaks:\n";
    for(int i=0;i<n;++i)
    {
        Peak P;
        flux>>P;
        M.Pks.push_back(P);
    }
    return flux;
}

ostream &operator<<(ostream &flux, Mountain M)
{
    flux<<M.Mt_Name<<" - with the peaks:\n";
    for(vector<Peak>::iterator it=M.Pks.begin();it!=M.Pks.end();++it)
    {
        flux<<*it<<" | ";
    }
    return flux;
}

void Mountain::high_peaks()
{
    cout<<Mt_Name<<" - peaks above 2000m: \n";
    for(int i=0;i<Pks.size();++i)
    {
        if(Pks[i].get_height()>2000)
            cout<<Pks[i]<<" | ";
    }
    cout<<endl;
}

Peak Mountain::highest_peak()
{
    return Pks[Pks.size()-1];
}

char* Mountain::get_MTname()
{
    return Mt_Name;
}

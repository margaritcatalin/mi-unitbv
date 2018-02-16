#include"Mountain.cpp"

int main()
{
    vector<Mountain> Mts;
    int n;
    cout<<"Number of mountains: ";
    cin>>n; cout<<endl;
    cout<<"The Mountains are: \n";
    for(int i=0;i<n;++i)
    {
        Mountain aux;
        cin>>aux;
        Mts.push_back(aux);
    }
    cout<<endl<<"Mountains with the peaks sorted: \n";
    for(int i=0;i<Mts.size();++i)
    {
        Mts[i].sort_peaks();
        cout<<Mts[i]<<endl;
    }
    cout<<endl<<endl;
    for(int i=0;i<Mts.size();++i)
    {
        Mts[i].high_peaks();
        cout<<endl;
    }
    cout<<"\nHighest peaks for every mountain:\n";
    for(int i=0;i<Mts.size();++i)
    {
        cout<<"Mountain "<<Mts[i].get_MTname()<<" has the hightest peak: "<<Mts[i].highest_peak()<<endl;
    }
}

#include"IP.cpp"
#include<vector>

int main()
{
    vector<IP>Adr;
    int submask[4];
    int n;
    cout<<"Nr. adrese IP: ";
    cin>>n; cout<<"\nAdresele:\n";
    for(int i=0;i<n;++i)
    {
        IP aux;
        cin>>aux;
        Adr.push_back(aux);
    }
    cout<<"Adresa submask: ";
    for(int i=0;i<4;++i)
        cin>>submask[i];
    cout<<endl<<endl;
    cout<<"Adresele de tip broadcast sunt:\n";
    for(int i=0;i<n;++i)
    {
        for(int j=i+1;j<n;++j)
        {
            int aux[4];
            Adr[i].copy_adress(aux);
            if(Adr[j].is_broadcast(aux,submask))
            {
                cout<<Adr[j];
                break;
            }
            Adr[j].copy_adress(aux);
            if(Adr[i].is_broadcast(aux,submask))
            {
                cout<<Adr[i];
                break;
            }
        }
    }
}

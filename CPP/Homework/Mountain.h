#include"Peak.cpp"
#include<vector>
class Mountain
{
    public:
        Mountain();
        ~Mountain();
        void sort_peaks();
        void high_peaks();
        friend istream &operator>>(istream &flux, Mountain &M);
        friend ostream &operator<<(ostream &flux, Mountain M);
        char* get_MTname();
        Peak highest_peak();
    private:
        char Mt_Name[20];
        vector<Peak> Pks;
};

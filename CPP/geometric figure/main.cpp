#include"Cerc.h"
#include<vector>
#include<algorithm>
bool comparare(Cerc *p1, Cerc *p2)
{
	if (p1->arie() < p2->arie())
		return true;
	return false;
}
void citire(int &n,Figura *&cerc, std::vector<Cerc*> &c) {
	std::cout << "Cate cercuri aveti?\nRaspuns:";
	std::cin >> n;
	for (int i = 0; i < n; i++)
	{
		float x, y, r;
		std::cout << "Introduceti x:";
		std::cin >> x;
		std::cout << "Introduceti y:";
		std::cin >> y;
		std::cout << "Introduceti r:";
		std::cin >> r;
		cerc = new Cerc(x, y, r);
		Cerc *cer = dynamic_cast<Cerc*>(cerc);
		c.push_back(cer);
	}
}
void afisrevector(std::vector<Cerc*> c) {
	for (size_t i = 0; i < c.size(); i++)
	{
		Figura *cercuri = dynamic_cast<Figura*>(c[i]);
		cercuri->afisare();
	}
}
void frecventa(int n,std::vector<Cerc*> c) {
	int *vf = new int[n];
	for (int i = 0; i < n; i++)
		vf[i] = 0;
	for(int i=0;i<n;i++)
	for (int j = 0; j < n; j++)
		if (c[i]->arie() == c[j]->arie() && c[i]->getX() == c[j]->getX()&&c[i]->getY() == c[j]->getY())
			vf[i]++;
	for (int i = 0; i < n; i++)
		std::cout << "\nCercul" << i << "apare de " << vf[i]<<" ori.";
}
void Sortare(int &p,int &q,std::vector<Cerc*> &c) {
	std::cout << "\nP=";
	std::cin >> p;
	std::cout << "\nP=";
	std::cin >> q;
	std::sort(c.begin()+p, c.begin() + q,comparare);//sortare dupa arie
	afisrevector(c);
}
int main()
{
	int n,p,q;
	Figura *cercuri = NULL;
	std::vector<Cerc*> c;
	citire(n, cercuri, c);
	afisrevector(c);
	sort(c.begin(), c.end(), comparare);//sortare dupa arie
	afisrevector(c);
	Sortare(p, q, c);
	frecventa(n,c);
	return 0;
}

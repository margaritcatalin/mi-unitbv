#include"Vectori.h"
#include<vector>
#include<algorithm>
int getPrima(int b)
{
	int a = b;
	while (a>9)
	{
		a/= 10;
	}
	return a;
}

bool comparare(int i, int j)
{
	return getPrima(i) < getPrima(j);
}
void afisare(std::vector<int> v,int n)
{
	for (std::vector<int>::iterator it = v.begin(); it != v.end(); it+=2)
	{
		std::cout << ' ' << *it;
		if (it == v.end() - 1)
			break;
	}
}
int main()
{
	std::vector<int> v;
	int n;
	std::cout << "Cate elemente aveti in vector?" << std::endl << "Raspuns:";
	std::cin >> n;
	for (int i = 0; i < n; i++)
	{
		int x;
		std::cin >> x;
		v.push_back(x);
	}
	for (std::vector<int>::iterator it = v.begin(); it != v.end(); ++it)
		std::cout << ' ' << *it;
	std::cout << std::endl;
	afisare(v,n);
	std::sort(v.begin(), v.end(), comparare);
	std::cout << std::endl;
	for (std::vector<int>::iterator it = v.begin(); it != v.end(); ++it)
	{
		std::cout << ' ' << *it;
		if (it == v.end() - 1)
			break;
	}

		return 0;
}
//#include<iostream>
//using namespace std;
//void main()
//{
//	unsigned x,b2,dim,baza,copie;
//	cout << "Numarul este:";
//	cin >> x;
//	while (1)
//	{
//		cout << "\nIntroduceti baza dorita(introduceti 0 pentru a iesi din ciclu):";
//		cin >> baza;
//		copie = x;
//		if (baza == 0)
//		{
//			return;
//		}
//		if (baza == 16)
//		{
//			cout << "Numarul in " << baza << " este:";
//			cout << hex << copie;
//		}
//		else {
//			b2 = 0;
//			dim = 1;
//			while (copie != 0)
//			{
//				b2 = b2 + dim*(copie%baza);
//				dim = dim * 10;
//				copie = copie / baza;
//			}
//			cout << "Numarul in " << baza << " este:" << b2;
//		}
//	}
//}
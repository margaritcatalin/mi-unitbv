#include"Heap.h"
void main()
{
	unsigned n;
	int x;
	Heapmin h(20);
	cout<<endl << "Cate elemente introduceti in heap?";
	cin >> n;
	for (int i = 0; i <n; i++)
	{
		cout << endl << "Introduceti valoarea pe care doriti sa o bagati in heap!:";
		cin >> x;
		h.insert(x);
	}
	cout<<endl << "Heap min:";
	h.afisare();
	cout << endl << "Minimul din heap este:"<<h.getMin();
}
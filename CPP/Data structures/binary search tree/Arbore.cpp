#include <iostream>
using namespace std;
struct nod
{
	int info;
	nod*p, *st, *dr;
	nod()
	{
		this->st =NULL;
		this->dr = NULL;
		this->p = NULL;
	}
};
struct Arbore
{
	nod*rad;
	Arbore()
	{
		this->rad = NULL;
	}
	void insert(nod* k)
	{
		nod*x = rad;
		nod*y = NULL;
		while (x != NULL)
		{
			y = x;
			if (k->info < x->info)
			{
				x = x->st;
			}
			else
			{
				x = x->dr;
			}
		}
		k->p = y;   
		if (y == NULL)
		{
			rad = k;
		}
		else
		{
			if (y->info < k->info)
			{
				y->dr = k;
			}
			else
			{
				y->st = k;
			}
		}
	}
	nod*cautare(int k)
	{
		nod*x = rad;
		while (x != NULL && x->info != k)
			if (x->info>k)
				x = x->st;
			else
				x = x->dr;
		return x;
	}
	nod*min(nod*x)
	{
		while (x->st != NULL)
			x = x->st;
		return x;
	}
	nod*max(nod*x)
	{
		while (x->dr != NULL)
			x = x->dr;
		return x;
	}
	nod*succesor(nod*x)
	{
		if (x->dr != NULL)
			return min(x->dr);
		else
		{
			nod*y = new nod;
			y = x->p;
			while (y != NULL && x == y->dr)
			{
				x = y;
				y = y->p;
			}

			return y;
		}
	}
	nod *predecesor(nod *x)
	{
		nod *y;
		if (x->st != NULL)
		{
			return max(x->st);
		}
		else
		{
			y = x->p;
			while (y != NULL && x == y->st)
			{
				x = y;
				y = y->p;
			}
			return y;
		}
	}
	void transplant(nod*u, nod*v)
	{
		if (u->p == NULL)
			rad = v;
		else
		{
			if (u == u->p)
				u->p->st = v;
			else
				u->p->dr = v;

		}
		if (v != NULL)
			v->p = u->p;
	}
	void sterge(nod *z)
	{
		nod *y;
		if (z->st == NULL)
			transplant(z, z->dr);
		else
			if (z->dr == NULL)
				transplant(z, z->dr);
			else
			{
				y = succesor(z);
				if (y != z->dr)
				{
					transplant(y, y->dr);
					y->dr = z->dr;
					z->dr->p = y;
				}
				y->st = z->st;
				z->st->p = y;
				transplant(z, y);
			}
	}
	void SRD(nod*x)
	{
		if (x)
		{
			SRD(x->st);
			cout << x->info << " ";
			SRD(x->dr);
		}

	}
	void RSD(nod*x)
	{
		if (x)
		{
			cout << x->info << " ";
			RSD(x->st);
			RSD(x->dr);
		}

	}
	void SDR(nod*x)
	{
		if (x)
		{
			SDR(x->st);
			SDR(x->dr);
			cout << x->info << " ";
		}

	}
};
int main()
{
	Arbore arb;
	int n, val,nr;
	cout << endl << "Cate noduri are arborele?:";
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cout<<endl << "Introduceti informatia pe care o bagati in abore!:";
		cin >> nr;
		nod *z;
		z = new nod;
		z->info = nr;
		arb.insert(z);
	}
	cout << "Parcurgerea in inordine: ";
	arb.SRD(arb.rad);
	cout << endl << "Parcurgerea in preordine: ";
	arb.RSD(arb.rad);
	cout << endl << "Parcurgerea in postordine: ";
	arb.SDR(arb.rad);
	cout << "Introduceti valoarea cautata: ";
	cin >> val;
	if (arb.cautare(val)) cout << "S-a gasit in arbore!"<<endl;
	else cout << "Nu s-a gasit in arbore!" << endl;
	cout<<endl<<"Minimul este:" << arb.min(arb.rad)->info << endl;
	cout << endl << "Maximul este:" << arb.max(arb.rad)->info << endl;
	return 0;
}
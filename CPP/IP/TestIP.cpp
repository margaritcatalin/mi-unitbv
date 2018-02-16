#include "IPAddress.h"

int count(IP_Address *myIPs,int n) {
	int broadcastIP = 0;
	for (int i = 0; i < n; i++) {
		if (myIPs[i].get_x4() == 255)
			broadcastIP++;
	}
	return broadcastIP;
}

int verify(IP_Address i) {
	if (i.get_x1() == -1 || i.get_x2() == -1 || i.get_x3() == -1 || i.get_x4() == -1)
		return 0;
	return 1;
}

int main() {
	int n,i;
	ifstream f("data.txt");
	f >> n;
	IP_Address *myIPs=new IP_Address[n];
	for (i = 0; i < n; i++) {
		f >> myIPs[i];
		if (!verify(myIPs[i])) {
			cout << "Invalid address.";
			cin >> n;
			return 1;
		}
	}
	cout << count(myIPs, n) << " broadcast IP's .";
	cin >> n;
	return 0;
}
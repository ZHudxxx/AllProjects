# include <iostream>
using namespace std;
int main()
{
	int cost_price,sell_price,profit, loss;
	cout <<"enter cost price (RM):"<<endl;
	cin>>cost_price;
	cout <<"enter selling price (RM):"<<endl;
	cin>>sell_price;
	if(sell_price>cost_price)
	{
		profit=sell_price-cost_price;
		cout<<"your profit is (RM):"<<profit<<endl;
	}
	else if(cost_price>sell_price)
{
	loss=cost_price-sell_price;
	cout<<"your loss is(RM):"<<loss<<endl;
}
else
{
	cout<<"you don't have profit or loss'.";
}
}
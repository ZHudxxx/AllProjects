# include <iostream>                                                                                         
using namespace std;
int main()
{
	//calculate total sale for an item//
	cout<< "Please insert input to calculate total sales"<<endl;
	cout<< ""<<endl;
	string item_name;
	int cost_price, sell_price, profit, losses, item_price, item_quantity, total;
	
	cout<< "Enter item name: "<<endl;
	cin>> item_name;
	cout<< "Enter item price (RM): "<<endl;
	cin>> item_price;
	cout<< "Enter quantity sold: "<<endl;
	cin>> item_quantity;
	total=item_price * item_quantity;
	
	cout<< ""<<endl;
	cout<< ""<<endl;
	
    //calculate profit or losses//

	cout<< "Please insert input for Calculate profit and losses"<<endl;
	cout<< ""<<endl;
	
	cout<< "Enter cost price:"<<endl;
	cin>> cost_price;
	cout<< "Enter selling price:"<<endl;
	cin>> sell_price;
	cout<< ""<<endl;
	cout<< ""<<endl;
	
	if(sell_price>cost_price)
	{
		profit=sell_price-cost_price;
		cout<<"total sales for "<<item_name<< " is (RM):"<<total<<endl;
		cout<<"your profit is (RM):"<<profit<<endl;
		cout<<"Level of profit is GOOD keep the good work!"<<endl;
		
	
	
	}
	else if(cost_price>sell_price)
	{
		losses=cost_price-sell_price;
		cout<<"total sales for "<<item_name<< " is (RM):" <<total<<endl;
		cout<<"your losses is (RM):"<<losses<<endl;
		cout<<"Level of profit is BAD please increas your selling price!"<<endl;
	}
	else
	{
		cout<<"total sales for "<<item_name<< " is (RM):" <<total<<endl;
		cout<<"you don't have any profit or losses"<<endl;
		cout<<"Level of profit is NORMAL"<<endl;


}
}
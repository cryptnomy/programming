class Order {
    private int mN, mP, mQ; // mN, mPrice, mQuantity
    public Order next;

    public Order() {
        this.mN = 0;
        this.mP = 0;
        this.mQ = 0;
        this.next = null;
    }

    public Order(int mNumber, int mPrice, int mQuantity, Order next) {
        this.mN = mNumber;
        this.mP = mPrice;
        this.mQ = mQuantity;
        this.next = next;
    }

    public int getNumber() {
        return this.mN;
    }

    public int getPrice() {
        return this.mP;
    }

    public int getQuantity() {
        return this.mQ;
    }
}

public class OrderList {
    private Order root;

    public OrderList() {
        root = null;
    }

    public void insertOrder(Order currOrder, Order newOrder) {
        newOrder.next = currOrder.next;
        currOrder.next = newOrder;
    }

    public void serachOrder(Order newOrder, int mNumber, int mPrice, int mQuantity) {
        if (root.next == null) {
            // One left buy side order
            insertOrder(root, newOrder);
        }
        else if (root.next.) {

        }
    }
}

class UserSolution
{
	public void init()
	{
        Stock1 = OrderList();

	}
	
	public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		if 
        return 0;
	}
	
	public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		return 0;
	}

	public void cancel(int mNumber)
	{
	}
	
	public int bestProfit(int mStock)
	{
		return 0;
	}
}
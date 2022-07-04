// 시간 여행자의 주식
#include <iostream>
#include <vector>

void init() {
    int mNumber, mQuantity, mPrice;
    __int8 mStock;
    
}

int buy(int mNumber, int mStock, int mQuantity, int mPrice) {

}

int sell(int mNumber, int mStock, int mQuantity, int mPrice) {

}

void cancel(int mNumber) {

}

int bestProfit(int mStock) {

}

int main() {
    init();
    buy(1, 1, 5, 105);
    buy(2, 1, 5, 100);
    sell(3, 1, 12, 100);
    bestProfit(1);
    sell(4, 1, 8, 90);
    sell(5, 1, 1, 110);
    buy(6, 1, 11, 110);
    bestProfit(1);
    buy(7, 1, 1, 80);
    buy(8, 1, 1, 85);
    sell(9, 1, 3, 70);
    cancel(9);
    buy(10, 1, 1, 70);
    bestProfit(1);
    sell(11, 5, 500000, 1000000);
    sell(12, 5, 499999, 999999);
    buy(13, 5, 1000000, 1000000);
    bestProfit(5);

    return 0;
}
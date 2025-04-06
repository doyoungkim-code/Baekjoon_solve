#include <iostream>
#include <stack>

int main(){
    std::stack<int> st;
    int n, cost, sum = 0;
    std::cin >> n;
    for (int i = 0; i < n; i ++){
        std::cin >> cost;
        if (cost == 0)
            st.pop();
        else
            st.push(cost);
    }
    while (st.empty() == 0){
        sum += st.top();
        st.pop();
    }
    std::cout << sum;
    return (0);
}
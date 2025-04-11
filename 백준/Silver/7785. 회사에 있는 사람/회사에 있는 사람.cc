#include <iostream>
#include <set>

int main(void){
    int N;
    std::string human, status;
    std::set <std::string, std::greater<std::string>> st;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    for (int i = 0; i < N; i ++){
        std::cin >> human;
        std::cin >> status;
        if (status == "enter")
            st.insert(human);
        else if (status == "leave")
            st.erase(human);
    }
    for (auto it = st.begin(); it != st.end(); it ++){
        std::cout << *it << "\n";
    }
}
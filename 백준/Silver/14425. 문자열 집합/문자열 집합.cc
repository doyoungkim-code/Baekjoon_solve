#include <iostream>
#include <set>

int main(void){
    int N, M, count = 0;
    std::string S;
    std::set <std::string> st;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    std::cin >> M;
    for (int i = 0; i < N; i ++){
        std::cin >> S;
        st.insert(S);
    }
    for (int i = 0; i < M; i ++){
        std::cin >> S;
        if (st.find(S) != st.end())
            count ++;
    }
    std::cout << count;
}
#include <iostream>
#include <deque>

using namespace std;

int N, Q, a, com, index, x;
int offset = 0;
deque <int> deq;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N >> Q;
    for (int i = 0; i < N; ++ i)
    {
        cin >> a;
        deq.push_back(a);
    }
    for (int i = 0; i < Q; ++ i)
    {
        cin >> com;
        if (com == 1)
        {
            cin >> index >> x;
            int real_index = (offset + index - 1) % N;
            deq[real_index] = deq[real_index] + x;
        }
        else if (com == 2)
        {
            cin >> index;
            offset = (offset - index + N) % N;
        }
        else if (com == 3)
        {
            cin >> index;
            offset = (offset + index) % N;
        }
    }
    for (int i = 0; i < N; i ++)
    {
        cout << deq[(offset + i) % N] << " ";
    }
}
#include <iostream>
#include <stack>
#include <string>

int main(void){
    while(1){
        int flag = 0;
        std::stack<char> stack;
        std::string str = "";
        std::getline(std::cin, str);
        if (str == ".")
            break ;
        else {
            for (int i = 0; i < str.length(); i ++){
                if (str[i] == '(' || str[i] == '[')
                    stack.push(str[i]);
                else if (!stack.empty() && str[i] == ')'){
                    if (stack.top() == '(')
                        stack.pop();
                    else{
                        flag = 1;
                        break ;
                    }
                }
                else if (!stack.empty() && str[i] == ']'){
                    if (stack.top() == '[')
                        stack.pop();
                    else{
                        flag = 1;
                        break ;
                    }
                }
                else if (stack.empty() && (str[i] == ')' || str[i] == ']'))
                    flag = 1;
            }
            if (flag == 0 && stack.empty() == 1)
                std::cout << "yes" << std::endl;
            else
                std::cout << "no" << std::endl;
        }
    }
    return (0);
}
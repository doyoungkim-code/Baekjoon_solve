#include <stdio.h>

int main(void)
{
    char    sen[100];
    int     num;
    int     i;

    scanf("%s", sen, (int) sizeof(sen));
    num = 0;
    i = 0;
    while (sen[i] != '\0')
    {
        if (sen[i] == 'c' && (sen[i + 1] == '=' || sen[i + 1] == '-'))
        {
                num ++;
                i ++;
        }
        else if (sen[i] == 'd' && sen[i + 1] == '-')
        {
            num ++;
            i ++;
        }
        else if (sen[i] == 'd' && sen[i + 1] == 'z' && sen[i + 2] == '=')
        {
            num ++;
            i = i + 2;
        }
        else if (sen[i] == 'l' && sen[i + 1] == 'j')
        {
            num ++;
            i ++;
        }
        else if (sen[i] == 'n' && sen[i + 1] == 'j')
        {
            num ++;
            i ++;
        }
        else if (sen[i] == 's' && sen[i + 1] == '=')
        {
            num ++;
            i ++;
        }
        else if (sen[i] == 'z' && sen[i + 1] == '=')
        {
            num ++;
            i ++;
        }
        else
            num ++;
        i ++;
    }
    printf("%d", num);
    return (0);
}
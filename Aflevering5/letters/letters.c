#include <stdio.h>
#include <string.h>
#include <ctype.h>

int letters(char *s);

int main(){
    // Bygger en string der kan have op til længden 10.000
    char str[10000];
    printf("> ");
    // scanner input som string, der først bliver stoppet når den bliver mødt ved en ny linje (Enter knap)
    scanf("%[^\n]", str);
    // gemmer antallet af bogstaver i en integer kaldet result der så printes.
    int result = letters(str);
    printf("%d\n", result);
    return 0;
}

int letters(char *str){
    // tager længden af strengen.
    int length = strlen(str);
    int count =0;
    // looper igennem hele strengen og hvis den møder en karakter i alfabetet (isalpha) så tæller den counter 1 op.
    for (int i = 0; i <length; i ++)
        if (isalpha(str[i])) count++;
    // count bliver returnet ind i result i main.
    return count;
}

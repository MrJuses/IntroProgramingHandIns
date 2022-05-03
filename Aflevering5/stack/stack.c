// stack.c

#include <stdlib.h>
#include <stdio.h>
#include "stack.h"

/*

Tilføj funktionerne newStack, pop, push, top og empty.

*/
stack_t * newStack(){
    stack_t * nstack;
    nstack = malloc(sizeof (stack_t));
    nstack->array = malloc(sizeof (int));
    nstack->capacity = 1;
    nstack->size = 0;
    return nstack;
}
int pop(stack_t * nstack){
    if(empty(nstack) == 1) {
        printf("\nError! Cant find element, Stack is empty\n");
        exit(1);
    } else{
        int temp = nstack->array[nstack -> size-1];
        nstack->size--;
        return temp;
    }
}
void push(stack_t * nstack, int val){
    if(nstack->array[nstack->size] == nstack->capacity){
        nstack -> capacity = nstack -> capacity * 2;
    }
    nstack->array[nstack->size] = val;
    nstack -> size ++;
}
int top(stack_t * nstack){
    if(nstack->size == 0){
        printf("Array is empty");
    } else {
        return nstack->array[nstack -> size-1];
    }
}
int empty(stack_t * nstack){
    if(nstack->size == 0){
        return 1;
    } else {
        return 0;
    }
}

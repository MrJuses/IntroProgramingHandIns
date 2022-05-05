// stack.c

#include <stdlib.h>
#include <stdio.h>
#include "stack.h"

//Generating new empty stack
stack_t * newStack(){
    stack_t * nstack;
    //allocates memory
    nstack = malloc(sizeof (stack_t));
    nstack->array = malloc(sizeof (int));
    nstack->capacity = 1;
    nstack->size = 0;
    return nstack;
}
//removes top element, if no element can be found an error is pushed and the program stops
int pop(stack_t * nstack){
    if(empty(nstack) == 1) {
        printf("\nError! Cant find element, Stack is empty\n");
        exit(1);
        //removes element and returns the element removed to be printed
    } else{
        int temp = nstack->array[nstack -> size-1];
        nstack->size--;
        return temp;
    }
}
//pushes new element on top of stack, if the stack is full the capacity is doubled.
void push(stack_t * nstack, int val){
    if(nstack->array[nstack->size] == nstack->capacity){
        nstack -> capacity = nstack -> capacity * 2;
    }
    nstack->array[nstack->size] = val;
    nstack -> size ++;
}
//returns top element, if no element exists an error is produced
int top(stack_t * nstack){
    if(nstack->size == 0){
        printf("Array is empty");
    } else {
        return nstack->array[nstack -> size-1];
    }
}
//checks if stack is empty, returns 1 if stack is empty and 0 if not
int empty(stack_t * nstack){
    if(nstack->size == 0){
        return 1;
    } else {
        return 0;
    }
}

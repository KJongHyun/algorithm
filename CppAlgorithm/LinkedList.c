/*
//
// Created by JongHyeon Kim on 2019/11/13.
//
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node * next;
}Node;

int main()
{
    Node * head = (Node*)malloc(sizeof(Node));
    head->data = 3;

    Node * node1 = (Node*)malloc(sizeof(Node));
    node1->data = 5;
    head->next = node1;

    Node * node2 = (Node*)malloc(sizeof(Node));
    node2->data = 7;
    node1->next = node2;
    node2->next = NULL;

    Node * current = head;
    while(current != NULL) {
        printf("%d\n", current->data);
        current = current->next;
    }
}
*/

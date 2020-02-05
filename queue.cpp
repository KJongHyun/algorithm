////
//// Created by JongHyeon Kim on 2020/02/04.
////
//#include <iostream>
//using namespace std;
//
//template<typename T>
//class Queue {
//public:
//    class Value {
//    public:
//        T data;
//        Value * next;
//    };
//
//private:
//    Value * frontPtr = NULL;
//    Value * tailPtr = NULL;
//
//public:
//
//    void push_back(T data) {
//        Value * valueInstance = new Value();
//        valueInstance->data = data;
//        valueInstance->next = NULL;
//        if (frontPtr == NULL)
//            frontPtr = valueInstance;
//        if (tailPtr == NULL)
//            tailPtr = valueInstance;
//        else {
//            tailPtr->next = valueInstance;
//            tailPtr = valueInstance;
//        }
//    }
//
//    T& front() {
//        if (frontPtr != NULL)
//            return frontPtr->data;
//    }
//
//    void pop() {
//        if (frontPtr != NULL) {
//            Value * temp = frontPtr;
//            frontPtr = temp->next;
//            delete temp;
//        }
//    }
//
//    bool empty() {
//        if (frontPtr == NULL)
//            return true;
//        else
//            return false;
//    }
//};
//
//
//int main() {
//
//    Queue<int> q;
//    q.push_back(3);
//    q.push_back(4);
//    q.push_back(1);
//    q.push_back(5);
//
//    while (!q.empty()) {
//        int a = q.front();
//        q.pop();
//
//        cout << a << endl;
//    }
//
//
//
//    return 0;
//
//}
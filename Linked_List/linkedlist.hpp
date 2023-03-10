#include <iostream>
using namespace std;

template <typename Type>
struct Node{
    Type value;
    Node<Type> *next;
};

template <class Type>
class LinkedList{
    private:
        int NumberOfElements = 0;
        Node<Type> *first;
        Node<Type> *last;

    public:
        LinkedList(){
            first = NULL;
            last = NULL;
        }      

        bool empty(); 
        int size(); 
        void push_back(Type new_element); 
        void push_front(Type new_element); //done
        void erase(Type element); 
        Type back(); 
        Type top(); 
        Node<Type>* find(Type element); 
        void display(); 
        Node<Type>* begin(); 
        Node<Type>* end(); 
        int count(Type element); 
        void pop_back(); 
        void pop_front(); 
};

template <typename Type>
inline bool LinkedList<Type>::empty(){
    if(first == nullptr)
        return true;
    else
        return false;
}

template <typename Type>
inline int LinkedList<Type>::size(){
    return NumberOfElements;
}

template<typename Type> 
inline void LinkedList<Type>::push_back(Type new_element){
    Node<Type> *n = new Node<Type>;
    n -> value = new_element;
    n -> next = NULL;
    if(empty()){
        first = n;
        last = n;
    }
    else{
        last -> next = n;
        last = n;
    }
    NumberOfElements++;
}

template<typename Type> 
inline void LinkedList<Type>::push_front(Type new_element){
    Node<Type> *n = new Node<Type>;
    n -> value = new_element;
    if(empty()){
        n -> next = NULL;
        first = n;
        last = n;
    }
    else{
        n -> next = first;
        first = n;
    }
    NumberOfElements++;
}

template <typename Type>
inline void LinkedList<Type>::erase(Type element){
    if(first -> value == element){
        pop_front();
    }
    else if(last -> value == element){
        pop_back();
    }
    else{
        Node<Type> * curr = first -> next;
        Node<Type> * prevcurr = first;
        while(curr != NULL && curr -> value != element)  {
            prevcurr = curr;
            curr = curr -> next;
        } 
        if(curr == NULL) return;
        prevcurr -> next = curr -> next;
        delete curr;
    }
}

template<class Type>
inline Type LinkedList<Type>::back(){
    return last->value;
}

template<class Type>
inline Type LinkedList<Type>::top(){
    return first->value;
}

template <typename Type>
inline Node<Type>* LinkedList<Type>::find(Type element){
    Node<Type> *current = first;
    while(current -> value != element && current != NULL){
        current = current -> next;
    }
    return current;
}

template <typename Type>
inline void LinkedList<Type>::display(){
    Node<Type> *current = first;
    while(current != NULL){
        cout<< current -> value <<' ';
        current = current->next;
    }
    cout<<'\n';
    delete current;
}

template<class Type>
inline Node<Type> * LinkedList<Type>::begin(){
    return first;
}

template<class Type>
inline Node<Type> * LinkedList<Type>::end(){
    return last;
}

template <class Type>
inline int LinkedList<Type>::count(Type element)
{
    int c = 0;
    Node<Type> *curr = first;
    while(curr != NULL){
        if(curr -> value == element) c++;
        curr = curr -> next;
    }
    free(curr) ;
    return c;
}

template <class Type>
inline void LinkedList<Type>::pop_back(){
    Node<Type> *curr = first;  
    Node<Type> *prevCurr = NULL;  
    while(curr -> next != NULL){
        prevCurr = curr;
        curr = curr -> next;
    }
    prevCurr -> next = NULL;
    last = prevCurr;
    delete curr;
}

template <class Type>
inline void LinkedList<Type>::pop_front(){
    Node<Type> *tmp = first;
    first = first -> next;
    delete tmp;
}
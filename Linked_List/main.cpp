#include <bits/stdc++.h>
#include "linkedlist.hpp"
using namespace std;
int main(){
    LinkedList<int> g;
    g.push_back(56);
    g.push_back(5);
    g.push_back(3);
    g.push_back(3);
    g.push_back(3);
    g.push_back(22);
    for(auto x = g.begin() ; x != NULL; x = x-> next){
        cout<<x -> value <<'\n';
    }
    cout<<g.size()<<'\n';
    
    return 0;
}
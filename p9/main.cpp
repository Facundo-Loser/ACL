#include <iostream>
using namespace std;

class A {
    private:
    public:
    // constructor:
    A() {}

    void m1() {
        cout << "AAAA" << endl;
    }

    void m() {
        this->m1();
    }
};

class B : public A {
    private:
    public:
    B() {}
    
    void m1() {
        cout << "BBBB" << endl;
    }
};

int main(void) {
    B b;
    b.m(); // muestra AAAA
    return 0;
}

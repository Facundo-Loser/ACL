#include <iostream>

class A {
    private:
    public:
    // constructor:
    A() {}

    virtual void m1() {
        std::cout << "AAAA" << std::endl;
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
        std::cout << "BBBB" << std::endl;
    }
};

int main(void) {
    B b;
    b.m(); // muestra AAAA
    return 0;
}

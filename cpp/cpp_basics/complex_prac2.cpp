#include <iostream>
#include <cstring>

class Complex {
    private:
        double real, imag;
        double get_number(const char* str, int from, int to) const;
    
    public:
        Complex(double real, double imag): real(real), imag(imag) {}
        Complex(const Complex& c) { real = c.real, imag = c.imag; }
        Complex(const char* str);
        
        Complex& operator+=(const Complex& c);
        Complex& operator=(const Complex& c);

        friend std::ostream& operator<<(std::ostream& os, const Complex& c);
        friend Complex operator+(const Complex& a, const Complex& b);
};

std::ostream& operator<<(std::ostream& os, const Complex& c) {
    os << "(" << c.real << ", " << c.imag << ")";
    return os;
}

Complex operator+(const Complex& a, const Complex& b) {
    Complex temp(a.real + b.real, a.imag + b.imag);
    return temp;
}

Complex::Complex(const char* str) {
    int begin = 0, end = strlen(str);
    real = imag = 0.0;
    int pos_i = -1;
    for (int i = 0; i != end; i++) {
        if (str[i] == 'i') {
            pos_i = i;
            break;
        }
    }
    if (pos_i == -1) {
        real = get_number(str, begin, end - 1);
        return;
    }
    real = get_number(str, begin, pos_i - 1);
    imag = get_number(str, pos_i + 1, end -1);

    if (pos_i >= 1 && (str[pos_i - 1] == '-' || str[pos_i - 2] == '-'))
        imag = -1.0;
}

double Complex::get_number(const char* str, int from, int to) const {
    bool minus = false;
    if (from < 0) return 0;
    if (str[from] == '-') minus = true;
    if (str[from] == '-' || str[from] == '+') from++;
    double num = 0.0, decimal = 1.0;
    bool integer_part = true;
    for (int i = from; i <= to; i++) {
        if (isdigit(str[i]) && integer_part) {
            num *= 10.0;
            num += (str[i] - '0');
        } else if (str[i] == '.')
            integer_part = false;
        else if (isdigit(str[i]) && !integer_part) {
            decimal /= 10.0;
            num += ((str[i] - '0') * decimal);
        } else
            break;
    }
    if (minus) num *= -1;
    return num;
}

Complex& Complex::operator+=(const Complex& c) {
    (*this) = *this + c;
    return *this;
}

Complex& Complex::operator=(const Complex& c) {
    real = c.real;
    imag = c.imag;
    return *this;
}

int main() {
    Complex a(0, 0);
    a = "-1.1 + i3.923" + a;
    std::cout << "Value of a: " << a << std::endl;
}
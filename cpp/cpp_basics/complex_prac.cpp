#include <iostream>
#include <cstring>

class Complex {
    private:
        double real, imag;
        double get_number(const char* str, int from, int to) const;

    public:
        Complex(double real, double imag):
            real(real), imag(imag) {}
        Complex(const Complex& c) {
            real = c.real;
            imag = c.imag;
        }
        Complex(const char* str);
        Complex operator+(const Complex& c) const;
        Complex operator-(const Complex& c) const;
        Complex operator*(const Complex& c) const;
        Complex operator/(const Complex& c) const;

        Complex operator+(const char* str) const;
        Complex operator-(const char* str) const;
        Complex operator*(const char* str) const;
        Complex operator/(const char* str) const;

        Complex& operator=(const Complex& c);
        Complex& operator+=(const Complex& c);
        Complex& operator-=(const Complex& c);
        Complex& operator*=(const Complex& c);
        Complex& operator/=(const Complex& c);

        void println() { std::cout << "( " << real << ", "
                         << imag << " )" << std::endl; }
};

double Complex::get_number(const char* str, int from, int to) const {
    bool minus = false;
    if (from > to) return 0;
    if (str[from] == '-') minus = true;
    if (str[from] == '-' || str[from] == '+') from++;
    double num = 0.0;
    double decimal = 1.0;
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
    if (minus) num *= -1.0;
    return num;
}

Complex::Complex(const char* str) {
    int begin = 0, end = strlen(str);
    imag = 0.0, real = 0.0;
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
    imag = get_number(str, pos_i + 1, end - 1);
    if (pos_i >= 1 &&
        (str[pos_i - 1] == '-' || str[pos_i - 2] == '-'))
        imag *= -1.0;
}

Complex Complex::operator+(const Complex& c) const {
    Complex temp(real + c.real, imag + c.imag);
    return temp;
}

Complex Complex::operator-(const Complex& c) const {
    Complex temp(real - c.real, imag - c.imag);
    return temp;
}

Complex Complex::operator*(const Complex& c) const {
    Complex temp(real * c.real - imag * c.imag,
                 real * c.imag + imag * c.real);
    return temp;
}

Complex Complex::operator/(const Complex& c) const {
    double den = c.real * c.real + c.imag * c.imag;
    Complex temp((real * c.real + imag * c.imag)/den,
                 (imag * c.real - real * c.imag)/den);
    return temp;
}

Complex Complex::operator+(const char* str) const {
    Complex temp(str);
    return (*this) + temp;
}

Complex Complex::operator-(const char* str) const {
    Complex temp(str);
    return (*this) - temp;
}

Complex Complex::operator*(const char* str) const {
    Complex temp(str);
    return (*this) * temp;
}

Complex Complex::operator/(const char* str) const {
    Complex temp(str);
    return (*this) / temp;
}

Complex& Complex::operator=(const Complex& c) {
    real = c.real;
    imag = c.imag;
    return *this;
}

Complex& Complex::operator+=(const Complex& c) {
    (*this) = (*this) + c;
    return *this;
}

Complex& Complex::operator-=(const Complex& c) {
    (*this) = (*this) - c;
    return *this;
}

Complex& Complex::operator*=(const Complex& c) {
    (*this) = (*this) * c;
    return *this;
}

Complex& Complex::operator/=(const Complex& c) {
    (*this) = (*this) / c;
    return *this;
}

int main() {
    Complex a(1.0, 2.0);
    Complex b(3.0, -2.0);
    Complex c(0.0, 0.0);
    c = a * b + a / b + a + b;
    c.println();
    a += b;
    a.println();
    b.println();
    Complex d(0, 0);
    d = d + "-1.1 + i3.923";
    d.println();
    d = d - "1.2 - i1.823";
    d.println();
    d = d * "2.3 + i22";
    d.println();
    d = d / "-12 + i55";
    d.println();
}
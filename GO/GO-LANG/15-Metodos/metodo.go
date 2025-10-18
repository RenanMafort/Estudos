package main

import (
	"fmt"
	"math"
)

type forma interface {
	area() float64
}

func escreverArea(f forma) {
	fmt.Printf("A area é - %f\n", f.area())
}

type circulo struct {
	raio float64
}

func (c circulo) area() float64 {
	return math.Pi * (c.raio * c.raio)
}

type retangulo struct {
	altura float64
	base   float64
}

func (r retangulo) area() float64 {
	return r.base * r.altura
}

func main() {
	r := retangulo{10, 15}
	escreverArea(r)

	c := circulo{12}
	escreverArea(c)
}

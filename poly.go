package main

import "fmt"

type Animal interface {
	Sound() string
}

// Dog is a type that satisfies the Animal interface
type Dog struct{}

// Sound implements the Sound method of the Animal interface for Dog
func (d Dog) Sound() string {
	return "Woof!"
}

// Cat is a type that satisfies the Animal interface
type Cat struct{}

// Sound implements the Sound method of the Animal interface for Cat
func (c Cat) Sound() string {
	return "Meow!"
}

func main() {
	// Create a slice of Animal interface values
	animals := []Animal{Dog{}, Cat{}}

	// Iterate over the animals and make them sound
	for _, animal := range animals {
		fmt.Println(animal.Sound())
	}
}

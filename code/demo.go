package main

import (
	"fmt"
)

func div(x, y int) (int, error) {
	if y == 0 {
		return 0, fmt.Errorf("cannot divide by zero")
	}
	return x / y, nil
}
func main() {
	result, err := div(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Result:", result)
	}
}

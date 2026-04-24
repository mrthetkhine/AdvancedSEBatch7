package main

import "fmt"

// BankAccount struct
type BankAccount struct {
	balance float64 // not using encapsulation
}

// Withdraw method to withdraw money
func (acc *BankAccount) Withdraw(amount float64) {
	acc.balance -= amount
}

// Deposit method to deposit money
func (acc *BankAccount) Deposit(amount float64) {
	acc.balance += amount
}
func (acc *BankAccount) ShowBalance() {
	fmt.Println("Balance ", acc.balance)
}

func main() {
	account := &BankAccount{}
	account.balance = 2000
	account.Deposit(100)
	account.Withdraw(50)
	account.ShowBalance()
}

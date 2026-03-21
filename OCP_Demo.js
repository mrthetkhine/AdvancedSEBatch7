class Employee
{
    calculatePay()
    {
        console.log("Calculating pay for salaried employee.");
    }
}
class CommmissionEmployee extends Employee
{
    calculatePay()
    {
        console.log("Calculating pay for commission employee.");
    }
}
class HourlyEmployee extends Employee
{
    calculatePay()
    {
        console.log("Calculating pay for hourly employee.");
    }
}
function processPayroll(employees)
{
    for(let employee of employees)
    {
        employee.calculatePay();
    }
}
class FreelanceEmployee extends Employee
{
    calculatePay()
    {
        console.log("Calculating pay for freelance employee.");
    }
}
let employees = [new Employee(), new CommmissionEmployee(), new HourlyEmployee(), new FreelanceEmployee()];
processPayroll(employees);
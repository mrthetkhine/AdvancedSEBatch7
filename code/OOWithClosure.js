function Stack()
{
    let items = [];
    function push(element)
    {
        items.push(element);
    }
    function pop()
    {
        return items.pop();
    }
    return {
        push,
        pop
    };
}
let stack = Stack();
stack.push(1);
stack.push(2);
console.log(stack.pop());   
console.log(stack.pop());

let stack2 = Stack();
stack2.push("a");
stack2.push("b");
console.log(stack2.pop());   
console.log(stack2.pop());
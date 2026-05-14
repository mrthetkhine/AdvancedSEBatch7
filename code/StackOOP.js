class Stack
{
    items=[];
    top = -1;

    push(item) {
        this.items[++this.top] = item;
    }
    pop()
    {
        return this.top === -1? null : this.items[this.top--];
    }
}
let stack1 = new Stack();
stack1.push(1);
stack1.push(2);
let stack1 ={
    items:[],
    top:0,
}

function push(stack, item){
    stack.items[stack.top] = item;
    stack.top++;
}
function pop(stack){
    if(stack.top === 0)
    {
        return null;
    }
    stack.top--;
    return stack.items[stack.top];
}
push(stack1, 1);
push(stack1, 2);
push(stack1, 3);
console.log(pop(stack1));
//console.log(pop(stack1));
//console.log(pop(stack1));
//console.log(pop(stack1));

stack1.items=[]
push(stack1,100);
console.log(pop(stack1));
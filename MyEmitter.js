class MyEmitter
{
    handlers = {};
    on(event, callback)
    {
        if(this.handlers[event])
        {
            this.handlers[event].push(callback);
        }
        else
        {
            this.handlers[event] = [callback];
        }
    }
    emit(event,data)
    {
        let handlers = this.handlers[event];
        if(handlers)
        {
            for(let handler of handlers)
            {
                handler(data);
            }
        }
    }
}
let emitter = new MyEmitter();
emitter.on('something',(data)=>{
    console.log('Handler 1 ',data);
});
emitter.on('something',(data)=>{
    console.log('Handler 2 ',data);
});
emitter.emit('something',{
    data : "Hello"
});
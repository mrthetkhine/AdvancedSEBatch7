class Car
{
    constructor(engine)
    {
        this.engine = engine;
    }
    start()
    {
        console.log('Car start');
        this.engine.start();
    }
}
let engine = {
    start()
    {
        console.log('Engine start');
    }
}
let car =new Car(engine);
car.start();
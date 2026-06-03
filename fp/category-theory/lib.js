let Functor = (value) => ({
        map : (fn) => Functor(fn(value)),
        valueOf:()=>value
      });

Functor.of = Functor;
let MayBe = (value) => ({
    isEmpty(){
        return value == null || value == undefined;
    },
    map (fn){
        return this.isEmpty() ? MayBe(null) : MayBe(fn(value));
    },
    valueOf:()=>value
});

MayBe.of = MayBe;
let Left = (value) => ({
    map (fn){
        return this;
    },
    matchWith({left,right})
    {
        return left(value);
    },
    valueOf:()=>value,
});

Left.of = Left;
//Right->Success
let Right = (value) => ({
    map (fn){
        return Right.of(fn(value));
    },
    matchWith({left,right})
    {
        return right(value);
    },
    valueOf:()=>value
});

Right.of = Right;
let Applicative = (value) => ({
    map : (fn) => Applicative(fn(value)),
    ap:(another) => another.map(value),
    valueOf:()=>value
});

Applicative.of = Applicative;
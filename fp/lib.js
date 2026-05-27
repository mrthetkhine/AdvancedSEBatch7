function pipe(...fns)
{
    return function(x)
    {
        return fns.reduce((input,fn)=>fn(input),x);
    }
}
function compose(...fns)
{
    return function(x)
    {
        return fns.reduceRight((input,fn)=>fn(input),x);
    }
}
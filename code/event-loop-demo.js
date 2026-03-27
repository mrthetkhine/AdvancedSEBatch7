function delay(ms) {    
    let start = new Date().getTime();
    while ((new Date().getTime() - start) < ms) ;
}

console.log("Start");
setTimeout(() => {  
    console.log('Fired');
},0);
delay(2000);
console.log("Hello World");
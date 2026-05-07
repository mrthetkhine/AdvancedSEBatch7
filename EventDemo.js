const EventEmitter = require('node:events');
const emitter = new EventEmitter();

emitter.on('something', () => {
    console.log('Handler 1');
});
emitter.on('something', () => {
    console.log('Handler 2');
});
emitter.emit('something');
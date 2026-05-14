const MayBe = (value) => ({
  isEmpty:(value)=>  value === null || value === undefined,
  map (fn){
    return this.isEmpty(value)? MayBe(null) : MayBe(fn(value));
  }
});

function toUpper(str)
{
  return str.toUpperCase();
}
function appendLength(str)
{
  return str + `=${str.length}`;
}

console.log('Start');
MayBe(null)
  .map(toUpper)
  .map(appendLength)
  .map(console.log);

let employess ={
  '1':{
    name:'John',
  },
  '2':{
    name:'Jane',
    supervisor:'1'
  },
  '3':{
    name:'Jack',
    supervisor:'2'
  }
}
function getSupervisor(empId){
  let emp = employess[empId];
  if(emp)
  {
    let supervisorId = emp.supervisor;
    if(supervisorId)
    {
      let supervisor = employess[supervisorId];
      if(supervisor)
      {
        return supervisor.name;
      }
    }
  }
}
console.log(getSupervisor('3'));

function getSupervisor2(empId){
  return MayBe(employess[empId])
    .map(emp => emp.supervisor)
    .map(supervisorId => employess[supervisorId])
    .map(supervisor => supervisor.name);
   
}
getSupervisor2('10').map(console.log);
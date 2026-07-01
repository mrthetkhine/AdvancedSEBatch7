
let plays ={
  "hamlet": {"name": "Hamlet", "type": "tragedy"},
  "as-like": {"name": "As You Like It", "type": "comedy"},
  "othello": {"name": "Othello", "type": "tragedy"}
}
let invoices = {
  "customer": "BigCo",
  "performances": [
    {
      "playID": "hamlet",
      "audience": 55
    },
    {
      "playID": "as-like",
      "audience": 35
    },
    {
      "playID": "othello",
      "audience": 40
    }
  ]
};
class Play 
{
    constructor(name, perf) {
      this.name = name;
      this.perf = perf;
    }
    getTotalAmount()
    {

    }
    getVolumeCredit()
    {
      let volumeCredits = 0;
      volumeCredits += Math.max(this.perf.audience - 30, 0);
      return volumeCredits;
    }
    result(thisAmount)
    {
      return ` ${this.name}: ${format(thisAmount/100)} (${this.perf.audience} seats)\n`
    }
}      
class Tragedy extends Play
{
    constructor(name, perf) {
        super(name, perf);
        this.type = "tragedy";
    }
    getTotalAmount()
    {
      //console.log('Tragedy getTotalAmount called perf ',this.perf.audience);
      let thisAmount = 40000;
      if (this.perf.audience > 30) {
        thisAmount += 1000 * (this.perf.audience - 30);
      }
      return thisAmount;
    }
    
}
class Comedy extends Play
{
    constructor(name, perf) {
        super(name, perf);
        this.type = "comedy";
    }
    getTotalAmount()
    {
      let thisAmount = 30000;
      if (this.perf.audience > 20) {
        thisAmount += 10000 + 500 * (this.perf.audience - 20);
      }
      thisAmount += 300 * this.perf.audience;
      return thisAmount;
    }
    getVolumeCredit()
    {
      let volumeCredits = super.getVolumeCredit();
      volumeCredits += Math.floor(this.perf.audience / 5);
      return volumeCredits;
    }
    
}
function createPlay(playID, perf) {
  const play = plays[perf.playID];
  switch (play.type) {
    case "tragedy":
      return new Tragedy(play.name, perf);
    case "comedy":
      return new Comedy(play.name, perf);
    default:
      throw new Error(`unknown type: ${play.type}`);
  }

}


const format = new Intl.NumberFormat("en-US",
        { style: "currency", currency: "USD",
            minimumFractionDigits: 2 }).format;


function statement (invoice, plays) {
    let totalAmount = 0;
    let volumeCredits = 0;
    let result = `Statement for ${invoice.customer}\n`;
    
    for (let perf of invoice.performances) {
        const play = createPlay(perf.playID, perf);
        let thisAmount = play.getTotalAmount();
        totalAmount += thisAmount;
        // add volume credits
        volumeCredits += play.getVolumeCredit();
        // print line for this order
        result += play.result(thisAmount);
        
    }
    result += `Amount owed is ${format(totalAmount/100)}\n`;
    result += `You earned ${volumeCredits} credits\n`;

    return result;
}

let result = statement(invoices, plays);
console.log(result);




var readline = require('readline');
var rl = readline.createInterface(process.stdin, process.stdout);

var chall = (function() {
    var rv = {};

    function secret(a,b,c){
        if(a === '' && b === '' && c === ''){
            return true;
        }
    }

    function call(code) {
        var line = "";

        if(new RegExp(/[\[\]\.\\\+\-\/;1-8a-zA-Z{}`'"\s]/).test(code)){
            console.log("Unrecognized code.");
            return;
        }

        if(!(code.length == 32)){
            console.log("Incorrect code length.");
            return;
        }

        arguments = undefined;

        ret = null;
        ret = eval("this.secret"+code);

        if(typeof ret == "function"){
            if(ret.call(this,'', '', '') === true){
                console.log("Go To Server Fast!!!");
            }else{
                console.log("Incorrect code.");
            }
        }else{
            console.log("Incorrect code.");
        }
    };
    rv.call = call;
    rv.toString = function(){return rv.call.toString()};

    return rv;
})();

template = `
GKSK chall (*Lagi)

Code: `;

function ask(){
    rl.question(template,function(answer){
        chall.call(answer);
    });
}

ask();
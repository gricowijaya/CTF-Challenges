const secret  = "123"

const responses = {
    reticent: [`Grrr`, `NO FLAG`, `No flag!`, `Нет флага`, `\u{1F47A}`, `ｎｏ　ｆｌａｇ`,  `Ora ana bendera`, `Teu aya bendera`],
    secret: secret 
};

const fetchResponse = (responseType) => {
    return responses[responseType][Math.floor(Math.random() * responses[responseType].length)];
};

const isValid = (str) => {
    if(/[\+\-\/~\[\]\{\}!]+$/.test(str)) {
        // console.log("String is valid")
        return true;
    } 
	return false;
};

const main = (msg) => { 
    let content = msg;

	let response = fetchResponse(`secret`);

	if(content.length > 766 || !isValid(content)) {
		return response;
	}


    console.log(content);
    try {
        content = eval(content);
    } catch(err) {
        content = ``;
    }
	
	if(content === `yes Flag`) {
		response = fetchResponse(`secret`);
	}
	
    console.log(`answer : ${response}`);
}



// console.log(slice("+$yes Flag"));

main("{}yes Flag");
// main();
// console.log(isValid("+"));
//



var keyList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
var temp = "";

function idCheck() {
  let idInput = document.querySelector("#idInput");
  let idCorrect = document.querySelector("#idCorrect");
  // Enter ID
  let idExp = /^[0-9a-zA-Z_]{2,11}$/;
  if (idInput.value === "") {
    idCorrect.innerHTML = "ID cannot be blank";
    return false;
  } else if (idInput.value.match(idExp)) {
    idCorrect.innerHTML = "ID doesn't meet the conditions.";
    return false;
  } else {
    idCorrect.innerHTML = "Collect";
    return true;
  }
}
function pwCheck() {
  let pwInput = document.querySelector("#pwInput");
  let pwCorrect = document.querySelector("#pwCorrect");
  let pwExp = /^.*(?=^.{6,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
  if (pwInput.value === "") {
    pwCorrect.innerHTML = "PW cannot be blank.";
    return false;
  } else if (pwInput.value.match(pwExp)) {
    pwCorrect.innerHTML = " PW doesn't meet the conditions"
    return false;
  } else {
    pwCorrect.innerHTML = "Collect"
    return true;

  }
}
function pwCheck2() {
  let pwInput = document.querySelector("#pwInput");
  let pwInput2 = document.querySelector("#pw2Input");
  let pwCorrect2 = document.querySelector("#pwCorrect2");
  if (pwInput.value === pwInput2.value) {
    pwCorrect2.innerHTML = "Collect"
    return true;
  } else {
    pwCorrect2.innerHTML = "Password doesn't not match."
    return false;

  }
}
function nameCheck() {
  let nameInput = document.querySelector("#nameInput");
  let nameCorrect = document.querySelector("#nameCorrect");
  let nameExp = /^[가-힣]{2,12}$/;//한글만 입력
  if (nameInput.value.match(nameExp)) {
    nameCorrect.innerHTML = " Please type at least 2 characters in Korean."
    return false;
  } else if (nameInput.value === "") {
    nameCorrect.innerHTML = "The name cannot be blank.";
    return false;

  } else {
    nameCorrect.innerHTML = "Collect"
    return true;
  }
}
function nickCheck() {
  let nickInput = document.querySelector("#nickInput");
  let nickCorrect = document.querySelector("#nickCorrect");
  let nickExp = /^[가-힣0-9\x20]{2,12}|[a-zA-Z0-9\x20]{4,12}$/;

  if (!$nickInput.value.match(nickExp)) {
    nickCorrect.innerHTML = "It is not a valid name format.."
    return false;
  } else if (nickInput.value === "") {
    nickCorrect.innerHTML = "The name cannot be blank.";
    return false;

  } else {
    nickCorrect.innerHTML = "Collect"
    return true;
  }
}
function emailCheck() {
  let emailInput = document.querySelector("#emailInput");
  let emailCorrect = document.querySelector("#emailCorrect");
  let emailExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
  if (emailInput.value.match(emailExp)) {
    emailCorrect.innerHTML = "It is not a valid mail format.."
    return false;

  } else if (emailInput.value === "") {
    emailCorrect.innerHTML = "The E-mail cannot be blank.";
    return false;
  } else {
    emailCorrect.innerHTML = "Collect"
    return true;

  }
}
function telCheck() {
  let telInput = document.querySelector("#telInput");
  let telCorrect = document.querySelector("#telCorrect");
  let telExp = /^[0-9]{9,10}$/;
  if (telInput.value.match(telExp)) {
    telCorrect.innerHTML = "Please just enter the numbers."
    return false;

  } else if (telInput.value === "") {
    telCorrect.innerHTML = "The telnum cannot be blank.";
    return false;
  } else {
    telCorrect.innerHTML = "Collect"
    return true;
  }
}
function phoneCheck() {
  let phoneInput = document.querySelector("#phoneInput");
  let phoneCorrect = document.querySelector("#phoneCorrect");
  let phoneExp = /^[0-9]{10,11}$/;
  if (phoneInput.value.match(phoneExp)) {
    phoneCorrect.innerHTML = "Please just enter the numbers."
    return false;

  } else if (phoneInput.value === "") {
    phoneCorrect.innerHTML = "The telnum cannot be blank.";
    return false;
  } else {
    phoneCorrect.innerHTML = "Collect"
    return true;
  }
}
function postCheck() {
  let inputPost = document.querySelector("#inputPost");
  let postCorrect = document.querySelector("#postCorrect");
  postExp = /^\d{3}-?\d{3}$/u;
  if (inputPost.value.match(postExp)) {
    postCorrect.innerHTML = "The postcode is out of form."
    return false;

  } else if (inputPost.value === "") {
    postCorrect.innerHTML = "The post cannot be blank.";
    return false;
  } else {
    postCorrect.innerHTML = "Collect"
    return true;
  }
}

function addressCheck() {
  let inputAddress = document.querySelector("#inputAddress");
  let addressCorrect = document.querySelector("#addressCorrect");
  if (inputAddress.value === "") {
    addressCorrect.innerHTML = " The address cannot be blank.";
    return false;
  } else {
    addressCorrect.innerHTML = "Collect"
    return true;
  }
}

function makeCode(plength) {
  temp = "";
  for (i = 0; i < plength; i++)
    temp += keyList.charAt(Math.floor(Math.random() * keyList.length));
  return temp;
}



function charCheck() {
  let codeCorrect = document.querySelector("#codeCorrect");
  let inputCode = document.querySelector("#inputCode");
  if (temp === inputCode.value) {
    codeCorrect.innerHTML = "Collect.";
    return true;
  } else if (codeCorrect.value === "") {
    codeCorrect.innerHTML = "Please enter automatic registration text prevention.";
  } else {
    codeCorrect.innerHTML = "Failed. Please type it again.";
    return false;
  }
}

function signinDone(event) {
  event.preventDefault()

  if (idCheck() && nameCheck() && phoneCheck() && emailCheck() && pwCheck() && pwCheck2()
    && telCheck() && postCheck() && addressCheck() ) {
      const idInput = document.querySelector("#idInput");
      const pwInput = document.querySelector("#pwInput");
      const nameInput = document.querySelector("#nameInput");
      const nickInput = document.querySelector("#nickInput");
      const emailInput = document.querySelector("#emailInput");
      const tellInput = document.querySelector("#tellInput");
    
      let message = `1. ID: ${idInput.value}`;
      message += `2. PW: ${pwInput.value}`;
      message += `3. NAME: ${nameInput.value}`;
      message += `4. NICK: ${nickInput.value}`;
      message += `5. EMAIL: ${emailInput.value}`;
      message += `6. TELL: ${tellInput.value}`;
      alert(message);
   
  } else {
    alert("Failed. Please type it again");
    event.preventDefault();
  }
};




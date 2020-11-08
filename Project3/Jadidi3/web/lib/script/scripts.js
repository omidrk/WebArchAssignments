/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var mockData = [
    {"id": 0,"article": "messy has some issues"},
    {"id": 1,"article": "messy has some issues2"},
    {"id": 2,"article": "messy has some issues3"}
];


if (window.XMLHttpRequest) {
   // code for modern browsers
   var xhttp = new XMLHttpRequest();
 } else {
   // code for old IE browsers
   var xhttp = new ActiveXObject("Microsoft.XMLHTTP");
}


//when open the index.jsp page this will get the initial data from main servlet
function initData2(){
    xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
//      document.getElementById("demo").innerHTML =
      console.log(this.responseText);
      let json = JSON.parse(this.responseText);
      console.log(json);
      temp = window.document.getElementById("cards");
      for(let i in json){
          var divv = window.document.createElement("div");
          divv.innerHTML = '<div class="w3-panel w3-card-4 getID" id="'+i+'"><p>'+json[i]+'</p></div>';
          temp.appendChild(divv);
      };
    }
  };
  xhttp.open("GET", "index", true);
  xhttp.send();
    
    
}


//when open admin page first this will get initial data from mainservlet
function initDataAdmin(){
    xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
//      document.getElementById("demo").innerHTML =
      console.log(this.responseText);
      let json = JSON.parse(this.responseText);
      console.log(json);
      temp = window.document.getElementById("Table");
      for(let i in json){
          let row = window.document.createElement("tr");
          row.innerHTML = '<td>'+json[i]+'</td>'+'<td>'+i+'</td>'+'<button type="button" class="btnnDel" onclick="delNews()" >Del</button>';
          temp.appendChild(row);
      };
    }
  };
  xhttp.open("GET", "index", true);
  xhttp.send();
    
    
}

// on admin page when add news button is hited it will prompt and ask for news 
//and send post req to admin servlet
function addNews(){
  var news = prompt("Please enter news here", "");
  console.log(news);
  if (news != null && news != "") {
      var row = window.document.createElement("tr");
      let temp = window.document.getElementById("Table");
      let dell = window.document.getElementById("err");
      console.log(temp);
//      row.innerHTML = '<td>'+news+'</td>'+'<td>'+5+'</td>'+'<button type="button" class="btnnDel" onclick="delNews()" >Del</button>';
//      temp.appendChild(row);
//      console.log(news);
      if(dell != null || dell!= undefined){dell.remove();}
      
      xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
        //      document.getElementById("demo").innerHTML =
              console.log(this.responseText);
              try {
                  var json = JSON.parse(this.responseText);
              } catch(error){
                  let divv = window.document.createElement("div");
                  divv.innerHTML = "<p id='err' style='color: red;' >"+this.responseText+"</p>";
                  temp.appendChild(divv);
              }
              
//              console.log(json);
//              temp = window.document.getElementById("Table");
              for(let i in json){
                  let row = window.document.createElement("tr");
                  row.innerHTML = '<td>'+json[i]+'</td>'+'<td>'+i+'</td>'+'<button type="button" class="btnnDel" onclick="delNews()" >Del</button>';
                  temp.appendChild(row);
              };
            }else if(this.readyState == 4 && this.status != 200){
                let temp = window.document.getElementById("error");
                    let divv = window.document.createElement("div");
                    divv.innerHTML = "<p id='err' style='color: red;' >Server Error</p>";
                    temp.appendChild(divv);
            }
          };
          xhttp.open("POST", "admin", true);
          xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          xhttp.send("news="+news);
      
  }else{
      let temp = window.document.getElementById("error");
      let divv = window.document.createElement("div");
      divv.innerHTML = "<p id='err' style='color: red;' >Value of News Cant be empty</p>";
      temp.appendChild(divv);
  }
    
}

//del function not working
function delNews(){
  var news = prompt("Please id here", "");
//  if (news != null) {
//      var row = window.document.createElement("tr");
//      let temp = window.document.getElementById("Table");
//      console.log(temp);
//      row.innerHTML = '<td>'+news+'</td>'+'<td>'+5+'</td>'+'<button type="button" class="btnnDel" onclick="delNews()" >Del</button>';
//      temp.appendChild(row);
//      console.log(news);
//  }
    
}


// starting interval to get the data from mainservlet. It will send id as get param 
// and also search for the last id number in index.jsp page
function StartInterval(obj){
    
    let temp = window.document.getElementById("cards");
    
    setInterval(function(){
        let temp = window.document.getElementsByClassName("getID");
        let z = "0";
        let tempid = temp[temp.length -1].getAttribute("id");
        console.log(temp);
        xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {

          let json = JSON.parse(this.responseText);
          console.log(json);
          temp = window.document.getElementById("cards");
          for(let i in json){
              var divv = window.document.createElement("div");
              divv.innerHTML = '<div class="w3-panel w3-card-4 getID" id="'+i+'"><p>'+json[i]+'</p></div>';
              temp.appendChild(divv);
          };
        }
      };
      xhttp.open("GET", "index?id="+tempid, true);
      xhttp.send();
       
 }, 15000);
    
    
    

}

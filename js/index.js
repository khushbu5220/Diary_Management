let request = new XMLHttpRequest();
request.open("GET", "http://localhost:8080/getEmployeePositions");
request.setRequestHeader('Authorization', 'Bearer '+sessionStorage.getItem("token"));
request.setRequestHeader('Access-Control-Allow-Origin', "*");
request.send();
request.onload = () =>
{
    console.log(request);
    if(request.status == 200)
    {
        const jsonData = JSON.parse(request.response);
        console.log(jsonData);
        const designationData = jsonData.designation;
        
        var text1 = "<option value='' selected>-- Select --</option>";
        for(let i =0; i<designationData.length; i++)
        {
            text1+="<option value='"+designationData[i].designation+"'>"+designationData[i].designation+"</option>";
        }
        // console.log("text1 :"+text1)
        document.getElementById("recievedFrom").innerHTML = text1;
        document.getElementById("designationdd").innerHTML = text1;

        const divisionData = jsonData.division;
        var text2 = "<option value='' selected>-- Select --</option>";
        for(let i =0; i<divisionData.length; i++)
        {
            text2+="<option value='"+divisionData[i].division+"'>"+divisionData[i].division+"</option>";
        }
        // console.log("text2 :"+text2)
        document.getElementById("divisiondd").innerHTML = text2;
    }
    else
    {
        window.location = "loginpage.html"
    }
}


function logout()
{
    console.log("--------------------");
    sessionStorage.clear();
    window.location = "loginpage.html"
}   


let request1 = new XMLHttpRequest();
request1.open("GET", "http://localhost:8080/getNavOptions");
request1.setRequestHeader('Authorization', 'Bearer '+sessionStorage.getItem("token"));
request1.setRequestHeader('Access-Control-Allow-Origin', "*");
request1.send();
request1.onload = () =>
{
    console.log(request1);
    if(request1.status == 200)
    {
        const jsonData = JSON.parse(request1.response);
        console.log(jsonData);
        var text = "";
        for(let i = 0; i < jsonData.length; i++)
        {
            text += "<li class='menu-1'><a href='"+jsonData[i].parent.headerurl+"'>"+jsonData[i].parent.headername+"</a>"
            const childData = jsonData[i].child;
            if(childData.length != 0)
            {
                var textChild = "<ul class='dropdown-1'>";
                for(let j = 0; j < childData.length; j++)
                {
                    textChild += "<li><a href='"+childData[j].headerurl+"'>"+childData[j].headername+"</a></li>";
                }
                textChild +="</ul>";
                text += textChild;
            }
            text+= "</li>"
        }
        text +="<li class='menu-1'><a href='#'>"+jsonData[0].username+"</a><ul class='dropdown-1'>"
          +"<li><a href='changePassword.html'>Change Password</a></li>"
          +"<li><a onclick='logout()' style='color: white;'>Logout</a></li></ul></li> "
        console.log(text);
        document.getElementById("navbar").innerHTML = text;
    }
    else
    {
        console.error();
        // window.location = "loginpage.html"
    }
}


// window.onbeforeunload = function (e)
// {
//     window.onunload = function () 
//     {
//         window.localStorage.isMySessionActive = "false";
//     }
//     return undefined;
// };

// window.onload = function ()
// {
//     window.localStorage.isMySessionActive = "true";
// };

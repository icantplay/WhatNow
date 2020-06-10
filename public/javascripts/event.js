 function showEvents()  {

    var userId = localStorage.getItem("userId");
    var eventsCard = document.getElementById("events");
    $.ajax({
        url: "/EventbyContact/" +userId,
        method: "get",
        success: function (result, status) {
            var events = "";
            console.log(result);
            for (i in result.data) {
                
                    
                
                
                
                events += "<div class='item'>";
                events += "<p>"+result.data[i].Name +"</p>";
                events += "<p>" +result.data[i].Description +"</p>"
                events += "<a href='#'> Detalhes </a>"
                events += "</div>"  
                
                
            }
            eventsCard.innerHTML =events;

        },
        error: function () {
            console.log("erro");
        }


    })

}
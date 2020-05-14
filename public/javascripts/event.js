 function showEvents()  {
    
    var eventsCard = document.getElementById("events");
    $.ajax({
        url: "/EventInfo",
        method: "get",
        success: function (result, status) {
            var events = "";
            console.log(result);
            for (i in result) {
                
                events += "<div class='item'>";
                events += "<p>"+result[i].Name +"</p>";
                events += "<p>" +result[i].Description +"</p>"
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
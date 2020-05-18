 function showSpots()  {
    
    var spotsCard = document.getElementById("events");
    $.ajax({
        url: "/SpotInfo",
        method: "get",
        success: function (result, status) {
            var spots = "";
            console.log(result);
            for (i in result.data) {
                
                spots += "<div class='item'>";
                spots += "<p>"+result.data[i].Name +"</p>";
                spots += "<p>" +result.data[i].Description +"</p>"
                spots += "<a href='#'> Detalhes </a>"
                spots += "</div>"  
                

            }
            spotsCard.innerHTML =spots;

        },
        error: function () {
            console.log("erro");
        }


    })

}
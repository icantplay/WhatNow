function login(){
    var email = document.getElementById("email").value;
   
$.ajax({
    
    url:"/Admin",
    method: "get",
    success: function(result,status) {
        for ( i in result.data){
            
            if(email == result.data[i].Mail){
                alert("Login sucess!")
                window.location = "MainPage.html"
                
            
            }
         }
        
    },
    error: function() {
        alert("Your Username or Password is incorrect");
    }

})
}
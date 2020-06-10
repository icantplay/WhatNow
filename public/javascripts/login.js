function login(){
    var email = document.getElementById("email").value;
   
$.ajax({
    
    url:"/Username",
    method: "get",
    success: function(result,status) {
        for ( i in result.data){
            
            if(email == result.data[i].Name){
                alert("Login sucess!")
                localStorage.setItem("userId",result.data[i].id);
                console.log(localStorage.getItem("userId"));
                window.location = "MainPage.html"
                
            
            }
         }
        
    },
    error: function() {
        alert("Your Username or Password is incorrect");
    }

})
}
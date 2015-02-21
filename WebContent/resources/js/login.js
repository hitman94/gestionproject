/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
	
	
	
	$("#submitConnexion").click(function() {
		var name = document.getElementById("inputName").value;
		var pass = document.getElementById("inputPassword").value;
        
        $.ajax({
        type: 'POST',
        url: "ConnectionServlet",
        data: { username : name, password:pass},
        success: function (data) {
        	window.location.replace("home.jsp");        	
        },
        error: function (data){
        	$("#inputName").tooltip('show');
        }
        
         });
	} );

    
    
    
});


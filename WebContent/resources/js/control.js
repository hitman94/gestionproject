/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
	
	$("#deconnectSubmit").click(function() {
		 $.ajax({
		        type: 'POST',
		        url: "DeconnectionServlet",
		        success: function (data) {
		        	window.location.replace("index.jsp");        	
		        },
		        error: function (data){
		        	window.location.replace("index.jsp");      
		        }
		        
		         });
		
	});
	
    
    
    
});


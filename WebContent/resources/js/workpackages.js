/**
 * 
 */

$(document).ready(function() {
	$('#errorsZone').hide();
	
	$("#submitWP").click(function() {
		var idWorkSpace=document.getElementById("entrepriseWP").value;
		var nameWP = document.getElementById("nameWP").value;
		
		
		$.ajax({
	        type: 'POST',
	        url: "CreateWorkPackageServlet",
	        data: { nameWP : nameWP, idWorkSpace:idWorkSpace},
	        success: function (data) {
	        	window.location.replace("workPackages.jsp");
	        },
	        error: function (data , status, error){
	        	$('#errorsZone').html("Erreur lors de la creation du workpackage.</br>" + error);
	        	$('#errorsZone').show(500);
	        }
	        
	         });
		
		
	});
});
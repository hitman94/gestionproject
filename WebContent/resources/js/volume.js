/**
 * 
 */

$(document).ready(function() {
	$('#errorsZone').hide();
	
	$("#submitCompany").click(function() {
		var wp=document.getElementById("wp").value;
		var volumeName = document.getElementById("volumeName").value;
		
		
		$.ajax({
	        type: 'POST',
	        url: "createcompanyservlet",
	        data: { title : volumeName,idWorkPackage:wp},
	        success: function (data) {
	        	window.location.replace("volume.jsp");
	        },
	        error: function (data , status, error){
	        	$('#errorsZone').html("Erreur lors de la creation de l'entreprise.</br>" + error);
	        	$('#errorsZone').show(500);
	        }
	        
	         });
		
		
	});
});
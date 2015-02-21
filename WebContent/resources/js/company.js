/**
 * 
 */

$(document).ready(function() {
	$('#errorsZone').hide();
	
	$("#submitCompany").click(function() {
		var idChief=document.getElementById("chefC").value;
		var companyName = document.getElementById("companyName").value;
		
		
		$.ajax({
	        type: 'POST',
	        url: "CreateCompanyServlet",
	        data: { companyName : companyName, idChief:idChief},
	        success: function (data) {
	        	window.location.replace("company.jsp");
	        },
	        error: function (data){
	        	$('#errorsZone').html("Erreur lors de la creation de l'entreprise.");
	        	$('#errorsZone').show(500);
	        }
	        
	         });
		
		
	});
});
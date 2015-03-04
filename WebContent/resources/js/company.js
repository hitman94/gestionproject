function deleteEntreprise(id) {

	$.ajax({
		type : 'POST',
		url : "DeleteEntrepriseServlet",
		data : {
			idEntreprise : id
		},
		success : function(data) {
			window.location.replace("companies.jsp");
		},
		error : function(data, status, error) {
			$('#errorsZone').html(
					"Erreur lors de la suppression du chapitre.</br>" + error);
			$('#errorsZone').show(500);
		}

	});
}

function updateChiefEntreprise(id) {
	var idChief = document.getElementById("newChief").value;
	$.ajax({
		type : 'POST',
		url : "UpdateEntrepriseServlet",
		data : {
			idEntreprise : id,
			idChief : idChief
		},
		success : function(data) {
			window.location.replace("companies.jsp");
		},
		error : function(data, status, error) {
			$('#errorsZone').html(
					"Erreur lors de la mise à jour  du chef.</br>" + error);
			$('#errorsZone').show(500);
		}

	});
}

function hideDiv(){
	var div = document.getElementById("changeChiefDiv");
	div.setAttribute("style", "display: none;");
}

$(document).ready(
		function() {
			$('#changeChiefLink').on('click', function() {
				$("#changeChiefDiv").css("display", "");
			});

			$('#errorsZone').hide();

			$("#submitCompany").click(
					function() {
						var idChief = document.getElementById("chefC").value;
						var companyName = document
								.getElementById("companyName").value;

						$.ajax({
							type : 'POST',
							url : "CreateCompanyServlet",
							data : {
								companyName : companyName,
								idChief : idChief
							},
							success : function(data) {
								window.location.replace("companies.jsp");
							},
							error : function(data, status, error) {
								$('#errorsZone').html(
										"Erreur lors de la creation de l'entreprise.</br>"
												+ error);
								$('#errorsZone').show(500);
							}

						});

					});
		});
function deleteUser(id) {

	$.ajax({
		type : 'POST',
		url : "RemoveUserServlet",
		data : {
			id : id
		},
		success : function(data) {
			window.location.replace("registerForm.jsp");
		},
		error : function(data, status, error) {
			$('#errorsZone').html(
					"Erreur lors de la suppression de l'utilisateur : </br>" + error);
			$('#errorsZone').show(500);
		}

	});
}

$('document').ready(function() {

	$('#username').on('click', function() {
		$("#infoZone").css("display", "none");
	});
	$("#submit").click(function() {
		var name = $('#username').val();
		var pass = $('#password').val();

		$.ajax({
			type : 'POST',
			url : "CreateUserServlet",
			data : {
				username : name,
				password : pass
			},
			success : function(data) {

				window.location.replace("registerForm.jsp")

			},
			error : function(data, status, error) {
				$("#infoZone").addClass("alert alert-danger");
				$("#infoZone").html("<p>" + error + " </p>");
				$("#infoZone").css("display", "");
				$("#infoZone").show(500);
			}
		});
	});

});
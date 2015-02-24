$('document').ready(
		function() {

			$('#username').on('click', function() {
				$("#infoZone").css("display", "none");
			});
			$("#submit").click(
					function() {
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

								$("#infoZone").addClass("alert alert-info");

								$("#infoZone").html(
										"<p> L'utilisateur " + name
												+ " a été crée</p>");
								$("#infoZone").css("display", "");
								setTimeout(function() {
									window.location.replace("registerForm.jsp")
								}, 3000);

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
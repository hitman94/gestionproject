/**
 * 
 */
function supprimerVolume(idVolume) {
	alert(idVolume);
	$.ajax({
		type: 'POST',
		url: "DeleteVolumeServlet",
		data: { idVolume : idVolume},
		success: function (data) {
			window.location.replace("volume.jsp");
		},
		error: function ( error){
			$('#errorsZone').html("Erreur lors de la suppression de l'entreprise.</br>" + error);
			$('#errorsZone').show(500);
		}

	});


}
$(document).ready(function() {
	$('#errorsZone').hide();

	$("#submitwp").click(function() {
		var wp=document.getElementById("wp").value;
		var volumeName = document.getElementById("volumeName").value;


		$.ajax({
			type: 'POST',
			url: "CreateVolumeServlet",
			data: { title : volumeName,idWorkPackage:wp},
			success: function (data) {
				window.location.replace("volume.jsp");
			},
			error: function (data , status, error){
				$('#errorsZone').html("Erreur lors de la creation du volume.</br>" + error);
				$('#errorsZone').show(500);
			}

		});


	});
});
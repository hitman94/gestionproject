/**
 * 
 */

var activeWp = null;

function showChapters(id) {

	$('#' + id).css("display", "");
	if (activeWp != null && activeWp != id)
		$('#' + activeWp).css("display", "none");

	activeWp = id;
}

function downloadChapter(chapterId) {
	$.ajax({
		type : 'POST',
		url : "DownloadFileServlet",
		data : {
			chapterId : chapterId
		},
		success : function(data, status, xhr) {
			window.location.replace(xhr.getResponseHeader("url"));
		},
		error : function(data, status, error) {

		}

	});
}

function promoteChapter(chapterId, validate) {
	$.ajax({
		type : 'POST',
		url : "PromoteChapterServlet",
		data : {
			chapterId : chapterId,
			validate : validate
		},
		success : function(data, status, xhr) {
			if (validate == "ok")
				alert("Chapitre promu");
			else
				alert("Chapitre non promu");
			window.location.replace("chapters.jsp");
		},
		error : function(data, status, error) {
			window.location.replace("chapters.jsp");
		}

	});
}
$(document)
		.ready(
				function() {
					$('#errorsZone').hide();

					$("#submitCompany")
							.click(
									function() {
										var idChief = document
												.getElementById("chefC").value;
										var companyName = document
												.getElementById("companyName").value;

										$
												.ajax({
													type : 'POST',
													url : "CreateCompanyServlet",
													data : {
														companyName : companyName,
														idChief : idChief
													},
													success : function(data) {
														window.location
																.replace("companies.jsp");
													},
													error : function(data,
															status, error) {
														$('#errorsZone')
																.html(
																		"Erreur lors de la creation de l'entreprise.</br>"
																				+ error);
														$('#errorsZone').show(
																500);
													}

												});

									});

					$("#frameUpload")
							.load(
									function() {
										var responseText = $('#frameUpload')
												.contents().find('#answer')
												.html();
										if (!responseText) {
											return;
										} else if (responseText == "ok") {
											alert("Chapitre remis");
											window.location
													.replace("chapters.jsp");
										} else {
											$("#errorsZone").show(500);
											$("#errorsZone")
													.html(
															"<span class=\"glyphicon glyphicon-exclamation-sign\" aria-hidden=\"true\"></span>Erreur lors de l'envoi du chapitre.<br/>");
										}
									});

					$("#submitChapter")
							.click(
									function() {
										var title = document
												.getElementById("chapterName").value;
										var idWp = document
												.getElementById("idWp").value;
										var idVol = document
												.getElementById("idVol").value;
										var numberInVolume = document
										.getElementById("numberInVol").value;

										$
												.ajax({
													type : 'POST',
													url : "CreateChapterServlet",
													data : {
														title : title,
														wpId : idWp,
														idVolume : idVol,
														numberInVolume: numberInVolume
													},
													success : function(data) {
														window.location
																.replace("chapters.jsp");
													},
													error : function(data,
															status, error) {
							
														$('#errorsZone')
																.html(
																		"Erreur lors de la creation du chapitre.</br>"
																				+ error);
														$('#errorsZone').show(
																500);
													}

												});

									});
				});
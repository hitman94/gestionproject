
window.onload = function() {
	var ctx = document.getElementById("chapterChart").getContext("2d");
	var nbChapterCompany = document.getElementById("nbChapterCompany").value;
	var nbChapterTotal = document.getElementById("nbChapterTotal").value;

	window.myDoughnut = new Chart(ctx).Doughnut([
	                                             {
	                                            	 value: 5,
	                                            	 color: "#46BFBD",
	                                            	 highlight: "#5AD3D1",
	                                            	 label: "Chapitres de l'entreprise"
	                                             },
	                                             {
	                                            	 value: 12,
	                                            	 color: "#FDB45C",
	                                            	 highlight: "#FFC870",
	                                            	 label: "Autres chapitres"
	                                             }
	                                             ], {responsive: true});
}
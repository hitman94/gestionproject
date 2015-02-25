
window.onload = function() {
	var ctx = document.getElementById("chapterChart").getContext("2d");
	var nbChapterUser = document.getElementById("nbChapterUser").value;
	var nbChapterCompany = document.getElementById("nbChapterCompany").value;
	var nbChapterTotal = document.getElementById("nbChapterTotal").value;
	
	alert(nbChapterUser);

	window.myDoughnut = new Chart(ctx).Doughnut([
	                                        {
	                                        	value: 2,
	                                        	color:"#F7464A",
	                                        	highlight: "#FF5A5E",
	                                        	label: "Vos chapitres"
	                                        },
	                                        {
	                                        	value: 2,
	                                        	color: "#46BFBD",
	                                        	highlight: "#5AD3D1",
	                                        	label: "Chapitres de l'entreprise"
	                                        },
	                                        {
	                                        	value: 2,
	                                        	color: "#FDB45C",
	                                        	highlight: "#FFC870",
	                                        	label: "Tous les chapitres"
	                                        }
	                                        ], {responsive: true});
	
}

window.onload = function() {
	var ctx = document.getElementById("chapterChart").getContext("2d");
	var companyName = document.getElementById("companyName").value;
	var nbChapterCompany = document.getElementById("nbChapterCompany").value;
	var nbOtherChapter = document.getElementById("nbOtherChapter").value;
	var nbChapterTotal = document.getElementById("nbChapterTotal").value;

	window.myBar = new Chart(ctx).Bar({
		labels : [ companyName, "Autres chapitres", "Tous les chapitres" ],
		datasets : [
		            {
		            	fillColor : "rgba(65,157,252,0.5)",
		            	strokeColor : "rgba(65,157,252,0.8)",
		            	highlightFill : "rgba(65,157,252,0.75)",
		            	highlightStroke : "rgba(65,157,252,1)",
		            	data : [ nbChapterCompany, nbOtherChapter, nbChapterTotal ]
		            } 
		            ]
	}, {responsive : true});
}
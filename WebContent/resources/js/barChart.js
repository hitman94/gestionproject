
window.onload = function() {
	var ctx = document.getElementById("wpChart").getContext("2d");
	var nbStart = document.getElementById("nbStart").value;
	var nbCreate = document.getElementById("nbCreate").value;
	var nbInProgress = document.getElementById("nbInProgress").value;
	var nbDone = document.getElementById("nbDone").value;

	window.myBar = new Chart(ctx).Bar({
		labels : [ "Create", "Start", "In Progress", "Done" ],
		datasets : [
		            {
		            	fillColor : "rgba(65,157,252,0.5)",
		            	strokeColor : "rgba(65,157,252,0.8)",
		            	highlightFill : "rgba(65,157,252,0.75)",
		            	highlightStroke : "rgba(65,157,252,1)",
		            	data : [ nbCreate, nbStart, nbInProgress, nbDone ]
		            } 
		            ]
	}, {responsive : true});
}
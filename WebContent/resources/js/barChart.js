
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
	
	myBar.datasets[0].bars[0].fillColor = "rgba(216, 0, 0, 0.5)";
	myBar.datasets[0].bars[0].strokeColor = "rgba(216, 0, 0, 0.8)";
	myBar.datasets[0].bars[0].highlightFill = "rgba(216, 0, 0, 0.75)";
	myBar.datasets[0].bars[0].highlightStroke = "rgba(216, 0, 0, 1)";
	
	myBar.datasets[0].bars[1].fillColor = "rgba(255, 165, 0, 0.5)";
	myBar.datasets[0].bars[1].strokeColor = "rgba(255, 165, 0, 0.8)";
	myBar.datasets[0].bars[1].highlightFill = "rgba(255, 165, 0, 0.75)";
	myBar.datasets[0].bars[1].highlightStroke = "rgba(255, 165, 0, 1)";
	
	myBar.datasets[0].bars[3].fillColor = "rgba(50, 205, 50, 0.5)";
	myBar.datasets[0].bars[3].strokeColor = "rgba(50, 205, 50, 0.8)";
	myBar.datasets[0].bars[3].highlightFill = "rgba(50, 205, 50, 0.75)";
	myBar.datasets[0].bars[3].highlightStroke = "rgba(50, 205, 50, 1)";
    myBar.update();
}
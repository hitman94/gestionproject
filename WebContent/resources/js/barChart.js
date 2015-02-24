
var barChartData = {
		labels : [ "Start", "Create", "In Progress", "Done" ],
		datasets : [
		            {
		            	fillColor : "rgba(220,220,220,0.5)",
		            	strokeColor : "rgba(220,220,220,0.8)",
		            	highlightFill : "rgba(220,220,220,0.75)",
		            	highlightStroke : "rgba(220,220,220,1)",
		            	data : [ 1, 2, 3, 4 ]
		            } 
		            ]
}

window.onload = function() {
	var ctx = document.getElementById("wpChart").getContext("2d");
	window.myBar = new Chart(ctx).Bar(barChartData, {responsive : true});
}
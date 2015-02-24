/**
 * 
 */


var activeWp=null;

function showChapters(id) {
	$('#'+id).css("display","");
	if(activeWp != null) {
		$('#'+activeWp).css("display","none");
		activeWp=id;
	}
}
function downloadChapter(chapterId) {
	$.ajax({
        type: 'POST',
        url: "DownloadFileServlet",
        data: { chapterId : chapterId},
        success: function (data) {
        	window.location.replace("chapters/"+chapterId+".docx");
        },
        error: function (data , status, error){

        }
        
         });
}
$(document).ready(function() {
	$('#errorsZone').hide();
	
	$("#submitCompany").click(function() {
		var idChief=document.getElementById("chefC").value;
		var companyName = document.getElementById("companyName").value;
		
		
		$.ajax({
	        type: 'POST',
	        url: "CreateCompanyServlet",
	        data: { companyName : companyName, idChief:idChief},
	        success: function (data) {
	        	window.location.replace("companies.jsp");
	        },
	        error: function (data , status, error){
	        	$('#errorsZone').html("Erreur lors de la creation de l'entreprise.</br>" + error);
	        	$('#errorsZone').show(500);
	        }
	        
	         });
		
		
	});
	
	$("#submitChapter").click(function() {		
		var title=document.getElementById("chapterName").value;
		var idWp=document.getElementById("idWp").value;
		var idVol = document.getElementById("idVol").value;
		
		
		$.ajax({
	        type: 'POST',
	        url: "CreateChapterServlet",
	        data: { title : title, wpId:idWp, idVolume:idVol},
	        success: function (data) {
	        	window.location.replace("chapters.jsp");
	        },
	        error: function (data , status, error){
	        	$('#errorsZone').html("Erreur lors de la creation du chapitre.</br>" + error);
	        	$('#errorsZone').show(500);
	        }
	        
	         });
		
		
	});
});
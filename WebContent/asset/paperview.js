function viewdata(data)
{ 	h="<table border=1  width=70% cellspacing=5 cellpadding=5>";
     
	
	$.each(data,function(i,item){
	 	h+="<tr><td valign=top>Question"+item.QUESTIONNO+"]</td><td valign=top>1]:"+item.Q1+"<br>2]:"+item.Q2+"<br>3]:"+item.Q3+"</td></tr>";
	 	 
	 
	});	
	h+="</table>";
	$('#questionresult').html(h);
	
}


$(document).ready(function(){
$.getJSON('GetSemesterJSON',{ajax:true,bid:$('#branchid').val()},function(data){
			$('#subjectsemester').empty();
			$('#subjectsemester').append($('<option>').text('-Semester-'));
			for(i=1;i<=data[0].SEMESTER;i++){
				$('#subjectsemester').append($('<option>').text(i));
			}
				
 });

$('#subjectsemester').change(function(){
	$.getJSON('GetAllSubjectJSON',{ajax:true,subjectsemester:$('#subjectsemester').val(),branchid:$('#branchid').val()},function(data){
		$('#subjectid').empty();
		$('#subjectid').append($('<option>').text('-Subject-'));
		$.each(data,function(i,item){
			$('#subjectid').append($('<option>').text(item.SUBJECTNAME).val(item.SUBJECTID));
		
		
		});
});
});	
$('#year').change(function(){
	$.getJSON('GetQuestionPaperJSON',{ajax:true,subjectid:$('#subjectid').val(),year:$('#year').val()},function(data){
		 
		$.each(data,function(i,item){
			 viewdata(data);
		
		
		});
});
});	



});
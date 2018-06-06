$(document).ready(function(){
	$.getJSON('GetAllUniversityJSON',{ajax:true},function(data){
	$.each(data,function(i,item){
		$('#uid').append($('<option>').text(item.UNIVERSITYNAME).val(item.UNIVERSITYID));
	});	
	});
	$('#uid').change(function(){
		$.getJSON('GetAllBranchJSON',{ajax:true,universityid:$('#uid').val()},function(data){
			$('#branchid').empty();
			$('#branchid').append($('<option>').text('-Branch-'));
			$.each(data,function(i,item){
				$('#branchid').append($('<option>').text(item.BRANCHNAME).val(item.BRANCHID));
				
	});
	
});
});
	
	$('#branchid').change(function(){
		$.getJSON('GetSemesterJSON',{ajax:true,bid:$('#branchid').val()},function(data){
			$('#subjectsemester').empty();
			$('#subjectsemester').append($('<option>').text('-Sem-'));
			for(i=1;i<=data[0].SEMESTER;i++){
				$('#subjectsemester').append($('<option>').text(i));
			}
				
 });
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
	
});
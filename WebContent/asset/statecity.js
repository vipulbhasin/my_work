$(document).ready(function(){
	
$.getJSON('GetAllStateJSON',{ajax:true},function(data){
$.each(data,function(i,item){
	$('#ustate').append($('<option>').text(item.STATENAME).val(item.STATEID));
});	
	
});	
	
$('#ustate').change(function(){
	
	$.getJSON('GetAllCitiesJSON',{ajax:true,stateid:$('#ustate').val()},function(data){
		$('#ucity').empty();
		$('#ucity').append($('<option>').text('-City-'));
		$.each(data,function(i,item){
			$('#ucity').append($('<option>').text(item.CITYNAME).val(item.CITYID));
		});	
			
		});		
	
});

});

function viewdata(data)
{ 	h="<table border=1 cellspacing=10 cellpadding=10>";
	c=1;
	
	$.each(data,function(i,item){
		if(c==1)
			{h+="<tr>";}
		h+="<td align='center'>"+item.BRANCHNAME+"<br><img src=images/branch/"+item.BRANCHICON+" width=100 height=100><br><br><input type='button' class='btnpaper' bid='"+item.BRANCHID+"' bname='"+item.BRANCHNAME+"' bicon='"+item.BRANCHICON+"' semester='"+item.SEMESTER+"' value='View Papers'></td>";
		c++;
		if(c==4)
			{c=1;
			h+="</tr>";
			}
	});	
	h+="</table>";
	$('#branchresult').html(h);
	
}

$(document).ready(function(){
	
	$.getJSON('GetAllBranchJSON',{ajax:true,universityid:$('#uid').val()},function(data){
	$.each(data,function(i,item){
			viewdata(data) ;
			
 });
	
 });
$('#branchresult').on('click','.btnpaper',function(){
	window.location='UserPaperView?bid='+$(this).attr('bid')+"&bname="+$(this).attr('bname')+"&semester="+$(this).attr('semester')+"&bicon="+$(this).attr('bicon');
	
});	
	
	
 });
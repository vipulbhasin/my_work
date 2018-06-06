function viewdata(data)
{ 	h="<table border=1 cellspacing=10 cellpadding=10>";
	c=1;
	
	$.each(data,function(i,item){
		if(c==1)
			{h+="<tr>";}
		h+="<td align='center'>"+item.UNIVERSITYNAME+"<br>"+item.UCITY+"<br><img src=images/uni/"+item.LOGO+" width=100 height=100><br><input type='button' class='btnbranch' uid='"+item.UNIVERSITYID+"' uname='"+item.UNIVERSITYNAME+"' ulogo='"+item.LOGO+"' ustate='"+item.USTATE+"' ucity='"+item.UCITY+"' value='View Branches'>&nbsp;<input type='button' class='btnviewmore' un='"+JSON.stringify(item)+"' value='View More..'></td>";
		c++;
		if(c==4)
			{c=1;
			h+="</tr>";
			}
	});	
	h+="</table>";
	$('#result').html(h);
	
}
$(document).ready(function(){
	
 		 $('#udialog').dialog({
				modal:true,
				autoOpen:false,
				title:'University Details',
				width:400
			});		

	
	$.getJSON('GetAllUniversityJSON',{ajax:true},function(data){
 	viewdata(data);
	});
	
$('#txt').keyup(function(){
	
	$.getJSON('DisplayUniverSityByPatternJSON',{ajax:true,pat:$('#txt').val()},function(data){
		 
		 viewdata(data);
		});
	
	
	
	
});	

$('#result').on('click','.btnbranch',function(){
	//alert($(this).attr('uid')+","+$(this).attr('uname'));
 window.location="UserBranchView?uid="+$(this).attr('uid')+"&uname="+$(this).attr('uname')+"&ulogo="+$(this).attr('ulogo')+"&ustate="+$(this).attr('ustate')+"&ucity="+$(this).attr('ucity');	
});

$('#result').on('click','.btnviewmore',function(){
	//alert($(this).attr('uid')+","+$(this).attr('uname'));
  item=$.parseJSON($(this).attr('un'));
  h="<table cellspacing=3 cellpadding=10>";
  h+="<tr><td align=center>"+item.UNIVERSITYNAME+"<br><img src=images/uni/"+item.LOGO+" width=100 height=100></td><td valign=top>Contact Person:"+item.CONTACTPERSON+"<br>EmailId:"+item.EMAIL+"<br>Mobile:"+item.MOBILE+"<br>Address:"+item.ADDRESS+"<br>"+item.UCITY+","+item.USTATE+"</td></tr></table>";
  $('#udialog').html(h);
  $('#udialog').dialog('open');
});

	
	});
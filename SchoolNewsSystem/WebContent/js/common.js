/**
  * JS分页
  *   func 页面调用函数 total 总数 page 当前页 size 每页数量  shows 显示数量(可选默认7) parsent 父级选择器（可选默认空）
  */
 function pagination(func, total, size, page ,parent, shows){
     //console.log("加载分页");
     /*console.log(func, total, size, page);*/
     var shows = shows?shows:5;
     var parent = parent?parent:'';
     var pages = Math.ceil(total / size);
     var start = Math.max(page - shows, 1);
     var end = Math.min(page + shows, pages);
     var data = '';
     //console.log('分页',func);
     // 返回第一页
     if(start > 1){
         data += '<li><a href="javascript:'+func+'(1)">&laquo;</a></li>';
     }
     for(i = start; i <= end; i++){
         if(i == page){
             data += '<li class="active"><a class="curpage">'+i+'</a></li>';
         } else {
             data += '<li><a href="javascript:'+func+'('+i+')">'+i+'</a></li>';
         }
     }
     // 返回最后页
     if(end < pages){
         data += '<li><a href="javascript:'+func+'('+pages+')">&raquo;</a></li>';
     }

     if(pages==1){
         $(parent +' .paging').hide();
         $('.addPageSize,.goToPage').hide();
         // alert('一页');
     }else{
         $(parent +' .paging').show();
         $('.addPageSize,.goToPage').show();
     }
     $(parent +' .paging').html(data);
     // console.log('分页',data);
 }
 
/*
 * 
 * */


 // 获取cookie
 function getCookie(objname){//获取指定名称的cookie的值
     var arrstr = document.cookie.split("; ");
     for(var i = 0;i < arrstr.length;i ++){
         var temp = arrstr[i].split("=");
         if(temp[0] == objname) return unescape(temp[1]);
     }
 }

 // 存储cookie
 function setCookie(name,value){
     var Days = 30;
     var exp = new Date();
     exp.setTime(exp.getTime() + Days*24*60*60*1000);
     document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString() + ";path=/";
 }
 
/*获取当前系统时间*/
	function getTime(){
		var data = new Date();
		var year = data.getFullYear();
		var newMouth = data.getMonth()+1; 
		var day = data.getDate();
		var time = data.getHours()+":"+data.getMinutes()+":"+data.getSeconds();
		return nowTime=year+"-"+newMouth+"-"+day+" "+time
	}
	console.log('当前系统时间',getTime());

/*
 
 * */
/**
  *获取url里的参数 name为 key值 返回value
  *
  */
function GetQueryString(name) {   
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");   
    var r = window.location.search.substr(1).match(reg);   
    if (r != null) return decodeURI(r[2]); return null;   
}  


/*  <nav aria-label="Page navigation" class="text-right">
                <p class="goToPage pull-right" style="margin-top: 10px;">
                    跳至<input type="text">页
                    <span class="jump">跳转</span>
                </p>
                <select class="addPageSize pull-right" style="margin-top: 10px;">
                    <option value="10">10条/页</option>
                    <option value="15">15条/页</option>
                    <option value="20">20条/页</option>
                    <option value="25">25条/页</option>
                    <option value="30">30条/页</option>
                </select>
                <ul class="paging pull-right">

                </ul>


            </nav>*/
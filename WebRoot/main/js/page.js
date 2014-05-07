jQuery.extend({   
  page:function (divId,pagesize){      
            var div=divId;   
            var x="#"+div+" table tr:has(td)"  
            var y="#"+div;   
            var table=$(x);   
            var row=table.length;   
            var pageSize=pagesize;   
            var allPage=parseInt(""+((row+pageSize-1)/pageSize),10);   
            var currentPage=1;   
            $(table).hide();       
            showRow("1");   
            //构建菜单             
            $(y).append("<div id='menu'></div>");   
            $(y).css("width",$("#page table").width()+"px");   
            $("#menu").append("<span id='pre'>\u4e0a\u4e00\u9875</span>");            
            $("#menu").css("float","right");   
            $("#menu").css("padding","10px 10px 10px 10px");   
            for(var i=1;i<=allPage;i++){   
                $("#menu").append("<span id='"+i+"'><b>&nbsp;"+i+"</b></span>");   
                $("span").css("width","20px");   
            }              
            $("#menu").append("<span id='next'>\u4e0b\u4e00\u9875</span>");   
            $("#next").css("width","50px");   
            $("#pre").css("width","50px");             
            //为菜单添加事件                      
            $("span:not(:first,:last)").bind("click",{}, function (){ showRow($(this).attr("id"));});   
            $("span").bind("mouseover",{}, function (){ $(this).css("cursor", "pointer");});   
            $("#pre").bind("click",{}, function (){ showPre();});   
            $("#next").bind("click",{}, function (){ showNext();});   
            function showRow(page){   
                currentPage=page-0;   
                $(table).hide();           
                var first=(currentPage-1)*pageSize;   
                var last=pageSize*currentPage;   
                if(last>row) last=row;   
                for(var i=first;i<last;i++){   
                    table.eq(i).show();   
                }   
                var id="#"+currentPage;   
                var cd="span:not("+id+")";   
                $(cd).css("color","#000000");   
                $(id).css("color","blue");   
            }   
               
            function showPre(){   
                var p;   
                if(currentPage-0==1){   
                    p=1;   
                }   
                else {   
                    p=currentPage-1;   
                }   
                showRow(p);
                   
            }   
               
            function showNext(){   
                var p;   
                if(currentPage==allPage){   
                    p=currentPage;   
                }   
                else {   
                    p=currentPage+1;   
                }   
                showRow(p);   
            }   
            $("#1").css("color","blue");            
}   
                 }   
);  

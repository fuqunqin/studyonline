<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}

.STYLE2 {
	font-size: 9px
}

.STYLE3 {
	color: #033d61;
	font-size: 12px;
}
</style>
	<script type="text/javascript">
		window.onload=function(){
				getDate();
			};
			function getDate(){
			 		var d= new Date();
			 		var month=getValidateDate(d.getMonth()+1);
			 		var day=getValidateDate(d.getDate());
			 		var hour=getValidateDate(d.getHours());
			 		var minute=getValidateDate(d.getMinutes());
			 		var second=getValidateDate(d.getSeconds());
					var str=d.getFullYear()+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;  
				    document.getElementById('curDate').innerHTML='当前时间：'+str;
				    window.setTimeout('getDate()',1000); 
			 	};
		 	function getValidateDate(str){
		 		if(str<10){
			 			return '0'+str;
			 		}
			 	else return str;
		 	};
	</script>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="70" background="../images/main_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="210" height="24" background="../images/main_03.gif">&nbsp;</td>
            <td width="505" background="../images/main_04.gif">&nbsp;</td>
            <td>&nbsp;</td>
            <td width="21"><img src="../images/main_07.gif" width="21" height="24"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="38"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="190" height="38" background="../images/main_09.gif">&nbsp;</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="77%" height="25" valign="bottom"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="19"><div align="center"><img src="../images/main_12.gif" width="49" height="19" onclick="window.parent.frames[1].frames[0].document.all('I2').src='home.jsp'" style="cursor: pointer;"></div></td>
                    <td width="50"><div align="center"><img src="../images/main_14.gif" width="48" height="19" onclick="history.go(-1);" style="cursor: pointer;"></div></td>
                    <td width="50"><div align="center"><img src="../images/main_16.gif" width="48" height="19" onclick="history.go(1);" style="cursor: pointer;"></div></td>
                    <td width="50"><div align="center"><img src="../images/main_18.gif" width="48" height="19" onclick="window.parent.frames[1].frames[0].location=window.parent.frames[1].frames[0].location;" style="cursor: pointer;"></div></td>
                    <td width="50"><div align="center"><a href="${pageContext.request.contextPath }/adminExit.do"><img src="../images/main_20.gif" width="48" height="19" style="cursor: pointer;" border="0"></a></div></td>
                    <td width="26"><div align="center"><img src="../images/main_21.gif" width="26" height="19"></div></td>
                    <td width="100"><div align="center"><img src="../images/main_22.gif" width="98" height="19" onclick="window.parent.frames[1].frames[0].document.all('I2').src='${pageContext.request.contextPath }/admin/selfmanager/querySelf.jsp';" style="cursor: pointer;"></div></td>
                    <td>&nbsp;</td>
                  </tr>
                </table></td>
                <td width="220" valign="bottom"  nowrap="nowrap"><div align="right"><span class="STYLE1"><span class="STYLE2"></span> <div id="curDate"></div></span></div></td>
              </tr>
            </table></td>
            <td width="21"><img src="../images/main_11.gif" width="21" height="38"></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="8" style=" line-height:8px;"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270" background="../images/main_29.gif" style=" line-height:8px;">&nbsp;</td>
            <td width="505" background="../images/main_30.gif" style=" line-height:8px;">&nbsp;</td>
            <td style=" line-height:8px;">&nbsp;</td>
            <td width="21" style=" line-height:8px;"><img src="../images/main_31.gif" width="21" height="8"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="../images/main_36.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="177" height="28" background="../images/main_32.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%"  height="22">&nbsp;</td>
            <td width="59%" valign="bottom"><div align="center" class="STYLE1">当前用户：${admin.loginName}</div></td>
            <td width="21%">&nbsp;</td>
          </tr>
        </table></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="65" height="28"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="23" valign="bottom"></td>
              </tr>
            </table></td>
            <td width="95%">
            <marquee height="17" onMouseOver=this.stop()
				onMouseOut=this.start() scrollamount=3 scrolldelay=100
				direction=left style="color: red; text-align: center;">
				欢迎光临在线学习网络管理平台，请合理使用您相应的权限，祝您工作愉快！
			</marquee></td>
          </tr>
        </table></td>
        <td width="21"><img src="../images/main_37.gif" width="21" height="28"></td>
      </tr>
    </table></td>
  </tr>
</table>
	</body>
</html>

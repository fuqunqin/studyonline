<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">	
  <head>
        <style type="text/css" media="screen"> 
			html, body	{ height:100%; }
			body { margin:0; padding:0; overflow:auto; }   
			#flashContent { display:none; }
        </style> 
		
		<script type="text/javascript" src="js/flexpaper_flash.js"></script>
  </head>
  
  <body>
    <table style="top:10px;">
	        <a id="viewerPlaceHolder" style="width:660px;height:480px;display:block"></a>
	        
	        <script type="text/javascript">
	     		var fp = new FlexPaperViewer(	
						 'FlexPaperViewer',
						 'viewerPlaceHolder', { config : {
						 SwfFile : escape('../swf/<%=(String)request.getParameter("url")%>.swf'),
						 Scale : 0.6, 
						 ZoomTransition : 'easeOut',
						 ZoomTime : 0.5,
						 ZoomInterval : 0.2,
						 FitPageOnLoad : true,
						 FitWidthOnLoad : false,
						 PrintEnabled : false,
						 FullScreenAsMaxWindow : false,
						 ProgressiveLoading : true,
						 MinZoomSize : 0.2,
						 MaxZoomSize : 5,
						 SearchMatchAll : false,
						 InitViewMode : 'Portrait',
						 
						 ViewModeToolsVisible : true,
						 ZoomToolsVisible : true,
						 NavToolsVisible : true,
						 CursorToolsVisible : true,
						 SearchToolsVisible : true,
  						
  						 localeChain: 'zh_CN'
						 }});
	        </script>
       
		</table>
   </body>
</html>

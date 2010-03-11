<%-- 
    Document   : homePage
    Created on : Mar 7, 2010, 12:01:48 AM
    Author     : shastrula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/include.jsp" %>

<html>
    <head>
        <title>Customer Home Page</title>
<script type="text/javascript" src="/CarSales/javascript/jquery-1.4.2.js"></script>
<script type="text/javascript">

var $j = jQuery.noConflict();
$j(document).ready(function(){
    $j('input#searchCars').click( function(){
        var modelType = null;
        var selection = $j('#radModel');
        //alert(selection.length);
        for(k=0;k<selection.length;k++){
            //alert(selection[k].value);
            modelType = selection[k].value;
        }
        alert(modelType);
        if(modelType==null){
            alert('Select a Model');
            return false;
        }

        //alert(selection);
	$j.ajax({
		url: 'jsonSearchCars.htm?model='+modelType,
		type: 'GET',
		dataType: 'text',
		timeout: 1200000,
		error: function(){
			//do nothing
		},success: function(data){
			var models = eval("(" + data + ")");
                        var Html = '<table border=1><tr><td>Make</td><td>Model</td><td>Year</td><td>Color</td></tr>';

                        //alert("model is"+model[0].color);
                        //alert($j('div#results').html());

                        for(i=0;i<models.length;i++){
                            Html += '<tr><td>'+models[i].model.make+'</td><td>'+models[i].model.model+'</td><td>'+models[i].year+'</td><td>'+models[i].color+'</td></tr>';
                        }
                            Html += '</table>'
                        $j('div#results').html(Html);
                        $j('div#results').visibility = 'visible';

		}
	});
     	});

}); 
</script>
    </head>
    <body>
        <h1>Welcome to Cars.com Portal</h1>
        <form id="searchFrm" action="homePage.htm">
        <table align="left" border="1">
            <thead>
                <tr>
                    <td>&nbsp;</td>
                    <td>Make</td>
                    <td>Model</td>
                    <td>Type</td>
                </tr>
            </thead>
            <c:forEach items="${availableCarModels}" var="model" varStatus="row">
            <tr>
                <td><input type="radio" id="radModel" name="radModel" value="${model.model}"></td>
                <td><c:out value="${model.make}"></c:out></td>
                <td><c:out value="${model.model}"></c:out></td>
                <td><c:out value="${model.type}"></c:out></td>
            </tr>
        </c:forEach>
            <tr><td colspan="4"><input id="searchCars" type="button" value="Search"></td></tr>
            <tr><td colspan="4">
                    <div id="results" style="visibility: visible"></div>

                </td></tr>
        </table>
        </form>


    </body>
</html>

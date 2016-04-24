<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${f:url('/css/global.css')}"/>
</head>
<body>

<html:errors/>

<s:form>
<table class="tablebg">
	<tr>
		<td> id </td>
		<td>
		    <html:text property="id" />
		</td>	
	</tr>
	<tr>
		<td> name </td>
		<td>
		    <html:text property="name" />
		</td>	
	</tr>
	<tr>
		<td> memo </td>
		<td>
		    <html:text property="memo" />
		</td>	
	</tr>
	<tr>
		<td> time </td>
		<td>
		    <html:text property="time" />
		</td>	
	</tr>

</table>

<input type="submit" name="update" value="UPDATE" />
</s:form>
<br/><br/>

<s:link href="/board/">list page</s:link>

</body>
</html>
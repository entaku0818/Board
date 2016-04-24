<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${f:url('/css/global.css')}"/>
</head>
<body>

<html:errors/>

<table class="tablebg">
	<tr>
		<td> id </td>
		<td>
			${f:h(id)}
		</td>	
	</tr>
	<tr>
		<td> name </td>
		<td>
			${f:h(name)}
		</td>	
	</tr>
	<tr>
		<td> memo </td>
		<td>
			${f:h(memo)}
		</td>	
	</tr>
	<tr>
		<td> time </td>
		<td>
			${f:h(time)}
		</td>	
	</tr>

</table>

<s:link href="edit"> edit </s:link>


<br/><br/>
<s:link href="/board/">list page</s:link>
</body>
</html>
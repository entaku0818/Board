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
		<td> name </td>
		<td>

		<html:text property="name" value=""/>

		
		</td>	
	</tr>
	<tr>
		<td> memo </td>
		<td>
			<html:text property="memo" />
		</td>	
	</tr>


</table>

<input type="submit" name="insert" value="投稿" />
</s:form>
		<c:if test="${!empty sessionScope.facebook}">
			<form action="./facebookpost" method="post">
    		<textarea cols="80" rows="2" name="message"></textarea>
    		<input type="submit" name="post" value="facebook投稿" />
			</form>
		</c:if>
<br/>
        <c:if test="${!empty sessionScope.twitter}">
    		<form action="./twiiterpost" method="post">
			<textarea cols="80" rows="2" name="text"></textarea>
			<input type="submit" name="post" value="twitter投稿"/>
    		</form>
		</c:if>

<br/>

<s:link href="/paging/turn/1"> top </s:link>
<s:link href="/search"> 検索 </s:link>

</body>
</html>
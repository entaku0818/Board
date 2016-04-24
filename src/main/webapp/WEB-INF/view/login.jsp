 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<body>

<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <title>ログイン</title>
        <link rel="STYLESHEET" href="todo.css" type="text/css">
        <script type="text/javascript" src="login.js">
        </script>
    </head>
    <body onload="fieldChanged();">
        <h1>ログイン</h1>
        <hr>
	<s:form action="/login/">
		<p>ログインID<html:text property="userId" /></p>
		<p>パスワード<html:password property="password" /></p>
		<p><html:submit value="ログイン"/></p>
	</s:form>
        	
        <c:if test="${!empty sessionScope.facebook}">
	    ログイン中のユーザー：Welcome ${facebook.name} (${facebook.id})<br/>

		<a href="facebooklogout">ログアウト</a><br/>

		</c:if>
        <c:if test="${!empty sessionScope.twitter}">
        	ログイン中のユーザー：Welcome ${twitter.screenName} (${twitter.id})<br/>
		<a href="twitterlogout">ログアウト</a><br/>
		</c:if>
		<c:if test="${empty sessionScope.twitter}">
		<a href="twittersignin"><img src="./image/Twitter_signin.png"/></a><br/>
		</c:if>
		<c:if test="${empty sessionScope.facebook}">
		<a href="facebooksignin"><img src="./image/facebook_signin.png"/></a><br/>
		</c:if>
        
        
        
    </body>
</html>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Employee List With Paging</title>
</head>
<body>
${link}

		 <c:if test="${!empty userDataDto.userId}">
		<p>あなたのIDは ${userDataDto.userId} <p/>
		<a href="<c:url value="/logout"/>">ログアウト</a>
		</c:if>
        <c:if test="${!empty sessionScope.facebook}">
	    ログイン中のユーザー：Welcome ${facebook.name} (${facebook.id})<br/>

		<a href="/Board/facebooklogout">ログアウト</a><br/>

		</c:if>
        <c:if test="${!empty sessionScope.twitter}">
        	ログイン中のユーザー：Welcome ${twitter.screenName} (${twitter.id})<br/>
		<a href="/Board/twitterlogout">ログアウト</a><br/>
		</c:if>
<table border="1">
    <tr style="background-color: pink">
        <th>Id</th>
        <th>Name</th>
        <th>memo</th>
        <th>time</th>
    </tr>
    <c:forEach var="e" varStatus="s" items="${empItems}">
        <tr style="background-color: "${ s.index % 2 == 0 ? 'white' : 'yellow'}">
            <td align="right">${f:h(e.id)}</td>
            <td>${f:h(e.name)}</td>
            <td>${f:h(e.memo)}</td>
            <td>${f:h(e.time)}</td>
         </tr>
    </c:forEach>
</table>
<s:link href="/board/create"> 投稿 </s:link>
<s:link href="/search"> 検索 </s:link>
</body>
</html>
<html>
<head>
  <title>投稿検索</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
 
<h2>投稿検索</h2>
 
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
		
<s:form>
キーワード検索<html:text property="keyword" size="25" />
  <input type="submit" name="search" value="検索" />
</s:form>
<s:link href="/board/create"> 投稿 </s:link>
<s:link href="/paging/turn/1"> top </s:link>
 
</body>
</html>
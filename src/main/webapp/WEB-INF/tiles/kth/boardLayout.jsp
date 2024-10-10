<!DOCTYPE html>
<html>
<head>
	<title>
		<tiles:getAsString name="title" />
	</title>
	<%@ include file="/WEB-INF/include/include-header.jsp"%>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/main/nm/nmMain2.css' />" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/main/nm/nmSlide.css' />" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/nm/board/nmBoardList.css' />" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/yj/board/board.css' />" />
	<script src="/ckeditor/ckeditor.js"></script>
	<script src="<c:url value='/js/common/jquery.fileDownload.js' />"></script>
</head>

<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
<script>
// id가 description인 태그에 ckeditor를 적용시킴
// 이미지 업로드 안됨
CKEDITOR.replace('noticeContents',{
	filebrowserUploadUrl: '/yj/uploadFile.do'
});
</script>
</html>
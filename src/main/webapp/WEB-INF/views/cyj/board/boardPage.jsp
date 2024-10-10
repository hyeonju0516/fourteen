<style>
.pageCntSelectBox {
	width: 100px;
	height: 43px;
	text-align: center;
}
</style>
<script>
$(function(){
	$('#searchBtn').on('click', function(){
		$(this).prop("disabled", true);			// 버튼 클릭 더 이상 안되도록 막음
		fn_movePage(1);
	});

	$("#listCnt").click(function(){
		$(this).prop("disabled", true);		// 버튼 클릭 더 이상 안되도록 막음
		fn_movePage("1");
	});
});

function fn_movePage(pageNo) {
	// if(doubleSubmitCheck()){return;}		// 이중클릭 방지
	$("input[name=pageNo]").val(pageNo);
	let obj = document.viewTable;
	obj.method="GET";
	obj.action="<c:url value='/cyj/help/boardPage'/>";
	obj.submit();
}
</script>

<main>
	<div class="board">
		<h1>고객센터</h1>
		<form name="viewTable">
			<input type="hidden" name="pageNo" value="${pageVo.pageNo }" />
			<select class="pageCntSelectBox" name="pageCnt" id="pageCnt">
				<option value="5" <c:if test="${pageVo.pageCnt == '5'}">selected="selected"</c:if>>5개</option>
				<option value="10" <c:if test="${pageVo.pageCnt == '10'}">selected="selected"</c:if>>10개</option>
				<option value="15" <c:if test="${pageVo.pageCnt == '15'}">selected="selected"</c:if>>15개</option>
				<option value="50" <c:if test="${pageVo.pageCnt == '50'}">selected="selected"</c:if>>50개</option>
			</select>
			<button type="button" id="listCnt">확인</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="search">검색창</label>
			<input type="text" name="search" id="search" placeholder="검색어를 입력해주세요." maxlength="30" value="${search }" />
			<button type="button" id="searchBtn">검색</button>
		</form>
		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>아이디</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rowList" items="${boardList }">
					<tr>
						<td class="postId">${rowList.helpBorSeq }</td>
						<td class="postTitle"><a href="javascript:void(0);">${rowList.helpBorTitle }</a></td>
						<td class="postNm">${rowList.userId }</td>
						<td class="postDate">${rowList.regDe }</td>
						<td class="hits">${rowList.helpBorViewCnt }</td>
					</tr>
				</c:forEach>
				<c:if test="${empty boardList }">
					<tr>
						<td colspan="5" style="text-align:center"><span class="noData">검색 조건에 맞는 데이터가 없습니다.</span></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>
</main>
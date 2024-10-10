<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
	<ul class="pc-nav">
		<c:forEach var="menuVo" items="${mnList}">
			<c:if test ="${menuVo.menuLevel eq 1 and menuVo.userId eq 'CJY' }" >
				<li class="nav-list">
					<a href="${menuVo.menuUrl}">${menuVo.menuNm}</a>
						<ul class="depth01">
							<c:forEach var="menuVo2" items="${mnList}">
								<c:if test ="${menuVo.menuId eq menuVo2.upMenuId and menuVo2.userId eq 'CJY'}">
									<li class="depth01-list">
										<a href="${menuVo2.menuUrl}">${menuVo2.menuNm}</a>
									</li>
								</c:if>
							</c:forEach>
						</ul>
				</li></c:if>
		</c:forEach>
	</ul>
</nav>
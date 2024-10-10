<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
	<ul class="pc-nav">
		<c:forEach var="menuVo" items="${menuList}">
			<c:if test="${menuVo.menuLevel eq 1 and menuVo.regId eq 'sehyun'}">
				<li class="nav-list">
					<a href="${menuVo.menuUrl}">${menuVo.menuNm}</a>
					<ul class="depth01">
						<c:forEach var="menuVo1" items="${menuList}">
							<c:if test="${menuVo.menuId eq menuVo1.upMenuId}">
								<li class="depth01-list">
									<a href="${menuVo1.menuUrl}">${menuVo1.menuNm}</a>
								</li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</nav>
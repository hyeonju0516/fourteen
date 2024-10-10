<nav>
	<ul class="pc-nav">
		<c:forEach var="menuVo" items="${menuList }" varStatus="idx">
			<c:if test="${fn:substring(menuVo.menuId,0,2) eq 'MN' }">
				<li class="nav-list">
					<a href="${menuVo.menuUrl }">${menuVo.menuNm }</a>
					<ul class="depth01">
			</c:if>
			<c:forEach var="menuVo2" items="${menuList }">
				<c:if test="${menuVo.menuId eq menuVo2.upMenuId }">
					<li class="depth01-list"><a href="${menuVo2.menuUrl }">${menuVo2.menuNm }</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${fn:substring(menuVo.menuId, 0, 2) eq 'MN' }"></ul></li></c:if>
		</c:forEach>
	</ul>
</nav>
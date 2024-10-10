<nav>
	<ul class="pc-nav">
		<c:forEach var="item" items="${menuList }" varStatus="idx">
			<c:if test="${fn:substring(item.menuId,0,2) eq 'HS' }">
				<li class="nav-list">
					<a href="${item.menuUrl }">${item.menuNm }</a>
					<ul class="depth01">
						<c:forEach var="item2" items="${menuList }">
							<c:if test="${item.menuId eq item2.upMenuId }">
								<li class="depth01-list"><a href="${item2.menuUrl }">${item2.menuNm }</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</li>
			</c:if>
		</c:forEach>
	</ul>
</nav>
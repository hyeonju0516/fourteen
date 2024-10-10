<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
	<title>Add Page</title>
</head>

<body>
	<%@ include file="/WEB-INF/fragment/hoseong/header.jsp" %>
	<%@ include file="/WEB-INF/fragment/hoseong/menubar.jsp" %>
	<div class="content">
		<h2>USER Add</h2>
		<table>
			<thead>
				<tr>
					<th colspan="2">USER Add !!</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>ID : </th>
					<td>
						<input type="text" name="id" />
						<div name="isTrue"></div>
					</td>
				</tr>
				<tr>
					<th>Name : </th>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<th>Phone : </th>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<th>주소 : </th>
					<td>
						<select name="city">
							<c:forEach var="item" items="${cityList}">
								<option value="${item}">${item}</option>
							</c:forEach>
						</select>
						<select name="county">
						</select>
						<select name="district">
						</select>
						상세주소 :
						<input type="text" name="addr" />
					</td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td><input type="text" name="email" /></td>
				</tr>
			</tbody>
		</table>
		<input type="button" onclick="add()" value="추가" />
		<input type="button" onclick="history.back()" value="뒤로가기" />
	</div>
	<%@ include file="/WEB-INF/fragment/hoseong/footer.jsp" %>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

		let isOk = 1;

		function add() {
			let phone = $('[name=city]').val() + '/' + $('[name=county]').val() + '/'
						+ $('[name=district]').val() + '/' + $('[name=addr]').val();

			if(isOk === 0) {
				let data = {
						id: $('[name=id]').val(),
						name: $('[name=name]').val(),
						phone: phone,
						addr: $('[name=addr]').val(),
						email: $('[name=email]').val()
				};

				$.ajax({
					url: '/hoseong/add',
					type: 'POST',
					data: JSON.stringify(data),
					contentType: 'application/json',
					processData: false,
					success: function(response) {
						window.location.href="/hoseong/list"
					},
					error: function(xhr, status, error) {
						console.error('error :: ', error);
					}
				});
			}else {
				alert("아이디가 중복입니다.");
			}
		};

		$('[name=id]').on('keyup', function() {
			let data = {
				id: $(this).val()
			};
			$.ajax({
				url: '/hoseong/isok',
				type: 'POST',
				data: JSON.stringify(data),
				contentType: 'application/json',
				processData: false,
				success: function(response) {
					isOk = response;
					if(response === 0) {
						$('[name=isTrue]').html('사용가능한 아이디입니다.');
					}else if(response === 1) {
						$('[name=isTrue]').html('아이디가 중복되었습니다.');
					}else {
						$('[name=isTrue]').html('오류입니다.');
					}
				},
				error: function(xhr, status, error) {
					console.error('error :: ', error);
				}
			});
		})

		$('[name=city]').on('change', function() {
			checkCounty($(this).val());
		})

		$('[name=county]').on('change', function() {
			checkDistrict($(this).val());
		})

		function checkCounty(data) {
			$.ajax({
				url: '/hoseong/checkCounty',
				type: 'POST',
				data: JSON.stringify({cityName: data}),
				contentType: 'application/json',
				processData: false,
				success: function(response) {
					$('[name=district]').empty();
					$('[name=county]').empty();
					response.forEach(function(item) {
						$('[name=county]').append(`<option value="`+ item +`">`+ item +`</option>`);
					});
				},
				error: function(xhr, status, error) {
					console.error('error :: ', error);
				}
			});
		}

		function checkDistrict(data) {
			$.ajax({
				url: '/hoseong/checkDistrict',
				type: 'POST',
				data: JSON.stringify({countyName: data}),
				contentType: 'application/json',
				processData: false,
				success: function(response) {
					$('[name=district]').empty();
					response.forEach(function(item) {
						$('[name=district]').append(`<option value="`+ item +`">`+ item +`</option>`);
					});
				},
				error: function(xhr, status, error) {
					console.error('error :: ', error);
				}
			});
		}

	</script>
</body>
</html>
<script src="<c:url value='/common/qrcode.js' />"></script>
<script>
  $(document).ready(function(){
    $("#otpBtn").click(function(){
      if($('#userId').val() == undefined || $('#userId').val() == "" || $('#userId').val().length == 0 || $.trim($('#userId').val()) == "") {
        alert("아이디를 입력해주세요.");
        $('#userId').focus();
        return false;
      }
      if($('#userPw').val() == undefined || $('#userPw').val() == "" || $('#userPw').val().length == 0 || $.trim($('#userPw').val()) == "") {
        alert("비밀번호를 입력해주세요.");
        $('#userPw').focus();
        return false;
      }
      if($('#otpEmail').val() == undefined || $('#otpEmail').val() == "" || $('#otpEmail').val().length == 0 || $.trim($('#otpEmail').val()) == "") {
        alert("Email를 입력 하세요.");
        $('#otpEmail').focus();
        return false;
      }
      if($("#otpEmail").val() != "") {
        var regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;      // email 유효성검사
        if(!regExp.test($("#otpEmail").val())) {
          alert("잘못된 Email 형식입니다.");
          return false;
        }
      }


      $.ajax({
        type : "get",
        url : "/login/otpCreate.do",
        data : {otpEmail : $("#otpEmail").val(), userId : $("#userId").val(), userPw : $("#userPw").val()},
        success : function(result) {
          if(result.resultCode != "CM0000") {
            alert(result.resultMsg);
            return false;
          } else {
            $(".otpSpan").remove();
            $(".qrCodeDiv").append("<p style='color:red;'>아래 QR바코드를 구글 OTP앱에서 바코스 스캔으로 등록해주세요</p><img alt='qr코드' src='" + result.qrCode + "' />");
            $(".qrKey").html("<span style='color:red;'>OPT KEY :: </span><span>" + result.otpKey + "</span>");
            $(".closeDiv").html("<button class='btn btn-info btnType1 a2' type='button' id='otpBtnOk'>완료</button>");
          }
        },
        error: function(xhs, status, error) {
        }
      });
    });

    $(document).on("click", "#otpBtnOk", function(){
      window.close();
    });
  });
</script>
<div class="otpDiv">
  <h4>&nbsp;&nbsp;&nbsp;구글 OTP 등록 입니다.</h4>
  <span class="otpSpan">
      아이디 : <input type="text" class="form-control popUpInput" name="userId" id="userId" placeholder="아이디를 입력하세요" /><br><br>
      &nbsp;&nbsp;패스워드 : <input type="password" class="form-control popUpInput" name="userPw" id="userPw" placeholder="비밀번호를 입력하세요" /><br><br>
      &nbsp;&nbsp;메일주소 : <input type="text" class="form-control popUpInput" name="otpEmail" id="otpEmail" placeholder="메일 주소를 입력하세요" />
      <button class="btn btn-success btnType1 a2" type="button" id="otpBtn">OTP 등록</button>
   </span>
  <div class="qrCodeDiv" id="qrCodeDiv" style="text-align: center;">
  </div><br><br>
  <div class="qrKey" style="text-align: center;"></div>
  <div class="closeDiv" style='text-align:right; margin-right: 10px;'></div>
</div>

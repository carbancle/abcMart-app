<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="/abcMart-app/resources/css/style.css" />
    <title></title>
</head>
<body>
<%@ include file="/common/navbar.jsp" %>
<div class="container">    

	<div class="row">
		<div class="col breadcrumb">
			<ul class="nav">
				<li class="crumb home"><a href="" class="nav-link p-0">HOME</a></li>
				<li class="crumb">마이페이지</li>
				<li class="crumb">마이페이지</li>
				<li class="crumb">마이페이지</li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col p-0 page-title">
			<h1>마이페이지</h1>
		</div>
	</div>
	<div class="row mypage">
		<!-- aside 시작 -->
		<div class="col-2 p-0 aside">
			<span class="aside-title">마이 페이지</span>
			<ul class="nav flex-column p-0">
				<li class=""><a href="" class="nav-link p-0">마이페이지</a></li>
				<li class=""><a href="" class="nav-link p-0">개인정보 수정</a></li>
				<li class=""><a href="" class="nav-link p-0">비밀번호 변경</a></li>
				<li class=""><a href="" class="nav-link p-0">주문상품 조회</a></li>
				<li class=""><a href="" class="nav-link p-0">주문 취소</a></li>
				<li class=""><a href="" class="nav-link p-0">회원 탈퇴</a></li>
			</ul>
		</div>
		<!-- //aside 끝 -->
		<div class="offset-md-1 col-9 p-0">
			<div class="card member-box p-0">
				<div class="row g-0">
					<div class="col-2 p-0">
						<span class="icon-grade"></span>
					</div>
					<div class="col-6 p-0 middle-box">
						<p>홍길동 님은 <strong>통합멤버십 회원</strong>입니다.</p>
						<span class="member-info">MEMBERSHIP <span class="member-number">123456789</span></span> 
						<span class="member-info">멤버십 회원 가입일 <span class="member-number">2021.11.25</span></span> 
					</div>
					<div class="col-4 p-0 right-box">
						<span class="text-center"><img src="" alt="" />포인트</span>
						<span class="point">5,000<span class="unit">p</span></span>
					</div>
				</div>
			</div>
			<div class="order-list">
				<p>주문/배송 상세</p>
				<div class="row border p-1">
					<div class="col mt-1">
						<span>주문번호</span>
					</div>
					<div class="col mt-1">
						<span>주문일시</span>
					</div>
					<div class="col text-end mt-1">
						<button type="button" class="btn btn-dark btn-sm">전체주문취소</button>
					</div>
				</div>
			</div>
			<div class="order-list">
				<p>주문정보</p>
				<div class="order-list-box">
					<div class="row">
						<div class="col-2 mt-2">
							<span style="margin-left:5px;">ABC_MART 상품</span>
						</div>
						<div class="col text-end mt-2">
							<span style="margin-right:5px;">무료배송</span>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-5">
							<img class="order-img me-2" src="../../resources/images/운동화_아키클래식_1.jpg">
							<div>
								<div>
									<span>브랜드명</span>
								</div>
								<div>
									<span>제품명</span>
								</div>
								<div>
									<span>신발명</span>
								</div>
							</div>
						</div>
						<div class="col mt-4">
							<p>결제금액</p>
						</div>
						<div class="col mt-4">
							<p>결제상태</p>
						</div>
						<div class="col text-end mt-4">
							<button type="button" class="btn btn-light btn-sm">주문취소</button>
						</div>
					</div>
				</div>
				
			</div>
			<div class="order-list">
			<p>주문자 정보</p>
				<div class="order-list-box p-3">
					<div class="row mb-3 mt-3 order-font">
						<div class="col-2">
							<span style="font-weight: bold;">이름</span>
						</div>
						<div class="col">
							<span >김수경</span>
						</div>
					</div>
					<div class="row mb-3 order-font">
						<div class="col-2">
							<span style="font-weight: bold;">휴대폰 번호</span>
						</div>
						<div class="col">
							<span>010-1111-1111</span>
						</div>
					</div>
					<div class="row mb-3 order-font">
						<div class="col-2">
							<span style="font-weight: bold;">이메일 주소</span>
						</div>
						<div class="col">
							<span>subtitle1@naver.com</span>
						</div>
					</div>
				</div>
			</div>
			<div class="order-list">
				<p>결제 정보</p>
				<div class="order-list-box p-3">
					<div class="row">
						<div class="col-4">
							<span style="font-weight: bold;">주문금액</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/common/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
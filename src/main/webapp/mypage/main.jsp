<%@page import="java.util.List"%>
<%@page import="dto.OrderDetailDto"%>
<%@page import="vo.Order"%>
<%@page import="dao.MemberDao"%>
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
<%
	int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	MemberDao memberDao = MemberDao.getInstance();
	
	Member member = memberDao.selectMemberByNo(memberNo);
%>
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
				<li class=""><a href="../mypage/claim/claim-order-main.jsp?memberNo=<%=member.getNo() %>" class="nav-link p-0">주문현황 조회</a></li>
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
						<p><%=member.getName() %> 님은 <strong>통합멤버십 회원</strong>입니다.</p>
						<span class="member-info">MEMBERSHIP <span class="member-number"><%=member.getNo() %></span></span> 
						<span class="member-info">멤버십 회원 가입일 <span class="member-number"><%=member.getRegisteredDate() %></span></span> 
					</div>
					<div class="col-4 p-0 right-box">
						<span class="text-center"><img src="" alt="" />포인트</span>
						<span class="point"><%=member.getPct() %><span class="unit">p</span></span>
					</div>
				</div>
			</div>
			<div class="buy-list">
				<p>주문/배송 현황 조회</p>
				<div class="buy-list-box">
					<div class="row">
						<div class="col">
<%
	OrderDetailDto orderDetailDto = new OrderDetailDto();
	int count = orderDetailDto.selectOrderCount(memberNo, "주문완료");   
%>
		                    <span class="count" id="standByCount"><%=count %></span>
							주문완료
						</div>
						<div class="col">
<%
	count = orderDetailDto.selectOrderCount(memberNo, "상품준비중");   
%>
							<span class="count" id="completeCount"><%=count %></span>
							결제완료
						</div>
						<div class="col">
<%
	count = orderDetailDto.selectOrderCount(memberNo, "배송완료");   
%>
							<span class="count" id="finishCount"><%=count %></span>
							배송완료
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
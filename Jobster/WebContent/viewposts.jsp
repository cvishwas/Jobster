<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Jobster</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
	</head>
	<body class="container-fluid">
		<nav class="navbar navbar-light bg-light">
			<a class="navbar-brand text-info text-italic" href="">Jobster</a>
			<!-- Search post by posts, categories, states, cities -->
	  		<form action="viewposts?userId=<%= request.getParameter("userId")%>#search" method="POST" class="mx-auto" >
	  			<div class="form-inline">
		    		<input class="form-control mr-sm-2" type="search" method="POST" name="searchName" placeholder="Search">
		   			<button class="btn btn-outline-info my-2 my-sm-0" name="search" type="submit">Search</button>
	   			</div>
	   			<div class = "mx-auto">
		  			<input type="radio" name="searchType"  value="type"> by Type
		  			<input type="radio" name="searchType"  value="category"> by Category
		  			<input type="radio" name="searchType"  value="city"> by City
		  			<input type="radio" name="searchType"  value="state"> by State
				</div>
	  		</form>
	      	<a class="nav-item nav-link btn-info" href="#">Log out</a>
		</nav>
	
		<div class = "mx-auto my-5 col-8">
			<div class="row">
				<div id="navbarEx" class = " col-3 list-group ">
					<!-- Show user's favorites posts -->
				    <form action="viewposts?userId=<%= request.getParameter("userId") %>#favoritepost" method="POST" class="mb-4">
	      				<input type="submit" class="btn btn-info" name="showFavorite"  value="Show my favorites">
	      			</form>
	      			<!-- Job title -->
					<c:forEach items="${list}" var="job" >
			  			 <div class="">
			  			 	<a class="list-group-item list-group-item-action" href="#list-item${job.id}">${job.id} </a>
			  			 </div>
			   		</c:forEach>
			   	</div>	
			   	<!-- Post details  -->
				<div  data-spy="scroll" data-target="#navbarEx" data-offset="0" class = "scrollspy-example col-9">
					<c:forEach items="${list}" var="job" >
						<div class ="card mb-4">
							<div class="card-header">
								<div class="row">
									<div class="col-9">
										<h5>${job.user.f_name} ${job.user.l_name}</h5>
									</div>
									<div class="col-3 row">
										<button class="btn btn-info">Apply</button>
										<form name="" action="viewposts?userId=<%= request.getParameter("userId") %>" method="POST">
										    <input type="hidden" name="postId" value="${job.id}" />
										    <c:choose>
    											<c:when test="${job.isLikedJobPost}">
						        					<input type="submit" class="font-weight-bold ml-4 bg-light border-0 text-primary text-" style="font-size:30px;" name="favorite" title="Add to favorites" value="&#x2606;"/>
    											</c:when>    
    											<c:otherwise>
													<input type="submit" class="font-weight-bold ml-4 bg-light border-0 " style="font-size:30px;" name="favorite" title="Add to favorites" value="&#x2606;"/>
    											</c:otherwise>
											</c:choose>
											
										</form>								
									</div>
								</div>
							</div>
							<!-- Categories, Types, Locations  -->
							<div class="card-body">
								<h5 class="font-italic">Job categories: 
									<c:forEach items="${job.jobCategories}" varStatus="status"  var="category">
										${category.name}
										<!--check if element isn't last in list  -->
										<c:if test="${(fn:length(job.jobCategories)) != status.count}" >,</c:if> 
									</c:forEach>
								</h5>
								<h5 class="font-italic">Job types: 
									<c:forEach items="${job.jobTypes}" varStatus="status"  var="type">
										${type.name}
										<c:if test="${(fn:length(job.jobTypes)) != status.count}" >,</c:if> 
									</c:forEach>
								</h5>
								<h5 class="font-italic">Locations: 
									<c:forEach items="${job.locations}" varStatus="status"  var="loc">
										${loc.city} ${loc.stateProvince}
										<c:if test="${(fn:length(job.jobTypes)) != status.count}" >,</c:if> 
									</c:forEach>
								</h5>
								<hr/>
								<!-- Job description -->
								<p>${job.description}</p>
								<hr/>
								<p class="">${job.date}</p>
			      			</div>
			      		 </div>
			    	</c:forEach>
				</div>
			</div>
			</div>
	</body>
</html>
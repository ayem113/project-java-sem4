<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>



<c:url var="ProAPI" value="/api/product"/>


<div class="card">
	<div class="card-header">


		<c:if test="${not empty model.id}">
			<h4 id="title" class="card-title">Cập nhật sản phẩm</h4>
		</c:if>
		<c:if test="${empty model.id}">
			<h4 id="title" class="card-title">Thêm mới sản phẩm</h4>
		</c:if>

	</div>
	<div class="card-body">
		<form:form id="formSubmit" role="form" modelAttribute="model" >
			<div class="row">
				<div class="col-md-5 pr-1">
					<div class="form-group">
						<form:input path="name" type="text"   class="form-control"   placeholder="Tên sản phẩm"  />
					</div>
				</div>
				<div class="col-md-3 px-1">
					<div class="form-group">
						<form:input path="price" type="number"  class="form-control" placeholder="Giá gốc" />
					</div>
				</div>
				<div class="col-md-4 pl-1">
					<div class="form-group">
						<form:input  path="sale" type="number"  class="form-control" placeholder="Giá sale"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 pr-1">
					<div class="form-group">
						<form:input path="id_category" type="text" class="form-control" placeholder="CHọn danh mục" />
					</div>
				</div>
				<div class="col-md-4 pr-1">
					<div class="form-group">
						<form:input path="quantity"  type="number" class="form-control" placeholder="Số lượng"/>
					</div>
				</div>
				<div class="col-md-4 pl-1">
					<div class="form-group">
						<form:input path="img" type="text" class="form-control"  placeholder="img" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<form:textarea rows="4" cols="80" class="form-control" path="description" placeholder="Mô tả"/>
					</div>
				</div>
			</div>

			<c:if test="${not empty model.id}">
				<button type="submit" id="btnAddOrUpdate" class="btn btn-info btn-fill pull-right">Cập nhật</button>
			</c:if>
			<c:if test="${empty model.id}">
				<button type="submit" id="btnAddOrUpdate" class="btn btn-info btn-fill pull-right">Thêm</button>
			</c:if>

			<div class="clearfix"></div>
			<form:hidden path="id" id="ProId"/>
		</form:form>
	</div>
</div>


<script>
	$('#btnAddOrUpdate').click(function (e) {
		e.preventDefault(); //huy bo su kien mac dinh cua trang 
	   
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
	    var id = $('#ProId').val();
	    addOrEdit(data);
	});
	
	
	
	var titlePage = $('#title').text();
	function addOrEdit(data) {
		$.ajax({
            url: '${ProAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	Swalalert(result);
            },
            error: function (error) {
            	Swalalert(error);
            }
        });
	}
	
	function Swalalert(result) {
		if (result==true) {
			Swal.fire({
				  position: 'top',
				  icon: 'success',
				  title: titlePage+' thành công ',
				  showConfirmButton: false,
				  timer: 1500
				});
				
			
		}
		else{
			Swal.fire({
				  position: 'top',
				  icon: 'error',
				  title: titlePage+' không thành công',
				  showConfirmButton: false,
				  timer: 1500
				});
				
			}
		
	}
	
	
	
	
	
</script>


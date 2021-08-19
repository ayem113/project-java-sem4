<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:url var="newPro" value="/quan-tri/san-pham/them-hoac-sua" />
<c:url var="ProAPI" value="/api/product" />


<div class="modal fade" id="addOrEditModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<form class="form-horizontal" method="POST" id="formSubmit" role="form">
			<div class="modal-content">
				<div class="modal-header">


					<h4 class="modal-title" id="xxx">Thêm mới sản phẩm</h4>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

				</div>
				<div class="modal-body">



					<div class="row">
					
						 <input type="hidden" id="ProId" name="id" >
					
						<div class="col-md-5 pr-1">
							<div class="form-group">
								<input type="text" id="name" class="form-control" name="name"
									placeholder="Tên sản phẩm" />
							</div>
						</div>
						<div class="col-md-3 px-1">
							<div class="form-group">
								<input type="number" id="price" class="form-control"
									name="price" placeholder="Giá gốc" />
							</div>
						</div>
						<div class="col-md-4 pl-1">
							<div class="form-group">
								<input type="number" id="sale" class="form-control" name="sale"
									placeholder="Giá sale" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 pr-1">
							<div class="form-group">
								<input type="text" id="id_category" class="form-control"
									name="id_category" placeholder="CHọn danh mục" />
							</div>
						</div>
						<div class="col-md-4 pr-1">
							<div class="form-group">
								<input type="number" id="quantity" class="form-control"
									name="quantity" placeholder="Số lượng" />
							</div>
						</div>
						<div class="col-md-4 pl-1">
							<div class="form-group">
								<input type="text" id="img" class="form-control" name="img"
									placeholder="img" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<textarea id="description" name="description" rows="4" cols="50"> </textarea>
							</div>
						</div>
					</div>

					<button type="submit" id="btnAddOrUpdate"
						class="btn btn-info btn-fill pull-right">Thêm</button>




				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="editContact" type="submit"
						class="saveContact btn btn-primary" data-id="">Save</button>
				</div>
			</div>
		</form>
	</div>
</div>




<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">Thêm mới</h1>

	<a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
		data-toggle="tooltip" title='Thêm bài viết kiểu trang mới'
		href='${newPro}'> <span> <i
			class="fa fa-plus-circle bigger-110 purple"></i></span>
	</a> <a class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
		data-toggle="tooltip" title='Thêm bài viết kiểu modal' id="btnNewPro">
		<span> <i class="fa fa-plus-circle bigger-110 red"></i></span>
	</a>



	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Danh sách tất cả
				sản phẩm</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" id="dataTable">
					<thead>
						<tr>
							<th>Tên</th>
							<th>Giá gốc</th>
							<th>Giá sale</th>
							<th>Thuộc danh mục</th>
							<th>Số lượng</th>
							<th>Trạng thái</th>
							<th>Ảnh đại diện</th>
							<th>Ảnh chi tiết</th>
							<th>Ngày thêm</th>
							<th>Ngày cập nhật</th>
							<th>Người thêm</th>
							<th>Người cập nhật</th>
							<th>Mô tả</th>
							<th>Sửa</th>
							<th>Sửa modal</th>
							<th>Xóa</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach var="item" items="${List}">
							<tr class="table-info">
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td>${item.sale}</td>
								<td>${item.id_category}</td>
								<td>${item.quantity}</td>
								<td>${item.stt}</td>
								<td>${item.img}</td>
								<td>${item.img}</td>
								<td>${item.createdDate}</td>
								<td>${item.modifiedDate}</td>
								<td>${item.createdBy}</td>
								<td>${item.modifiedBy}</td>
								<td>${item.description}</td>
								<td><a
									href="/quan-tri/san-pham/them-hoac-sua?Id=${item.id}"
									class="btn btn-warning btn-circle btn-sm"> <i
										class="fas fa-edit"></i></a></td>
								<td><a onclick="showModal(${item.id})"
									class="btn btn-warning btn-circle btn-sm"> <i
										class="fas fa-edit"></i></a></td>
								<td><a href="/quan-tri/san-pham/xoa-san-pham?Id=${item.id}"
									class="btn btn-danger btn-circle btn-sm"> <i
										class="fas fa-trash"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>


<script>
	$(document).ready(function() {
		$('#dataTable').DataTable()
	});
	
		
	$( "#btnNewPro" ).click(function() {
		var ii=$('#addOrEditModal #name').text();
		if ($('#addOrEditModal #name').text()!=" ") {
			
			
			
			
			$('#addOrEditModal #xxx').val("cccccc");
			$('#xxx').val("cccccc");
		
		
		}else{
			$('.modal-header #myModalLabel').val("Cập nhật sản phẩm xx");
		}
		$('#addOrEditModal').modal("show");
	});
	
	function showModal(id) {
		//e.preventDefault();
		$.ajax({
            url: '${ProAPI}/'+id,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (pro) {
            	console.log(pro);
            	
            	$('#addOrEditModal #id_category').val(pro.id_category);
            	$('#addOrEditModal #name').val(pro.name);
            	$('#addOrEditModal #price').val(pro.price);
            	$('#addOrEditModal #sale').val(pro.sale);
            	$('#addOrEditModal #quantity').val(pro.quantity);
            	$('#addOrEditModal #img').val(pro.img);
            	$('#addOrEditModal #description').val(pro.description);
            	$('#myModalLabel').val("Cập nhật sản phẩm xx");
            	
            	$('#addOrEditModal').modal("show");
            },
            error: function (error) {
            	console.log(error)
            }
        });
		
		
		
	};
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

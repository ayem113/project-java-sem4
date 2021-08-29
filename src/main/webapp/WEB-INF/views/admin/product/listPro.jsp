<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:url var="newPro" value="/quan-tri/san-pham/them-hoac-sua" />
<c:url var="ProAPI" value="/api/product" />


<div class="modal fade" id="addOrEditModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<form class="form-horizontal" method="POST" id="formSubmit"
			role="form">
			<div class="modal-content">
				<div class="modal-header">


					<h4 class="modal-title" id="myModalLabel">Thêm mới sản phẩm</h4>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

				</div>
				<div class="modal-body">



					<div class="row">

						<input type="hidden" id="ProId" name="id">

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

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button id="btnAddOrUpdate" type="submit"
						class="saveContact btn btn-primary" data-id="">OK</button>
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
	<div id="dataTableSum" class="card shadow mb-4">
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

					<tbody class="Pro_body">
						<%-- <c:forEach var="item" items="${List}">
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
						</c:forEach> --%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>


<script>

var titlePage = $('#myModalLabel');
	$(document).ready(function() {
		LoadTable();
		
		//$ ('#dataTable').DataTable().ajax.url("http://localhost:8080/api/product").load ();
		
		//$ ('#dataTable').DataTable().ajax.url("http://localhost:8080/api/product");
		//$ ('#dataTable').DataTable().draw();
		
		//khi close modal thì clear fiel của modal
		$('#addOrEditModal').on('hidden.bs.modal', function () {
			//c1 $(this).find("input,textarea,select").val('').end();
		    $(this).find('form')[0].reset();
		});
	});
	
		
	$( "#btnNewPro" ).click(function() {
		titlePage.text("THêm mới sản phẩm ");
		$('#addOrEditModal').modal("show");
	});
	
	function showModal(id) {
		
		$.get('${ProAPI}/'+id, function(pro, status){
			console.log(pro);
        	$('#addOrEditModal #id_category').val(pro.id_category);
        	$('#addOrEditModal #ProId').val(pro.id);
        	$('#addOrEditModal #name').val(pro.name);
        	$('#addOrEditModal #price').val(pro.price);
        	$('#addOrEditModal #sale').val(pro.sale);
        	$('#addOrEditModal #quantity').val(pro.quantity);
        	$('#addOrEditModal #img').val(pro.img);
        	$('#addOrEditModal #description').val(pro.description);
        	titlePage.text("Cập nhật sản phẩm ");
        	$('#addOrEditModal').modal("show");
		})
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
	
	
	
	
	
	function addOrEdit(data) {
		 $.post({ url: '${ProAPI}', data: JSON.stringify(data), contentType: 'application/json; charset=utf-8'}).done(function (response) 
			{
				Swalalert(true);
	    		$('#addOrEditModal').modal('hide');
	    		

	    		
	    		var mytbl = $("#dataTable").DataTable();
	    		mytbl.clear();
	    		mytbl.ajax.reload;
	    		  
	    		 //$("#dataTable").DataTable().ajax.reload(null, false);
				//LoadTable();
	    		//$( "#dataTableSum" ).load(window.location.href + " #dataTableSum" );
	    		//location.reload();
	    		
	    		//$("#dataTable").load("http://localhost:8080/quan-tri/san-pham/danh-sach" + " #dataTable");
   			 });
	}
	
	function parseJsonDate( jsonDate) { //1293034567877
		 return (new Date(jsonDate).toISOString().substr(0,10));   //2015-10-26T07:46:36.611Z  (substr(0,10) =>2015-10-26)
    }; 
       
	
	function LoadTable(){
		
		 $.get('${ProAPI}', function(result, status){
			 var rows = '';
     		var rows2 = '';
     		var date= '';
     		 $.each(result, function (idex, item) {
     			 
     			  if (item.createdDate != null) { date=parseJsonDate(item.createdDate);} 
     			 
     			  rows+=`<tr class="table-info">
							<td>` + item.name + `</td>
							<td>` + item.price + `</td>
							<td>` +item.sale+ `</td>
							<td>` +item.id_category+ `</td>
							<td>` +item.quantity+ `</td>
							<td>` +item.stt+ `</td>
							<td>` +item.img+ `</td>
							<td>` +item.img+ `</td>
							<td>`+ date+ `</td>
							<td>` +item.modifiedDate+ `</td>
							<td>` +item.createdBy+ `</td>
							<td>` +item.modifiedBy+ `</td>
							<td>` +item.description+ `</td>
							<td><a href="/quan-tri/san-pham/them-hoac-sua?Id=`+item.id+`"
								class="btn btn-warning btn-circle btn-sm"> <i class="fas fa-edit"></i></a></td>
							<td><a onclick="showModal(`+item.id+`)"
								class="btn btn-warning btn-circle btn-sm"> <i class="fas fa-edit"></i></a></td>
							<td><a href="/quan-tri/san-pham/xoa-san-pham?Id=`+item.id+`"
								class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a></td>
						</tr>`;
						 
     			 $(".Pro_body").html(rows);
     		 })
     		 
     		$('#dataTable').DataTable();
     		 
		    }); 
	}
	
	function Swalalert(result) {
		if (result==true || result=='true') {
			Swal.fire({
				  position: 'top',
				  icon: 'success',
				  title: titlePage.text()+' thành công ',
				  showConfirmButton: false,
				  timer: 1500
				});
		}
		else{
			Swal.fire({
				  position: 'top',
				  icon: 'error',
				  title: titlePage.text()+' không thành công',
				  showConfirmButton: false,
				  timer: 1500
				});
				
			}
	}
	
</script>

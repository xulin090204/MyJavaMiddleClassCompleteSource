<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<title>案件検索</title>
<link rel="stylesheet" href="css/tabulator.css">
<link href="css/tabulator_midnight.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<script type="text/javascript" src="js/tabulator.min.js"></script>
<script type="text/javascript" src="js/tabulator.js"></script>
</head>

<body>


	<script>
		$(function() {
			var $m = $('body');
			var alpha = $m.data('モード');
			if(alpha == '1'){
				$("#search_btn").click();
			}

			$("#response").html("Response Values");
			// Ajax通信テスト ボタンクリック
			$("#ajax_btn").click(function() {
				// outputDataを空に初期化
				//$("#output_data").text("");

				var url = $("url_post").val();
				var JSONdata = {
					name_input : $("#name_input").val(),
					maleFemale_input : $("#maleFemale_input").val(),
					birthDate_input : $("#birthDate_input").val(),
					joinDate_input : $("#joinDate_input").val()
				};

				//alert(JSON.stringify(JSONdata));

				$.ajax({
					type : "GET",
					url : "http://localhost:8080/JavaMiddleClassCompleteSource/案件search",
					dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
					data : JSON.stringify(JSONdata),
					scriptCharset : 'utf-8',
					success : function(data) {
						success(data);
					},

					error : function() {

						alert("AJAXの返す処理はERRORがあり by Yan");
					}
				});
			});

			$("#add_btn").click(function() {
				window.status = "処理中です。しばらくお待ちください。";
			});

			$("#search_btn").click(function() {
				//alert("検索 by Yan");
				//var url = $("url_post").val();
				var JSONdata = {
					案件名称 : $("#案件名称").val(),
					案件概要 : $("#案件概要").val(),
					案件場所 : $("#案件場所").val(),
					職種 : $("#職種").val(),
					工程 : $("#工程").val(),
					案件開始日_開始 : $("#案件開始日_開始").val(),
					案件開始日_終了 : $("#案件開始日_終了").val(),
					予定終了日_開始 : $("#予定終了日_開始").val(),
					予定終了日_終了 : $("#予定終了日_終了").val(),
					予定終了日_開始 : $("#実際終了日_開始").val(),
					予定終了日_終了 : $("#実際終了日_終了").val(),
					予定終了日_開始 : $("#人数_開始").val(),
					予定終了日_終了 : $("#人数_終了").val(),
				};

				//alert(JSON.stringify(JSONdata));

				$.ajax({
					type : 'POST',
					url : "http://localhost:8080/JavaMiddleClassCompleteSource/案件search",
					dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
					contentType : "application/json",

					data : JSON.stringify(JSONdata),
					success : function(data) {
						success(data);
					},
					error : function(e) {
						console.log(e);
						alert("AJAXの検索処理はERRORがあり by Yan");
					}
				});
			});

		});

		// Ajax通信成功時処理
		function success(data) {
			/* 			$("#emlist").empty();
			 buildHtmlTable(data,$("#emlist")); */
			$("#example-table").tabulator({
				height : "311px",
				layout : "fitColumns",
				placeholder : "No Data Set",

				columns : [ {
					title : "s_ID",
					field : "s_ID",
					sorter : "string",
					sorter : "boolean",
					cellClick : function(e, cell) {
						oneRowClick(cell.getValue())
					}
				},{
					title : "案件名称",
					field : "案件名称",
					sorter : "string",
					sorter : "boolean",
					cellClick : function(e, cell) {
					    var row = cell.getRow();
					    var data = row.getData();
					    oneRowClick(data.s_ID);
					}
				}, {
					title : "案件概要",
					field : "案件概要",
					sorter : "string",
					width : 200,
					sorter : "boolean"
				}, {
					title : "案件場所",
					field : "案件場所",
					sorter : "string",
					width : 200,
					sorter : "boolean"
				}, {
					title : "職種",
					field : "職種",
					sorter : "string",
					sorter : "boolean"
				}, {
					title : "工程",
					field : "工程",
					sorter : "string",
					align : "left"
					}
				, {
					title : "案件開始日",
					field : "案件開始日",
					sorter : "date",
					align : "left"
					}
				, {
					title : "予定終了日",
					field : "予定終了日",
					sorter : "date",
					align : "left"
					}
				, {
					title : "実際終了日",
					field : "実際終了日",
					sorter : "date",
					align : "left"
					}
				, {
					title : "人数",
					field : "人数",
					sorter : "string",
					align : "right"
					}
				],
				rowClick : function(e, row) {
					/* alert("Row " + row.getIndex() + " Clicked!!!!"); */

				},
			});
			$("#example-table").tabulator("setData", data);
		}
		function oneRowClick(selectedID) {
			/* 			alert(selected名称);
			 alert("oneRowClick IS RUN HERE!!");
			 */
			var JSONdata = {
				s_ID : selectedID
			};

			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/JavaMiddleClassCompleteSource/案件search",
				dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
				contentType : "application/json",

				data : JSON.stringify(JSONdata),

				success : function(data) {
					/* 					var obj = eval("("+data+")");
					 if(obj.success==undefined){//查询成功，跳转到详情页面 */
					if(data[0]){
						$("#s_ID").val(data[0].s_ID);
						$("#案件名称").val(data[0].案件名称);
						$("#案件概要").val(data[0].案件概要);
						$("#案件場所").val(data[0].案件場所);
						$("#職種").val(data[0].職種);
						$("#工程").val(data[0].工程);
						$("#案件開始日").val(data[0].案件開始日);
						$("#予定終了日").val(data[0].予定終了日);
						$("#実際終了日").val(data[0].実際終了日);
						$("#人数").val(data[0].人数);

						//---------------------------------
						$("#theForm").attr("action",
								"http://localhost:8080/JavaMiddleClassCompleteSource/案件edit");
						$("#theForm").submit();
						//---------------------------------
					}else{
						alert("没有找到检索对象。");
					}

				},
				error : function(e) {
					alert("AJAXの編集処理はERRORがあり by Yan");
				}
			});
		}

		function oneRowDeleteClick(selectedID) {

			var JSONdata = {
					s_ID : selectedID
			};

			alert(JSON.stringify(JSONdata));

			$.ajax({
				type : 'POST',
				url : "http://localhost:8080/JavaMiddleClassCompleteSource/案件delete",
				dataType : "json", //dataType设置成 json，这个意思是说 ’服务器的数据返回的是json格式数据，需要帮我把数据转换成对象
				contentType : "application/json",

				data : JSON.stringify(JSONdata),
				success : function(data) {

					$("#theForm").attr("action",
							"http://localhost:8080/JavaMiddleClassCompleteSource/案件search");
					$("#theForm").submit();
				},
				error : function(e) {
					alert("AJAXの削除処理はERRORがあり by Yan");
				}
			});
		}

		// Ajax通信失敗時処理
		function error(XMLHttpRequest, textStatus, errorThrown) {
			alert("error:" + XMLHttpRequest);
			alert("status:" + textStatus);
			alert("errorThrown:" + errorThrown);
		}
	</script>
	<form name="theForm" id="theForm" method="get" action="http://localhost:8080/JavaMiddleClassCompleteSource/add案件">
		<h1>案件情報</h1>
		<br>
		<div>
			<input id="s_ID" name="s_ID" type="hidden" Value="">
		</div>
		<div>
			<label>案件名称</label> <input id="案件名称" name="案件名称" type="text" value="">
		</div>
		<br>
		<div>
			<label>案件概要</label> <input id="案件概要" name="案件	概要" type="text" value="">
		</div>
		<br>
		<div>
			<label>案件場所</label> <input id="案件場所" name="案件場所" type="text" value="">
		</div>
		<br>
		<div>
			<label>職種</label> <input id="職種" name="職種" type="text" value="">
		</div>
		<br>
		<div>
			<label>工程</label> <input id="工程" name="工程" type="text" value="">
		</div>
		<br>
		<div>
			<label>案件開始日</label> <input id="案件開始日_開始" type="text" value="" placeholder="YYYY/MM/DD"> ～ <input id="案件開始日_終了" type="text" value="" placeholder="YYYY/MM/DD">
			<div id="caleandar"></div>
			<input id="案件開始日" name="案件開始日" type="hidden" value="">
		</div>
		<br>
		<div>
			<label>予定終了日</label> <input id="予定終了日_開始" type="text" value="" placeholder="YYYY/MM/DD"> ～ <input id="予定終了日_終了" type="text" value="" placeholder="YYYY/MM/DD">
			<input id="予定終了日" name="予定終了日" type="hidden" value="">
		</div>
		<br>
		<div>
			<label>実際終了日</label> <input id="実際終了日_開始" type="text" value="" placeholder="YYYY/MM/DD"> ～ <input id="実際終了日_終了" type="text" value="" placeholder="YYYY/MM/DD">
			<input id="実際終了日" name="実際終了日" type="hidden" value="">
		</div>
		<br>
		<div>
			<label>人数</label> <input id="人数_開始" type="text" value="" placeholder="YYYY/MM/DD"> ～ <input id="人数_終了" type="text" value="" placeholder="YYYY/MM/DD">
			<input id="人数" name="人数" type="hidden" value="">
		</div>
		<br>
		<div>
			<input type="button" id="search_btn" value="検索"> <input type="submit" id="add_btn" value="追加">
		</div>
		<br>
		<div>
			<table id="emlist" style="width: 70%">
				<thead>
					<tr>
						<th></th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<br>
		<div>
		    <div id="example-table"></div>
		</div>
	</form>



</body></html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>技術者検索</title>
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
	$(
			function() {
				$("#search_btn").click(
						function() {
							alert("search_btn");
							var JSONdata = {
									姓名 : $("#姓名").val(),
									性别 : $("#性别").val(),
									生年月日_开始 : $("#生年月日_开始").val(),
									生年月日_终了 : $("#生年月日_终了").val()
							}
							$.ajax({
								type : 'POST',
								url : "http://localhost:8080/JavaMiddleClassCompleteSource/技術者search",
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
						}
				);
			}
	);
	</script>

		<h1>技術者検索</h1>
		<br>
		<div>
			<input id="s_ID" name="s_ID" type="hidden" Value="">
		</div>
		<br>
		<div>
			<label>姓名</label> <input id="姓名" name="姓名" type="text" value="">
		</div>
		<div>
			<label>性别</label> <input id="性别" name="性别" type="text" value="">
		</div>
		<div>
			<label>生年月日_开始</label> <input id="生年月日_开始" name="生年月日_开始" type="text" value="">
		</div>
		<div>
			<label>生年月日_终了</label> <input id="生年月日_终了" name="生年月日_终了" type="text" value="">
		</div>
		<div>
			<label>年数-开始年月</label> <input id="年数-开始年月開始" name="年数-开始年月開始" placeholder="YYYY/MM" type="text" value="">〜 <input id="年数-开始年月終了" name="年数-开始年月終了" placeholder="YYYY/MM" type="text" value="">
		</div>
		<div>
			<label>技术备考说明</label> <input id="技术备考说明" name="技术备考说明" type="text" value="">
		</div>
		<br>
		<div>
			<label>经验案件名</label> <input id="经验案件名" name="经验案件名" type="text" value="">
		</div>
		<div>
			<label>经验案件概要</label> <input id="经验案件概要" name="经验案件概要" type="text" value="">
		</div>
		<div>
			<label>经验案件地点</label> <input id="经验案件地点" name="经验案件地点" type="text" value="">
		</div>
		<div>
			<label>担当职种</label> <input id="担当职种" name="担当职种" type="text" value="">
		</div>
		<div>
			<label>所在工程</label> <input id="所在工程" name="所在工程" type="text" value="">
		</div>
		<div>
			<label>开始时间</label> <input id="开始时间開始" name="开始时间開始" placeholder="YYYY/MM" type="text" value="">〜 <input id="开始时间終了" placeholder="YYYY/MM" name="开始时间終了" type="text" value="">
		</div>
		<div>
			<label>经验月数</label> <input id="经验月数開始" name="经验月数開始" type="text" value="">〜 <input id="经验月数終了" name="经验月数終了" type="text" value="">
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
</body>
</html>
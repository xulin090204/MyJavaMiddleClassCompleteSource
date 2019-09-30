<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>案件明細</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>


</head>
<body>
	<script>
	$(function() {
		$("#back_btn").click(function() {
		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/back案件検索");
		    $("#fbean").submit();
		});

		$("#save_btn").click(function() {
			if("${モード}" == "編集"){
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/案件update");
			    $("#fbean").submit();

			}else{
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/案件save");
			    $("#fbean").submit();
			}
		});

	});

	</script>

	<form id ="fbean" name="fbean" method="post">

	<h1>${titleName}</h1>

	<input type="hidden" value="${案件ID}" name="案件ID"/>

	<div>
		<label>案件名称</label>
		<input type="text" value="${案件名称}" name="案件名称"/>
		<input type="hidden" value="${案件名称}" name="old_案件名称" />
	</div>
	<br>
	<div>
		<label>案件概要</label>
		<input type="text" value="${案件概要}" name="案件概要" />
		<input type="hidden" value="${案件概要}" name="old_案件概要" />
	</div>
	<br>
	<div>
		<label>案件場所</label>
		<input type="text" value="${案件場所}" name="案件場所" />
		<input type="hidden" value="${案件場所}" name="old_案件場所" />
	</div>
	<br>
	<div>
		<label>担当職種</label>
		<input type="text" value="${担当職種}" name="担当職種" />
		<input type="hidden" value="${担当職種}" name="old_担当職種" />
	</div>
	<br>
	<div>
		<label>所在工程</label>
		<input type="text" value="${所在工程}" name="所在工程" />
		<input type="hidden" value="${所在工程}" name="old_所在工程" />
	</div>
	<br>
	<div>
		<label>作業開始年月日</label>
		<input type="text" value="${作業開始年月日}"
			placeholder="YYYY/MM/DD"
			type="text" name="作業開始年月日"/>
		<input type="hidden" value="${作業開始年月日}" name="old_作業開始年月日" />
	</div>
	<br>
	<div>
		<label>作業预计终了年月</label>
		<input type="text" value="${作業预计终了年月}"
			placeholder="YYYY/MM/DD"
			type="text" name="作業预计终了年月"/>
		<input type="hidden" value="${作業预计终了年月}" name="old_作業预计终了年月" />
	</div>
	<br>
	<div>
		<label>作業实际终了年月</label>
		<input type="text" value="${作業实际终了年月}"
			placeholder="YYYY/MM/DD"
			type="text" name="作業实际终了年月"/>
		<input type="hidden" value="${作業实际终了年月}" name="old_作業实际终了年月" />
	</div>
	<br>
	<div>
		<label>募集人数</label>
		<input type="text" Value="${募集人数}" name="募集人数"
			placeholder="例。5"
			type="text"/>
		<input type="hidden" value="${募集人数}" name="old_募集人数" />
	</div>
	<br>
	<div>
		<label>チーム人数</label>
		<input type="text" Value="${チーム人数}" name="チーム人数"
			placeholder="例。20"
			type="text"/>
		<input type="hidden" value="${チーム人数}" name="old_チーム人数" />
	</div>
	<br>
	<div>
		<label>開発言語</label>
		<input type="text" Value="${開発言語}" name="開発言語"
			placeholder="例。Java"
			type="text"/>
		<input type="hidden" value="${開発言語}" name="old_開発言語" />
	</div>
	<br>
	<div>
		<label>FrameWork</label>
		<input type="text" Value="${FrameWork}" name="FrameWork"
			placeholder="例。SpringMVC"
			type="text"/>
		<input type="hidden" value="${FrameWork}" name="old_FrameWork" />
	</div>
	<br>
	<div>
		<label>ツール</label>
		<input type="text" Value="${ツール}" name="ツール"
			placeholder="例。Git"
			type="text"/>
		<input type="hidden" value="${ツール}" name="old_ツール" />
	</div>
	<br>

	<div>
		<label>OS</label>
		<input type="text" Value="${OS}" name="OS"
			placeholder="例。Windows"
			type="text"/>
		<input type="hidden" value="${OS}" name="old_OS" />
	</div>
	<br>

	<div>
		<label>DB</label>
		<input type="text" Value="${DB}" name="DB"
			placeholder="例。Postgre"
			type="text"/>
		<input type="hidden" value="${DB}" name="old_DB" />
	</div>
	<br>

	<div>
		<input type="button" id="back_btn" Value="戻る">
	</div>
	<br>

	<div>
		<input type="button" id="save_btn" Value="登録">
	</div>

	<h1>${errorMsg}</h1>
</form>
</body>
</html>

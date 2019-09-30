<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--
<link rel="stylesheet" href="css/smoothness/jquery-ui-1.10.4.custom.min.css" type="text/css" />
<link rel="stylesheet" href="css/common/np.css" type="text/css" />
<link rel="stylesheet" href="css/common/bussinessSupportWeb.css" type="text/css" />
 -->
 <link rel="stylesheet" href="css/my.css" type="text/css" />
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<!-- 	<script type="text/javascript">
    //取得指定id的对象
    function getObj(id){
        return document.getElementById(id);
    }
    //添加行函数
    function add技术情報Row(tabName){
        //取得table的对象
        var tab=getObj(tabName);
        //添加行
        var row=tab.insertRow(tab.rows.length);
        //添加三列
        var 技术方向Cell=row.insertCell(row.cells.length);
        var 技术项目Cell=row.insertCell(row.cells.length);
        var 资格等级Cell=row.insertCell(row.cells.length);
		var 年数Cell=row.insertCell(row.cells.length);
		var 开始年月Cell=row.insertCell(row.cells.length);
		var 技术备考说明Cell=row.insertCell(row.cells.length);

        //给name输入栏和address输入栏赋值
        nameCell.innerHHTML="张三"; // 最好有下拉框并附上选项，同时还可以编辑
        addressCell.innerHTML="北京";
        //在第三列加上删除当前列按钮        

        buttonCell.innerHTML='<input value="删除"type="button"onclick="deleteRow(this)"/>';
    }
    //删除列函数，删除方法传入参数为行的索引
    function deleteRow(obj){
        var row=obj.parentNode.parentNode;
        var tab=row.parentNode;
        tab.deleteRow(row.rowIndex);
    }
</script> -->
<script>
	$(function() {
		$("#back_btn").click(function() {
		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/技術者back");
		    $("#fbean").submit();
		});

		$("#report_btn").click(function() {
		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/技術者report");
		    $("#fbean").submit();
		});

		$("#save_btn").click(function() {
 	//		if("${モード}" == "編集"){
	//		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/技術者update");
	//		    $("#fbean").submit();

	//		}else{
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/技術者save");
			    $("#fbean").submit();
	//		}
		});
	});
	</script>
	<script>
	// Jquery动态给表格添加、删除行
	// https://blog.csdn.net/u011955534/article/details/16809023
	var i技術項目_情報追加した件数 = 0;
	$(document).ready(function(){
		$("#btn_ADD技術情報").click(function(){
			var tr = "<tr class='CaseRow'>";
			tr += "<td><input type='text' style='font-size:24px;' id='技术方向' name='技術項目_情報[" + i技術項目_情報追加した件数 + "][技術方向]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='技术项目' name='技術項目_情報[" + i技術項目_情報追加した件数 + "][技術項目]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='资格_等级' name='技術項目_情報[" + i技術項目_情報追加した件数 + "][资格_等级]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='年数' name='技術項目_情報[" + i技術項目_情報追加した件数 + "][年数]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='开始年月' name='技術項目_情報[" + i技術項目_情報追加した件数 + "][年数_开始年月]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='技术备考说明' name='技術項目_情報[" + i技術項目_情報追加した件数 + "][備考説明]'></input></td>";
			tr += "<td><input type='checkbox' /></td></tr>";

			//$("table").append(tr);//向table中追加tr
			$("#table_技術情報").append(tr);//向table中追加tr
			i技術項目_情報追加した件数++;
		});
		$("#btn_DEL技術情報").click(function(){
			var num=$("#t1 tr").filter(".CaseRow").size();//获得表格行数
			// alert(num);
			if(num==1){
				// alert("留一行，好不好");
				return;
			}
			var t=$("input:checked").parent().parent("tr").remove();//移除选中的行
		});
		var i経験案件追加した件数 = 0;
		$("#btn_ADD経験案件情報").click(function(){
			// 参考的资料 https://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/
			// https://stackoverflow.com/questions/31967899/spring-mvc-hashmap-form-integration
			var tr = "<tr class='CaseRow'>";
			tr += "<td><input type='text' style='font-size:24px;' id='经验案件名' name='経験_案件情報[" + i経験案件追加した件数 + "][案件名称]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='经验案件概要' name='経験_案件情報[" + i経験案件追加した件数 + "][案件概要]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='经验案件場所' name='経験_案件情報[" + i経験案件追加した件数 + "][案件場所]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='担当職種' name='経験_案件情報[" + i経験案件追加した件数 + "][担当職種]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='所在工程' name='経験_案件情報[" + i経験案件追加した件数 + "][所在工程]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='作業開始年月日' name='経験_案件情報[" + i経験案件追加した件数 + "][作業開始年月日]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='作業实际终了年月' name='経験_案件情報[" + i経験案件追加した件数 + "][作業实际终了年月]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='募集人数' name='経験_案件情報[" + i経験案件追加した件数 + "][募集人数]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='チーム人数' name='経験_案件情報[" + i経験案件追加した件数 + "][チーム人数]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='開発言語' name='経験_案件情報[" + i経験案件追加した件数 + "][開発言語]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='FrameWork' name='経験_案件情報[" + i経験案件追加した件数 + "][FrameWork]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='ツール' name='経験_案件情報[" + i経験案件追加した件数 + "][ツール]'></input></td>";
			tr += "<td><input type='text' style='font-size:24px;' id='OS' name='経験_案件情報[" + i経験案件追加した件数 + "][OS]'></input></td>";
			tr += "<td><input type='text' id='DB' name='経験_案件情報[" + i経験案件追加した件数 + "][DB]'></input></td>";
			tr += "<td><input type='checkbox' /></td></tr>";

			//$("table").append(tr);//向table中追加tr
			$("#table_経験案件情報").append(tr);//向table中追加tr
			i経験案件追加した件数++;

		});
		$("#btn_DEL経験案件情報").click(function(){
			var num=$("#t1 tr").filter(".CaseRow").size();//获得表格行数
			// alert(num);
			if(num==1){
				// alert("留一行，好不好");
				return;
			}
			var t=$("input:checked").parent().parent("tr").remove();//移除选中的行
		});
	});

</script>

<form id ="fbean" name="fbean" method="post">
<body class=" l-np-base">
<!--
table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
th{font-weight:bold;background:#ccc;}

 -->
<table width="1150" style="border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;" >
	<thead>
		<tr>
			<td colspan="12" align="center" style="border-right:1px solid #888;border-bottom:1px solid #888;padding:0px 0px;"><span><label style="font-size:44px;">技　術　者　経　歴　書</label></span>
			</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan="8"></td>
			<td align="center">作成日</td>
			<td colspan="3">
				<input disabled id="生年月日" name="生年月日" type="text" value="" style="width:120px;font-size:24px;">
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>姓名</label>
			</td>
			<td colspan="2">
				<input id="姓名" name="姓名" type="text" value="库大库路马拉可林不拉夫斯基" style="width:400px;font-size:24px;">
			</td>
			<td align="center">性别</td>
			<td>
				<input id="性别" name="性别" type="text" value="男" style="width:40px;font-size:24px;">
			</td>
			<td  colspan="2" align="center">出生年月</td>
			<td colspan="5">
				<input id="生年月日" name="生年月日" type="text" value="19900101" style="width:120px;font-size:24px;">
			</td>
		</tr>
		<tr>
			<td align="center">会社名</td>
			<td colspan="7">
				<input id="会社名" name="会社名" type="text" value="宝鸡有一群怀揣着梦想的少年相信在牛大叔的带领下会创造生命的奇迹网络科技有限公司" style="width:700px;font-size:24px;" >
			</td>
			<td align="center">TEL</td>
			<td colspan="3">
				<input id="TEL" name="TEL" type="text" value="09000000000" style="width:170px;font-size:24px;">
			</td>
		</tr>
		<tr>
			<td align="center" >最寄駅</td>
			<td colspan="7" >
				<input id="最寄駅" name="最寄駅" type="text" value="JR長者ヶ浜潮騒はまなす公園前" style="width:400px;font-size:24px;"></td>
			<td align="center" >FAX</td>
			<td colspan="3">
				<input id="FAX" name="FAX" type="text" value="09000000000" style="width:170px;font-size:24px;">
			</td>
		</tr>
		<tr>
			<td align="center">毕业院校</td>
			<td colspan="4">
				<input id="毕业院校" name="学歴" type="text" value="国立大学法人北陸先端科学技術大学院大学" style="width:500px;font-size:24px;">
			</td>
			<td colspan="2" align="center">学位</td>
			<td>
				<input id="最終学位" name="最終学位" type="text" value="学士" style="width:80px;font-size:24px;">
			</td>
			<td align="center">就職開始年月</td>
			<td colspan="3">
				<input id="就職開始年月" name="就職開始年月" type="text" value="201501" style="width:100px;font-size:24px;">
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<label style="font-size:24px;">語学力</label>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">日本語（読み）</td>
			<td >
				<input id="日本語読み能力" name="日本語読み能力" type="text" value="1" style="width:40px;font-size:24px;">
				　1,優；　【2,良】；　3,可</td>
			<td align="center" colspan="3">英語（読み）</td>
			<td colspan="5">
				<input id="英語読み能力" name="英語読み能力" type="text" value="1" style="width:40px;font-size:24px;">
				　1,優；　【2,良】；　3,可
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">　　　（書き）</td>
			<td >
				<input id="日本語書き能力" name="日本語書き能力" type="text" value="1" style="width:40px;font-size:24px;">
				　1,優；　【2,良】；　3,可</td>
			<td align="center" colspan="3">　　　（書き）</td>
			<td colspan="5">
				<input id="英語書き能力" name="英語書き能力" type="text" value="1" style="width:40px;font-size:24px;">
				　1,優；　【2,良】；　3,可</td>
		</tr>
		<tr>
			<td align="center" colspan="2">　 　 （会話）
			</td>
			<td >
				<input id="日本語会話能力" name="日本語会話能力" type="text" value="1" style="width:40px;font-size:24px;">
				　1,優；　【2,良】；　3,可
			</td>
			<td align="center" colspan="3">　 　 （会話）
			</td>
			<td colspan="5">
				<input id="英語会話能力" name="英語会話能力" type="text" value="1" style="width:40px;font-size:24px;">
				　1,優；　【2,良】；　3,可
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">日本語レベル
			</td>
			<td  >
				<input id="日本語レベル" name="日本語レベル" type="text" value="1" style="width:100px;font-size:24px;">
			</td>
			<td align="center" >英検
			</td>
			<td colspan="6">
				<input id="英検点数" name="英検点数" type="text" value="1" style="width:100px;font-size:24px;">
			</td>
		</tr>
		<tr>

		</tr>
		<tr>
			<td align="center" colspan="2">仕事(留学)経験有無
			</td>
			<td>
				<input id="仕事_留学_経験有無" name="仕事_留学_経験有無" type="text" value="" style="width:100px;font-size:24px;">
			</td>
			<td align="center" colspan="4">仕事(留学)経験開始年月
			</td>
			<td colspan="3">
				<input id="仕事_留学_経験開始年月" name="仕事_留学_経験開始年月" type="text" value="" style="width:100px;font-size:24px;">
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<label style="font-size:24px;">技術情報</label>
			</td>
		</tr>
		<tr><td colspan="12">
			<table height="36" border="1" id="table_技術情報" width="1150" style="border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;" >
				<thead>
					<tr>
						<th width="120" height="30" scope="col">技術方向</th>
						<th width="120" scope="col">技術項目</th>
						<th width="120" scope="col">资格_等级</th>
						<th width="60" scope="col">年数</th><!-- 年数与开始年月、任填其一即可，但不允许有矛盾的存在 -->
						<th width="120" scope="col">开始年月</th><!-- 年数与开始年月、任填其一即可，但不允许有矛盾的存在 -->
						<th width="220" scope="col">備考説明</th>
						<th width="30" scope="col">削除</th>
					</tr>
				</thead>
				<tbody>
			        <c:if test="${not empty 技術項目_情報}">
				        <c:forEach items="${技術項目_情報}" var="技術情報"  varStatus="itemsRow">
				         <tr>
				        	<c:forEach items="${技術情報}" var="技術情報項目">
					            <td>
									<!-- name 是用来返回数据的时候，指示该传给servlet哪个值 -->
									<!-- id 是给Jquery用的 -->
									<!-- value 是从服务器传过来的值 -->
					            	<!-- <input id="技術情報項目" type="text" name="${技術情報項目.key}" value="${技術情報項目.value}"> -->
					            	<input id="技術情報項目" type="text" name="" value="${技術情報項目.value}">
					            </td>
				            </c:forEach>
				         </tr>
				        </c:forEach>
					</c:if>
				</tbody>
			    <tfoot>
			    </tfoot>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<input type="button" value="ADD技術情報" id="btn_ADD技術情報"/>
				<input type="button" value="DEL技術情報" id="btn_DEL技術情報"/>
			</td>
		</tr>
		<tr>
			<td colspan="12">
				<label style="font-size:24px;">経験案件情報</label>
			</td>
		</tr>
		<tr><td colspan="12">
			<table width="1550" height="36" border="1" id="table_経験案件情報" name="経験_案件情報" style="border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;">
			<thead>
				<tr>
					<th width="320" height="30" scope="col">经验案件名称</th>
					<th width="320" scope="col">经验案件概要</th>
					<th width="220" scope="col">经验案件場所</th>
					<th width="160" scope="col">担当職種</th><!-- 年数与开始年月、任填其一即可，但不允许有矛盾的存在 -->
					<th width="220" scope="col">所在工程</th><!-- 年数与开始年月、任填其一即可，但不允许有矛盾的存在 -->
					<th width="120" scope="col">作業開始年月日</th>
					<th width="120" scope="col">作業实际终了年月</th>
					<th width="120" scope="col">募集人数</th>
					<th width="120" scope="col">チーム人数</th>
					<th width="120" scope="col">開発言語</th>
					<th width="220" scope="col">FrameWork</th>
					<th width="220" scope="col">ツール</th>
					<th width="120" scope="col">OS</th>
					<th width="120" scope="col">DB</th>
					<th width="30" scope="col">削除</th>
				</tr>
			</thead>
			<tbody>
			        <c:if test="${not empty 経験_案件情報}">
				        <c:forEach items="${経験_案件情報}" var="案件情報"  varStatus="itemsRow">
				         <tr>
				        	<c:forEach items="${案件情報}" var="案件情報項目">
					            <td>
									<!-- name 是用来返回数据的时候，指示该传给servlet哪个值 -->
									<!-- id 是给Jquery用的 -->
									<!-- value 是从服务器传过来的值 -->
					            	<!-- <input id="案件情報項目" type="text" name="${案件情報項目.key}" value="${案件情報項目.value}"> -->
					            	<input id="案件情報項目" type="text" name="" value="${案件情報項目.value}">
					            </td>
				            </c:forEach>
				         </tr>
				        </c:forEach>
					</c:if>
			</tbody>
		    <tfoot>
		    </tfoot>
			</table>
		</td>
		</tr>
		<tr>
			<td colspan="12">
				<input type="button" value="ADD経験案件情報" id="btn_ADD経験案件情報"/>
				<input type="button" value="DEL経験案件情報" id="btn_DEL経験案件情報"/>
			</td>
		</tr>
		</tbody>
		</table>

	<div>
		<input type="button" id="report_btn" Value="技術者履歴書出力">
	</div>
		<div>
			<input type="button" id="save_btn" value="登録">
		</div>
		<div>
			<input type="button" id="back_btn" value="戻る">
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
</form>
</html>
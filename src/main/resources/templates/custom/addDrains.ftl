

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>新增或编辑客户流失信息</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script type="text/javascript" src="${request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
    <script src="${request.contextPath}/static/scripts/boot.js" type="text/javascript"></script>
    <style type="text/css">
        html, body
        {
            font-size:12px;
            padding:0;
            margin:0;
            border:0;
            height:100%;
            overflow:hidden;
        }
        table tr{
            height: 38px;
        }
        .mini-listbox-items tr{
            height:28px;
        }
    </style>
</head>
<body>

<form id="form1" method="post">
    <input name="id" class="mini-hidden" />
    <div style="padding-left:11px;padding-bottom:5px;">
        <table style="table-layout:fixed;">
            <tr>
                <td style="width:70px;">客户名称：</td>
                <td style="width:150px;">
                    <input name="customerName" class="mini-textbox" required="true" readonly/>
                </td>
                <td >最后订单时间：</td>
                <td >
                    <input id="lastOrderDate" name="lastOrderDate" class="mini-datepicker" value="2018-01-01" required="true"  readonly/>
                </td>
            </tr>
            <tr>
                <td >流失原因：</td>
                <td colspan="3" >
                    <input name="reason" class="mini-textarea" required="true" width="200px" emptyText="请输入流失原因"/>
                </td>
            </tr>
        </table>
    </div>
    <div style="text-align: center; padding: 6px;position: absolute;bottom: 0px;background: #eee;width: 100%;">
        <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>
        <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>
    </div>
</form>
<script type="text/javascript">
    var statu=[{id:'流失预警',name:'流失预警'},{id:'确认流失',name:'确认流失'},{id:'暂缓流失',name:'暂缓流失'}];

    mini.parse();

    var form = new mini.Form("form1");

    function onBirthdayRenderer(e) {
        var value = e.value;
        if (value) return mini.formatDate(value, 'yyyy-MM-dd');
        return "";
    }

    function SaveData() {
        var o = form.getData();
        form.validate();
        if (form.isValid() == false) return;
        $.ajax({
            url: "/customerDrains/okDrains",
            type: 'post',
            data: o,
            cache: false,
            success: function (text) {
                if(text.state==0){
                    CloseWindow("save");
                }else{
                    mini.alert("确认流失失败",text.message);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                mini.alert(jqXHR.responseText);
                CloseWindow();
            }
        });
    }

    //标准方法接口定义
    function SetData(data) {
        if (data.action == "edit") {
            //跨页面传递的数据对象，克隆后才可以安全使用
            data = mini.clone(data);
            $.ajax({
                url: "/customerDrains/findById?id=" + data.id,
                cache: false,
                success: function (text) {
                    var drains=text.data;
                    drains.drainDate=new Date(drains.drainDate);
                    drains.lastOrderDate=new Date(drains.lastOrderDate);
                    var o = mini.decode(drains);
                    form.setData(o);
                    form.setChanged(false);
                }
            });
        }
    }

    function GetData() {
        var o = form.getData();
        return o;
    }
    //
    function CloseWindow(action) {
        if (action == "close" && form.isChanged()) {
            if (confirm("数据被修改了，是否先保存？")) {
                return false;
            }
        }
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    }
    //
    function onOk(e) {
        SaveData();
    }
    //
    function onCancel(e) {
        CloseWindow("cancel");
    }
    //
    function isClear() {
        var pid = mini.getbyName("pid");
        pid.setValue("");
    }
</script>
</body>
</html>

var common = function(){
    /*
    * 获取系统配置
    */
    this.getConfigMap = function(){
        var defaultData = null;
        $.ajax({
            type: "post",
            async: false,//同步，异步
            url: "/hy/login/defaultconfig", //请求的服务端地址
            dataType: "json",
            success:function(data){
                console.log(data);
                defaultData = data;
            },
            error:function(i, s, e){
                flag = false;
                alert('error'); //错误的处理
            }
        });
        return defaultData;
    }
}
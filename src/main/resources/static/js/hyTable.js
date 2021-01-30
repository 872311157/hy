$(function() {
    var newscript = document.createElement('script');
    newscript.setAttribute('type','text/javascript');
    newscript.setAttribute('src','/hy/system/hyModule/hyModule_list.js');
    var head = document.getElementsByTagName('head')[0];
    head.appendChild(newscript);

    var configMap = window.parent.configMap;
    var HyTableObj = new Object();
    HyTableObj.vueId;
    HyTableObj.searchName = "queryPageList";
    HyTableObj.params;

    HyTableObj.createVue = function(){
        debugger
        if (hyModule_list.setPageInfo){
            if(HyTableObj.vueId){
                var pageInfo = HyTableObj.getPageInfo();
                var vue = new Vue({
                el: HyTableObj.vueId,
                data: {
                    configMap: configMap,
                    searchName: HyTableObj.searchName,
                    params: HyTableObj.params
                },
                methods: {

                }
                })
                return vue;
            }else{
                alert("not found HyTableObj.vueId!");
            }
        }else{
            alert("not found HyTableObj.setPageInfo!");
        }
    }

    HyTableObj.getPageInfo = function(){
        debugger;
        var pageInfo = {};
        pageInfo.vueId = "#hyModule";
        pageInfo.searchName = "queryPageList";
        pageInfo.params = {mname: ''};
        return pageInfo;
    }

    var vue = HyTableObj.createVue();
})

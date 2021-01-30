    var configMap = window.parent.configMap;
    var HyTableObj = new Object();
    HyTableObj.vueId;
    HyTableObj.searchName = "queryPageList";
    HyTableObj.params;

    HyTableObj.createVue = function(){
        debugger
        if(HyTableObj.vueId){
            var pageInfo = HyTableObj.getPageInfo();
            var vue = new Vue({
            el: "#" + HyTableObj.vueId,
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
    }

    HyTableObj.getPageInfo = function(){
        debugger;
        var pageInfo = {};
        pageInfo.vueId = "#hyModule";
        pageInfo.searchName = "queryPageList";
        pageInfo.params = {mname: ''};
        return pageInfo;
    }

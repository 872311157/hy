//$(function() {
//    var configMap = window.parent.configMap;
//    var vue = new Vue({
//        el: "#hyModule",
//        data: {
//            configMap: configMap,
//            searchName: 'queryPageList',
//            params: {
//                mname: ''
//            }
//        },
//        methods: {
//
//        }
//    })
//})

$(function(){
    HyTableObj.vueId = "hyModule";
    HyTableObj.createVue();

})

//var hyModule_list = function(){
//    var page = 13;
//    this.data = '3456';
//    this.setPageInfo = function(){
//        debugger
//        HyTableObj.vueId = "hyModule";
//        HyTableObj.searchName = "queryPageList";
//    }
//
//}


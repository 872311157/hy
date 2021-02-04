var pageInfo;
$(function(){
    var configMap = window.parent.configMap;
    pageInfo = new HySearchPage();
    pageInfo.vueId = "hyModule_list";
    pageInfo.moduleName = "hyModule";
    pageInfo.configMap = configMap;
    pageInfo.insertPage = "system/hyModule/hyModule_add.html";
    pageInfo.modifyPage = "system/hyModule/hyModule_modify.html";
    pageInfo.setPageInfo("500px", "350px");
    pageInfo.createVue();
})



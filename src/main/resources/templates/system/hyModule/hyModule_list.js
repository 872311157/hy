$(function(){
    var configMap = window.parent.configMap;
    var hySearchPage = new HySearchPage();
    hySearchPage.vueId = "hyModule_list";
    hySearchPage.moduleName = "hyModule";
    hySearchPage.configMap = configMap;
    var vue = hySearchPage.createVue();
    console.log(vue.$refs);
})



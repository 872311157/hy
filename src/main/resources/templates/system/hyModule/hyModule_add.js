$(function(){
    var hyInfoPage = new HyInfoPage();
    hyInfoPage.vueId = "hyModule_add";
    hyInfoPage.moduleType = "insert";
    alert(JSON.stringify(hyInfoPage));
    var vue = hyInfoPage.createVue();
    console.log(vue.$refs);

})
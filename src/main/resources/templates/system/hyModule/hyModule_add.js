$(function(){
    var HyInfoPage = new HyInfoPage();
    HyInfoPage.vueId = "hyModule_add";
    HyInfoPage.moduleType = "insert";
    alert(JSON.stringify(HyInfoPage));
    var vue = HyInfoPage.createVue();
    console.log(vue.$refs);

})
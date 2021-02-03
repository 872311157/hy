/*
列表
*/
var HySearchPage = function(){
    this.vueId;
    this.configMap;
    this.moduleName;
    this.searchName = "queryPageList";
    this.params= {
        pageNum: 1,
        pageSize: 10
    };

    this.createVue = function(){
        debugger
        if(this.vueId || this.moduleName || this.configMap.server){
            var vue = new Vue({
            el: "#" + this.vueId,
            data: {
                params: this.params,
                config: {
                    moduleName: this.moduleName,
                    configMap: this.configMap,
                    searchName: this.searchName
                }
            },
            methods: {
                innerSearch: function(){
                    var vueTable = this.$refs.VueTable;
                    if(vueTable){
                        vueTable.pageNum = 1;
                        vueTable.search();
                    }
                },
                innerRest: function(){
                    this.params = {};
                    var vueTable = this.$refs.VueTable;
                    if(vueTable){
                        vueTable.pageNum = 1;
                        vueTable.params = {};
                        vueTable.search();
                    }
                },
                innerDelete: function(arg){

                },
                openInsertPage: function(){
                    var vueInfoPage = this.$refs.VueInfoPage;
                    if(vueInfoPage){
                        vueInfoPage.loadInsertPage("http://127.0.0.1:8090/hy/system/hyModule/hyModule_add.html", "500px", "350px");
                    }
                },
                openModifyPage: function(arg){

                },
                openDetailPage: function(arg){

                }
            }
            })
            return vue;
        }else{
            alert("not found HyTableObj.vueId!");
        }
    }
}

/*
表单
*/
var HyInfoPage = function(){
    this.vueId;
    this.moduleType;
    this.configMap;
    this.moduleName;
    this.searchName = "save";
    this.entityBean = {};

    this.createVue = function(){
        debugger
        if(this.vueId || this.moduleName || this.configMap.server){
            var vue = new Vue({
            el: "#" + this.vueId,
            data: {
                saveBean: this.entityBean
            },
            methods: {
                innerInfoSubmit: function(){
                    switch(this.moduleType) {
                         case "insert":
                            alert("save");
                            break;
                         case "modify":
                            alert("modify");
                            break;
                    }
                },
                innerRest: function(){
                    this.params = {};
                    var vueTable = this.$refs.VueTable;
                    if(vueTable){
                        vueTable.pageNum = 1;
                        vueTable.params = {};
                        vueTable.search();
                    }
                }
            }
            })
            return vue;
        }else{
            alert("not found HyTableObj.vueId!");
        }
    }
}
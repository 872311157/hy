    var configMap = window.parent.configMap;
    var HyTableObj = new Object();
    HyTableObj.vueId;
    HyTableObj.searchName = "queryPageList";
    HyTableObj.params= {
        pageNum: 1,
        pageSize: 10
    };

    HyTableObj.createVue = function(){
        debugger
        if(HyTableObj.vueId){
            var vue = new Vue({
            el: "#" + HyTableObj.vueId,
            data: {
                configMap: configMap,
                searchName: HyTableObj.searchName,
                params: HyTableObj.params
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
                innerInsert: function(){
                    var vueInfoPage = this.$refs.VueInfoPage;
                    if(vueInfoPage){
                        vueInfoPage.loadInsertPage("500px", "500px");
                    }
                },
                innerModify: function(arg){

                },
                innerDelete: function(arg){

                },
                innerDetail: function(arg){

                }
            }
            })
            return vue;
        }else{
            alert("not found HyTableObj.vueId!");
        }
    }

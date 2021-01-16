/*树形结构*/
Vue.component('vue-tree2', {
    props: ['bean'],
    template: '<ol class="tree">'+
        '<li v-for="module in modules">'+
            '<input v-if="box" type="checkbox" id="folder1"><label v-on:click="extend_nodes" class="folderOne" :nid="module.id">{{module.mname}}</label>'+
            '<ol style="display: none;" v-for="child in module.childs"><li class="file folderTwo"><label v-on:click="open_page" :nid="child.id" :psrc="child.maddress">{{child.mname}}</label></li></ol>'+
        '<li>'+
    '<ol>',
    data: function () {
        this.modules = this.init_modules();
        return {modules: this.modules,box: false}
    },
    methods: {
        init_modules: function(){
            debugger
            var modules;
            var userid = this.bean.userid;
            var url = this.bean.dataurl;
            $.ajax({
                type: "post",
                async: false,//同步，异步
                url: url, //请求的服务端地址
                data: {userid: this.bean.userid},
                dataType: "json",
                success:function(data){
//                    $(data).each(function(i, item){
//                        var childs = item.childs;
//                        $(childs).each(function(j, child){
//                            var mtype = child.mtype;
//                            if("1" == mtype){
//                                child.maddress = pageurl + child.maddress;
//                            }
//                        })
//                    })
                    modules = data;
                    console.log(data);
                },
                error:function(i, s, e){
                    flag = false;
                    alert('error'); //错误的处理
                }
            });
            return modules;
        },
        extend_nodes: function(arg){
            var ols = arg.target.parentNode.getElementsByTagName("ol");
            var len = ols.length;
            if(len > 0){
                Array.prototype.slice.call(ols).forEach(function(item, i){
                    var e = item.style.display;
                    if("block" == e || "" == e){
                        item.style.display = "none";
                    }else{
                        item.style.display = "block";
                    }
                })
            }
        },
        open_page: function(arg){
            var target = arg.target;
            var src = target.getAttribute("psrc");
            var server = this.$parent.bean.config.server;
            this.$parent.bean.pageurl = server + src;
        }
    }
})

Vue.component('tablebody', {
    props: [],
    template: '<table><tbody><tr v-for="data in items.result">@tdhtml</tr></tbody></table>',
    data: function () {
        debugger
        this.items = this.init_table();
        var tdhtml = this.setTdHtml(this.items);
        this.$options.template = this.$options.template.replace("@tdhtml", tdhtml);

        return {item: this.items}
    },
    methods: {
        init_table: function(arg){
            debugger
            var data = {'pageSize':10, 'result':[{'index':0,'name':'周三'},{'index':1,'name':'周四'}], 'resultmeta': ['index', 'name']};
            return data;
        },
        setTdHtml: function(arg){
            debugger
            var tdhtml = "";
            var stylemap = {};
            var resultmeta = this.items.resultmeta;
            var ths = $("table > thead").find("th");
            $(ths).each(function(index, item){
                debugger
                var width = item.style.width;
                var md = item.getAttribute("md");
                var stylehtml = "text-align: center; width: " + width + ";";
                stylemap[md] = stylehtml;
            })
            resultmeta.forEach(function(item){
                tdhtml += "<td style='" + stylemap[item] + "'>{{data." + item + "}}</td>";
            })
            return tdhtml;
        }
    }
})

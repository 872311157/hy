/*树形结构*/
Vue.component('vue-tree2', {
    props: ['bean'],
    template: '<ol class="tree">'+
        '<li class="folderOne" v-for="module in modules">'+
            '<input v-if="box" type="checkbox" id="folder1"><label v-on:click="extend_nodes" :nid="module.id">{{module.mname}}</label>'+
            '<ol style="display: none;" v-for="child in module.childs" ><li class="file folderTwo"><label v-on:click="open_page" :nid="child.id" :psrc="child.maddress">{{child.mname}}</label></li></ol>'+
        '<li>'+
    '<ol>',
    data: function () {
        this.checkedNid = '';
        this.modules = this.init_modules();
        return {modules: this.modules,box: false}
    },
    methods: {
        init_modules: function(){
            debugger
            var modules;
            var userid = this.bean.userid;
            var url = this.bean.dataUrl;
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
            debugger
            var target = arg.target;
            var firstNode = $(target).parents(".folderOne");
            if(firstNode){
                var firstName = firstNode.children("label:first").text();
                this.$parent.bean.firstName = firstName;
            }
            var secondNode = $(target).parents(".folderTwo");
            if(secondNode){
                var secondName = secondNode.children("label:first").text();
                this.$parent.bean.secondName = secondName;
            }
            if(this.checkedMs){

            }else{
                this.checkedNid = target.getAttribute("nid");
            }

            var ol = target.parentElement.parentElement;
            var className = ol.className;// += "active"
            if(className.indexOf("active") > -1){
               className = className.replace("active", " ");
            }else{
                className += " active";
            }
            ol.className = className;
            var src = target.getAttribute("psrc");
            var server = this.$parent.bean.config.server;
            this.$parent.bean.pageUrl = server + src;
        }
    }
})

/**
*表格
**/
Vue.component('vue-table', {
    props: ['bean'],
    template: '<table><tbody><tr v-for="(key, value) in sites">@tdHtml</tr></tbody></table>',
    data: function () {
        debugger
        this.sites = this.init_table();
        var tdHtml = this.setTdHtml(this.items);
        console.log(tdHtml);
        this.$options.template = this.$options.template.replace("@tdHtml", tdHtml);
        return {sites: this.sites}
    },
    methods: {
        init_table: function(arg){
            debugger
            var sites;
            var bean = this.bean;
            var search_service = bean.search_service;
            var params = bean.params;
            var pageNum;
            var pageSize;
            var pageCount;
            var countNum;
            var result;
            $.ajax({
                type: "post",
                async: false,//同步，异步
                url: search_service, //请求的服务端地址
                data: params,
                dataType: "json",
                success:function(data){
                    if(null != data){
                        pageNum = data.pageNum;
                        pageSize = data.pageSize;
                        pageCount = data.pageCount;
                        countNum = data.countNum;
                    }
                    sites = data.result;
                },
                error:function(i, s, e){
                    alert('error'); //错误的处理
                }
            });
            var num = this.$parent.$el.getElementsByTagName("num")[0];
            num.innerText = pageNum;
            var pcount = this.$parent.$el.getElementsByTagName("pcount")[0];
            pcount.innerText = pageCount;
            var size = this.$parent.$el.getElementsByTagName("size")[0];
            size.innerText = pageSize;
            var count = this.$parent.$el.getElementsByTagName("count")[0];
            count.innerText = countNum;
            return sites;
        },
        setTdHtml: function(arg){
            debugger
            var tdHtml = "";
            var ths = $(".head-list").find("th");
            $(ths).each(function(index, item){
                debugger
                var width = item.style.width;
                var md = item.getAttribute("md");
                var styleHtml = "text-align: center; width: " + width + ";";
                if("operation" == md){
                    tdHtml += "<td style='" + styleHtml + "' md='" + md + "'><a class='blue-xt'>查看</a><a class='yellow-xt'>修改</a><a class='red-xt'>删除</a></td>";
                }else if("index" == md){
                    tdHtml += "<td style='" + styleHtml + "' md='index'>{{key + 1}}</td>";
                }else{
                    tdHtml += "<td style='" + styleHtml + "' md='" + md + "'>{{value." + md + "}}</td>";
                }
            })
            return tdHtml;
        }
    }
})

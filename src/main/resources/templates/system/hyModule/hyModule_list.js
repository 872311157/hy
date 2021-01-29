$(function() {
    new Vue({
        el: '#hyTable',
        data: {
            bean:{
                search_service: '/hy/hyModule/queryPageList',
                params: {
                    mname: ''
                }
            }
        }
    })
})
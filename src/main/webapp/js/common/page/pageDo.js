function PagingManage(obj, pageCount, pageSize, currentPage) {
    if (obj) {
        var dataCount = pageCount; //数据总数
        var pagesize = pageSize;//单页数量
        var currentpage = currentPage;//当前页面
        var pageNum;//分页总数
        var showPageNum = 5;//显示多少个页码

        var pagehtml = '<ul class="pagination" style=" width: auto;display: table;margin-left: auto;margin-right:auto">';
        // var divId = "" + obj.attr('id');

        //计算分页总数
        if (dataCount % pagesize == 0) {
            pageNum = parseInt(dataCount / pagesize);
        } else {
            pageNum = parseInt(dataCount / pagesize) + 1;
        }

        console.log('页面总数:' + dataCount + '<>当前页面显示数量:' + pagesize + '<>当前页面:' + currentpage);

        //只有一页内容
        if (pageNum <= 1) {
            pagehtml = "";
        }

        //大于一页内容
        if (pageNum > 1) {
            if (currentpage > 1) {
                pagehtml += '<li><a href="javascript:javascript:void(0);" onclick="pageDo(\'' + (currentpage - 1) + '\')">上一页</a></li>';
            }

            var startPage = 1;
            //计算页码开始位置
            if (showPageNum > pageNum) {//如果要显示的页码大于总的页码数
                console.log('showPageNum > pageNum');
                startPage = 1
            } else {//如果要显示的页码小于总的页码数
                if (currentpage - (showPageNum / 2) <= 0) {//如果当前页面
                    startPage = 1;
                } else if (currentpage + (showPageNum / 2) >= pageNum) {
                    startPage = pageNum - showPageNum;
                } else {
                    startPage = currentpage - (showPageNum / 2);
                }
            }

            startPage = parseInt(startPage);

            for (var i = startPage; i < (startPage + showPageNum); i++) {

                //如果要输出的页面大于总的页面数,则退出
                if (i > pageNum) {
                    break;
                }

                if (i == currentpage) {
                    pagehtml += '<li class="active"><a href="javascript:void(0);" onclick="pageDo(\'' + i + '\')">' + i + '</a></li>';
                } else {
                    pagehtml += '<li><a href="javascript:void(0);" onclick="pageDo(\'' + i + '\')">' + i + '</a></li>';
                }
            }


            if (currentpage < pageNum) {
                pagehtml += '<li><a href="javascript:void(0);" onclick="pageDo(\'' + (currentpage + 1) + '\')">下一页</a></li>';
            }
        }
        pagehtml += '</ul>';
        obj.html(pagehtml);
    }
}
package menutest.pojo;

import java.util.List;

/**
 * @author LX
 * @date 2018/11/17 - 19:47
 */
public class PageInfo {
    // 显示的内容的 数目
    private int pageSize;
    // 当前 页数
    private int pageNumber;
    // 总页数
    private long total;
    // 某一页的数目   ? 泛型 可以保存你需要的展示的内容的信息
    private List<?>pageList;

    public PageInfo() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageInfo(int pageSize, int pageNumber, long total, List<?> pageList) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.total = total;
        this.pageList = pageList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getPageList() {
        return pageList;
    }

    public void setPageList(List<?> pageList) {
        this.pageList = pageList;
    }
}

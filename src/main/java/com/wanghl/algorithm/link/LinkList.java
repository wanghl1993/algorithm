package com.wanghl.algorithm.link;

public class LinkList {

    public Link first;// 定义一个头节点
    public Link last;//尾指针永远指向头节点
    public int size = 0;// 节点的位置

    public LinkList() {
        this.first = null;//
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isis() {
        return size == 0;
    }

    /**
     * 头插法
     *
     * @param data
     */
    public void addfirst(int data) {
        Link L = new Link(data);
        L.next = first;
        first = L;
        size++;
    }

    /**
     * 尾插法
     *
     * @param data
     */
    public void addlast(int data) {

        if (first == null) {
            first = new Link(data);
            last = first;
        } else {
            Link newL = new Link(data);
            last.next = newL;
            last = newL;
        }
        size++;
    }

    /**
     * 从头删除
     *
     * @return
     */
    public Link removefrist() {
        Link d = first;
        first = d.next;
        size--;
        return d;
    }

    /**
     * 删除最后一个
     */
    public void dellast() {
        Dell(size - 1);
    }

    /**
     * 获取链表长度
     */
    public void displayAllLink() {
        Link cure = first;
        while (cure != null) {
            cure.display();
            cure = cure.next;
        }
        System.out.println("长度" + size);
    }

    /**
     * 获取指定位置的节点元素
     *
     * @param index
     * @return
     */
    public Link getData(int index) {
        if (index < 0 && index > size - 1) {
            throw new IndexOutOfBoundsException("越界");
        }
        Link count = first;
        for (int i = 0; i < size && count != null; i++, count = count.next) {
            if (i == index) {
                return count;
            }
        }
        return null;
    }

    /**
     * 按值查找指定位置
     *
     * @param element
     * @return
     */
    public int selectIndex(int element) {
        Link current = first;
        for (int i = 0; i < size && current != null; i++, current = current.next) {
            if (current.data == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除链表中数值最大的元素
     */
    public void delMax() {
        // 要遍历的链表
        Link cu = first;
        // 初始化一个节点,当中间变量
        Link cc = new Link(0);
        // 遍历
        for (int i = 0; i < size && cu != null; i++, cu = cu.next) {
            if (cu.data > cc.data) {
                cc.data = cu.data;
            }
        }
        int data = cc.data;
        int number = selectIndex(data);
        Dell(number);
    }

    /**
     * 删除链表中数值最小的元素
     */
    public void delMin() {
        // 要遍历的链表
        Link cu = first;
        // 初始化一个节点,当中间变量
        Link cc = new Link(0);
        // 遍历
        for (int i = 0; i < size && cu != null; i++, cu = cu.next) {
            if (cu.data < cc.data) {
                cc.data = cu.data;
            }
        }
        int data = cc.data;
        int number = selectIndex(data);
        Dell(number);
    }

    /**
     * 从指定位置处插入数据
     *
     * @param t
     * @param index
     */
    public void insert(int t, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        if (first == null) {
            addlast(t);
        } else {
            if (index == 0) {
                addfirst(t);
            } else {
                Link k = getData(index - 1);
                k.next = new Link(t, k.next);
                size++;
            }

        }
    }

    /**
     * 从指定位置处删除
     *
     * @param index
     */
    public void Dell(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引超出线性表范围");
        }
        Link del = null;
        if (index == 0) {
            del = first.next;
            first = first.next;
        } else {
            Link neL = getData(index - 1);
            del = neL.next;
            neL.next = del.next;
            del.next = null;
        }
        size--;
    }

    /**
     * 清空链表
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 按从小到大排序
     */
    public void Min_to_Max() {
        // 要遍历的链表
        Link cu = first;
        // 记录最小值
        int min;
        while (cu != null) {
            // 内重循环从当前节点的下一个节点循环到尾节点,找到和外重循环的值比较最小的那个,然后与外重循环进行交换
            Link nextLink = cu.next;
            while (nextLink != null) {
                // 比外循环小的值放在前面
                if (nextLink.data < cu.data) {
                    min = nextLink.data;
                    nextLink.data = cu.data;
                    cu.data = min;
                }
                nextLink = nextLink.next;
            }
            cu = cu.next;
        }

    }

    /**
     * 按从大到大排序
     */
    public void Max_to_Min() {
        // 要遍历的链表
        Link cu = first;
        // 记录最小值
        int min;
        while (cu != null) {
            // 内重循环从当前节点的下一个节点循环到尾节点
            //找到和外重循环的值比较最小的那个,然后与外重循环进行交换
            Link nextLink = cu.next;
            while (nextLink != null) {
                // 比外循环小的值放在前面
                if (nextLink.data > cu.data) {
                    min = nextLink.data;
                    nextLink.data = cu.data;
                    cu.data = min;
                }
                nextLink = nextLink.next;
            }
            cu = cu.next;
        }

    }

}


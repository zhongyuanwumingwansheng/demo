package com.example.demo.service;

import com.example.demo.model.Node;

public class NodeService {

    public void printNodeDataList(Node node){
        while(node!=null){
            System.out.print(node.getData()+" ");
            node=node.getNext();
        }
        System.out.println();
    }

    /**
     * 生成反转的链表
     * @param node 用节点表示的当前链表
     * @return
     */
    public Node reverseNodeDataList(Node node){
        //特殊值处理
        if(null==node){
            return node;
        }

        //记录表头
        Node head = new Node();
        //记录中间值
        Node tempNode;

        //循环在head和当前第一个节点之间插入
        while(node!=null){
            tempNode =head.getNext();
            Node newNode = new Node(node.getData());
            newNode.setNext(tempNode);
            head.setNext(newNode);
            node=node.getNext();
        }
        return head.getNext();
    }

}
package com.example.algorithm.binaryTree;


import io.swagger.models.auth.In;

import javax.validation.constraints.Max;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * 二叉搜索树是二叉树的一种，   二叉查找树   二叉排序树
 * <p>
 * 任意一个节点的值都大于其左子树所有节点的值
 * 任意一个节点的值都小于其右子树所有节点的值
 *
 * @author beantechs
 */
public class BinarySearchTree<E> {


    private Integer size;
    private Node<E> root;


    public static void main(String[] args) {


    }

    /**
     * 前序遍历
     * 访问顺序
     * 1 根节点
     * 2 前序遍历左子树
     * 3 前序遍历右子树
     */
    public void preorder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preorder(node.left);
        preorder(node.right);
    }

    /**
     * 中序遍历(是顺序的)
     * 访问顺序
     * 1 左子树
     * 2 根节点
     * 3 右子树
     *
     * @param node
     */
    public void inorder(Node<E> node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.element);
        inorder(node.right);
    }

    /**
     * 后续遍历
     * <p>
     * 适用一些先子后父的操作
     *
     * @param node
     */
    public void postorder(Node<E> node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.element);
    }

    /**
     * 层次遍历
     * 步骤：1  将跟节点入队，出队时访问，访问时将它的字节点入队
     * <p>
     * 可以计算二叉树的高度
     * 判断是否为完全二叉树
     *
     * @param
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.right);
            }
        }
    }

    /**
     * 计算二叉树的高度  递归
     *
     * @return
     */
    public Integer highByRec(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(highByRec(node.right), highByRec(node.left));
    }

    /**
     * 计算二叉树的高度 迭代
     *
     * @param root
     * @return
     */
    public Integer highByItr(Node<E> root) {
        if (root == null) {
            return 0;
        }
        return null;
    }

    /**
     * 判断一颗二叉树是否为完全二叉树
     * <p>
     * 如果左右都不为空，按顺序入队
     * 如果左空，右不为空  返回false
     * 如果左不空，右不空，获取左右都为空   后面遍历的节点都是叶子节点  否则返回false
     *
     * @return
     */
    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else { //后面遍历的节点都是叶子节点
                if (node.left != null || node.right != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 添加新节点
     * <p>
     * 步骤：1 找到父节点
     * 2 创建新节点
     * 3 parent.left = node 或 parent.right = node
     *
     * @param element
     */
    public void add(E element) {
        //添加的是第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 找到父节点
        Node<E> node = root;
        Node<E> parent = root;
        int res = 0;
        while (node != null) {
            res = compare(element, node.element);
            parent = node;
            if (res > 0) {
                node = node.right;
            } else if (res < 0) {
                node = node.left;
            } else {
                return;
            }
        }
        //判断插入到父节点的位置
        Node<E> newNode = new Node<>(element, parent);
        if (res > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
    }


    private int compare(E e1, E e2) {
        return 0;
    }


    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        /**
         * 递归创建二叉树节点
         *
         * @param node
         */
//        public void add(Node node) {
//            if (node == null) {
//                return;
//            }
//            //判断传入节点的值，和当前子树的根节点的值关系
//            if (node.value < this.value) {
//                //如果当前节点左子节点为null
//                if (this.left == null) {
//                    this.left = node;
//                } else {
//                    //递归向左子树添加
//                    this.left.add(node);
//                }
//                //添加的节点大于当前节点的值
//            } else {
//                if (this.right == null) {
//                    this.right = node;
//                } else {
//                    //递归向右子树添加
//                    this.right.add(node);
//                }
//            }
//        }

    }

}



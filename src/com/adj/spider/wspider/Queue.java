package com.adj.spider.wspider;

import java.util.LinkedList;

public class Queue {

	//����ʵ�ֶ���
	private LinkedList queue = new LinkedList();
	
	//�����
	public void enQueue (Object t) {
		queue.addLast(t);
	}
	
	//������
	public Object deQueue() {
		return queue.removeFirst();
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	//�ж϶����Ƿ����t
	public boolean contains(Object t) {
		return queue.contains(t);
	}
}

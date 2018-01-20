package com.nico.list;

import java.util.Queue;

public class LinkedListNode {

	public int value;
	public LinkedListNode next;

	public LinkedListNode(int value) {
		this.value = value;
	}

	public LinkedListNode(Queue<Integer> values) {
		this.value = values.poll();
		if (!values.isEmpty())
			this.next = new LinkedListNode(values);
	}

	public LinkedListNode reverseRecursive(LinkedListNode old) {
		if (next == null) {
			this.next = old;
			return this;
		} else {
			LinkedListNode previousNext = this.next;
			this.next = old;
			return previousNext.reverseRecursive(this);
		}
	}

	public static LinkedListNode reverseIterative(LinkedListNode head) {
		LinkedListNode curNode = head;
		LinkedListNode oldNode = null;
		while (curNode != null) {
			LinkedListNode tmp = curNode.next;
			curNode.next = oldNode;
			oldNode = curNode;
			curNode = tmp;
		}
		return oldNode;
	}

	@Override
	public String toString() {
		return "" + value + (next == null ? "" : ("," + next.toString()));
	}

}

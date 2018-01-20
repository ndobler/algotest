package com.nico.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class LinkedListNodeTest {

	@Test
	public void testReverseRecursive() {
		Queue<Integer> q = new LinkedList<>();
		int i = 0;
		q.add(i++);
		q.add(i++);
		q.add(i++);
		q.add(i++);
		LinkedListNode head = new LinkedListNode(q);
		System.out.println("original queue: " + head.toString());
		LinkedListNode reverse = head.reverseRecursive(null);
		System.out.println("revesed queue: " + reverse.toString());
		assertEquals("3,2,1,0", reverse.toString());
	}

	@Test
	public void testReverseIte() {
		Queue<Integer> q = new LinkedList<>();
		int i = 0;
		q.add(i++);
		q.add(i++);
		q.add(i++);
		q.add(i++);
		LinkedListNode head = new LinkedListNode(q);
		System.out.println("original queue: " + head.toString());
		LinkedListNode reverse = LinkedListNode.reverseIterative(head);
		System.out.println("revesed queue: " + reverse.toString());
		assertEquals("3,2,1,0", reverse.toString());
	}

	@Test
	public void testReverseSingEle() {
		LinkedListNode head = new LinkedListNode(1);
		System.out.println("original queue: " + head.toString());
		LinkedListNode reverse = head.reverseRecursive(null);
		assertEquals("1", reverse.toString());
		System.out.println("revesed queue: " + reverse.toString());
		LinkedListNode reverseIte = LinkedListNode.reverseIterative(head);
		System.out.println("revesed ite queue: " + reverseIte.toString());
		assertEquals("1", reverseIte.toString());
	}

	@Test
	public void testReverseNull() {
		System.out.println("original queue: " + null);
		LinkedListNode reverseIte = LinkedListNode.reverseIterative(null);
		System.out.println("revesed ite queue: " + reverseIte);
		assertNull(reverseIte);
	}

}

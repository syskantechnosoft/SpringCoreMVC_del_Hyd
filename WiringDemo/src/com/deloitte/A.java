package com.deloitte;

public class A {
	private B b;

	public A() {
		System.out.println("A is created");
	}

	public A(B b) {
		this.b = b;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public void print() {
		System.out.println("hello a");
	}

	public void display() {
		print();
		b.print();
	}
}

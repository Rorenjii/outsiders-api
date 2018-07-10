package org.outsiders.release.domain.constant;

public enum D {
	D2(2), D3(3), D4(4), D6(6), D8(8), D12(12), D20(20), D100(100);
	
	private int value;
	
	D(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

package org.outsiders.release.domain;

import org.outsiders.release.domain.constant.Shape;
import org.outsiders.release.domain.constant.TargetType;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType
public class Target {
	
	private TargetType type;
	private Shape shape;
	private int range;
	private int size;
	
	public TargetType getType() {
		return type;
	}
	public void setType(TargetType type) {
		this.type = type;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}

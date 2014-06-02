/*
 * boogieamp - Parser, Factory, and Utilities to create Boogie Programs from Java
 * Copyright (C) 2013 Martin Schaeaeaef and Stephan Arlt
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package boogie.expression.literal;

import java.util.HashMap;
import java.util.List;

import boogie.expression.Expression;
import boogie.location.ILocation;
import boogie.type.BoogieType;

/**
 * Represents a string literal. This is only used as attribute value, since
 * strings are not otherwise supported in Boogie. A string literal never has a
 * type.
 */
public class StringLiteral extends Expression {
	/**
	 * The serial version UID.
	 */
	// private static final long serialVersionUID = 1L;
	/**
	 * The value of this string literal.
	 */
	String value;

	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 * @param value
	 *            the value of this string literal.
	 */
	public StringLiteral(ILocation loc, String value) {
		super(loc);
		this.value = value;
	}

	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 * @param type
	 *            the type of this expression.
	 * @param value
	 *            the value of this string literal.
	 */
	public StringLiteral(ILocation loc, BoogieType type, String value) {
		super(loc, type);
		this.value = value;
	}

	/**
	 * Returns a textual description of this object.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("StringLiteral").append('[');
		sb.append(value);
		return sb.append(']').toString();
	}

	/**
	 * Gets the value of this string literal.
	 * 
	 * @return the value of this string literal.
	 */
	public String getValue() {
		return value;
	}

	public List<Object> getChildren() {
		List<Object> children = super.getChildren();
		children.add(value);
		return children;
	}
	
	@Override
	public Expression substitute(HashMap<String, Expression> s) {
		return new StringLiteral(this.getLocation(), this.getType(), this.value);
	}
	
}

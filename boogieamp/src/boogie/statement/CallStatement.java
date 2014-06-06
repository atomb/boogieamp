/*
 * boogieamp - Parser, Factory, and Utilities to create Boogie Programs from Java
 * Copyright (C) 2013 Martin Schaef and Stephan Arlt
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

package boogie.statement;

import java.util.List;

import boogie.ast.Attribute;
import boogie.enums.CallParameters;
import boogie.expression.Expression;
import boogie.location.ILocation;

/**
 * Represents a call statement which is a special form of a statement.
 */
public class CallStatement extends Statement {
	/**
	 * The serial version UID.
	 */
	// private static final long serialVersionUID = 1L;
	/**
	 * True iff this call statement is forall.
	 */
	boolean isForall;
	
	CallParameters callparams = CallParameters.NONE;
	
	Attribute[] attributes;

	/**
	 * The lhs of this call statement.
	 */
	String[] lhs;

	/**
	 * The method name of this call statement.
	 */
	String methodName;

	/**
	 * The arguments of this call statement.
	 */
	Expression[] arguments;

	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 * @param isForall
	 *            true iff this call statement is forall.
	 * @param lhs
	 *            the lhs of this call statement.
	 * @param methodName
	 *            the method name of this call statement.
	 * @param arguments
	 *            the arguments of this call statement.
	 */
	public CallStatement(ILocation loc, boolean isForall, String[] lhs,
			String methodName, Expression[] arguments) {
		super(loc);
		this.isForall = isForall;
		this.lhs = lhs;
		this.methodName = methodName;
		this.arguments = arguments;
	}

	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 * @param isForall
	 *            true iff this call statement is forall.
	 * @param lhs
	 *            the lhs of this call statement.
	 * @param methodName
	 *            the method name of this call statement.
	 * @param arguments
	 *            the arguments of this call statement.
	 */
	public CallStatement(ILocation loc, boolean isForall, String[] lhs,
			String methodName, Expression[] arguments, CallParameters cp, Attribute[] attributes) {
		super(loc);
		this.isForall = isForall;
		this.lhs = lhs;
		this.methodName = methodName;
		this.arguments = arguments;
		this.callparams = cp;
		this.attributes = attributes;
	}
	
	/**
	 * Returns a textual description of this object.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("CallStatement").append('[');
		sb.append(isForall);
		sb.append(',');
		if (lhs == null) {
			sb.append("null");
		} else {
			sb.append('[');
			for (int i1 = 0; i1 < lhs.length; i1++) {
				if (i1 > 0)
					sb.append(',');
				sb.append(lhs[i1]);
			}
			sb.append(']');
		}
		sb.append(',').append(methodName);
		sb.append(',');
		if (arguments == null) {
			sb.append("null");
		} else {
			sb.append('[');
			for (int i1 = 0; i1 < arguments.length; i1++) {
				if (i1 > 0)
					sb.append(',');
				sb.append(arguments[i1]);
			}
			sb.append(']');
		}
		return sb.append(']').toString();
	}

	/**
	 * Checks iff this call statement is forall.
	 * 
	 * @return true iff this call statement is forall.
	 */
	public boolean isForall() {
		return isForall;
	}

	/**
	 * Gets the lhs of this call statement.
	 * 
	 * @return the lhs of this call statement.
	 */
	public String[] getLhs() {
		return lhs;
	}

	/**
	 * Gets the method name of this call statement.
	 * 
	 * @return the method name of this call statement.
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * Gets the arguments of this call statement.
	 * 
	 * @return the arguments of this call statement.
	 */
	public Expression[] getArguments() {
		return arguments;
	}

	public List<Object> getChildren() {
		List<Object> children = super.getChildren();
		children.add(isForall);
		children.add(lhs);
		children.add(methodName);
		children.add(arguments);
		return children;
	}
}

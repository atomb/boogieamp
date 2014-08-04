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

package boogie.ast.statement;

import java.util.List;

import boogie.ast.expression.Expression;
import boogie.ast.location.ILocation;

/**
 * Represents a return statement which is a special form of a statement.
 */
public class ReturnStatement extends Statement {
	
	private Expression expression;
	
	/**
	 * The serial version UID.
	 */
	// private static final long serialVersionUID = 1L;
	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 */
	public ReturnStatement(ILocation loc) {
		super(loc);
	}

	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 * @param e
	 * 			  the return expression. NOTE: this can only be used in code-expression. 
	 *            Regular boogie code never returns an expression but uses out-variables instead!
	 */
	public ReturnStatement(ILocation loc, Expression e) {
		super(loc);
		this.expression = e;
	}
	
	public Expression getExpression() {
		return this.expression;
	}
	
	/**
	 * Returns a textual description of this object.
	 */
	public String toString() {
		return "ReturnStatement";
	}

	public List<Object> getChildren() {
		List<Object> children = super.getChildren();
		return children;
	}
}

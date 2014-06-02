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

package boogie.controlflow.expression;

import java.util.HashMap;

import boogie.controlflow.CfgVariable;
import boogie.location.ILocation;
import boogie.type.BoogieType;

/**
 * @author martin
 * 
 */
public class CfgIfThenElseExpression extends CfgExpression {

	private CfgExpression condition, thenExpression, elseExpression;

	public CfgIfThenElseExpression(ILocation loc, BoogieType type,
			CfgExpression condition, CfgExpression thenExpr,
			CfgExpression elseExpr) {
		super(loc, type);
		this.condition = condition;
		this.thenExpression = thenExpr;
		this.elseExpression = elseExpr;
	}

	/**
	 * @return the condition
	 */
	public CfgExpression getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(CfgExpression condition) {
		this.condition = condition;
	}

	/**
	 * @return the theExpression
	 */
	public CfgExpression getThenExpression() {
		return thenExpression;
	}

	/**
	 * @param theExpression
	 *            the theExpression to set
	 */
	public void setThenExpression(CfgExpression theExpression) {
		this.thenExpression = theExpression;
	}

	/**
	 * @return the elseExpression
	 */
	public CfgExpression getElseExpression() {
		return elseExpression;
	}

	/**
	 * @param elseExpression
	 *            the elseExpression to set
	 */
	public void setElseExpression(CfgExpression elseExpression) {
		this.elseExpression = elseExpression;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(if ");
		sb.append(this.condition);
		sb.append(" then ");
		sb.append(this.thenExpression);
		sb.append(" else ");
		sb.append(this.elseExpression);
		sb.append(")");
		return sb.toString();
	}

	@Override
	public CfgExpression clone() {
		return new CfgIfThenElseExpression(this.getLocation(), this.getType(), this.condition.clone(), this.thenExpression.clone(), this.elseExpression.clone());
	}

	@Override
	public CfgExpression substitute(
			HashMap<CfgVariable, CfgExpression> substitutes) {
		return new CfgIfThenElseExpression(this.getLocation(), this.getType(), this.condition.substitute(substitutes), 
				this.thenExpression.substitute(substitutes), 
				this.elseExpression.substitute(substitutes));
	}
	
	
}

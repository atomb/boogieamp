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

import boogie.ast.location.ILocation;
import boogie.controlflow.CfgVariable;
import boogie.type.BoogieType;

/**
 * @author schaef
 * 
 */
public class CfgBitVectorAccessExpression extends CfgExpression {

	private CfgExpression bitvector;
	private int start, end;

	public CfgBitVectorAccessExpression(ILocation loc, BoogieType type,
			CfgExpression bvexpression, int start, int end) {
		super(loc, type);
		this.bitvector = bvexpression;
		this.start = start;
		this.end = end;
	}

	/**
	 * @return the bitvector
	 */
	public CfgExpression getBitvector() {
		return bitvector;
	}

	/**
	 * @param bitvector
	 *            the bitvector to set
	 */
	public void setBitvector(CfgExpression bitvector) {
		this.bitvector = bitvector;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//TODO
		return sb.toString();
	}

	@Override
	public CfgExpression substitute(
			HashMap<CfgVariable, CfgExpression> substitutes) {		
		return new CfgBitVectorAccessExpression(this.getLocation(), this.getType(), this.bitvector.clone(), this.start, this.end);
	}
	
	
}

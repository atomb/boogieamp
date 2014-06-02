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

package boogie.specification;

import java.util.List;

import boogie.location.ILocation;

/**
 * Represents a modifies specification which is a special form of a
 * specification.
 */
public class ModifiesSpecification extends Specification {
	/**
	 * The serial version UID.
	 */
	// private static final long serialVersionUID = 1L;
	/**
	 * The identifiers of this modifies specification.
	 */
	String[] identifiers;

	/**
	 * The constructor taking initial values.
	 * 
	 * @param loc
	 *            the node's location
	 * @param isFree
	 *            true iff this specification is free.
	 * @param identifiers
	 *            the identifiers of this modifies specification.
	 */
	public ModifiesSpecification(ILocation loc, boolean isFree,
			String[] identifiers) {
		super(loc, isFree);
		this.identifiers = identifiers;
	}

	/**
	 * Returns a textual description of this object.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ModifiesSpecification").append('[');
		if (identifiers == null) {
			sb.append("null");
		} else {
			sb.append('[');
			for (int i1 = 0; i1 < identifiers.length; i1++) {
				if (i1 > 0)
					sb.append(',');
				sb.append(identifiers[i1]);
			}
			sb.append(']');
		}
		return sb.append(']').toString();
	}

	/**
	 * Gets the identifiers of this modifies specification.
	 * 
	 * @return the identifiers of this modifies specification.
	 */
	public String[] getIdentifiers() {
		return identifiers;
	}

	public List<Object> getChildren() {
		List<Object> children = super.getChildren();
		children.add(identifiers);
		return children;
	}
}

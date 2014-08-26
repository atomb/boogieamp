/**
 * 
 */
package boogie.ast.expression;

import java.util.HashMap;
import java.util.HashSet;

import boogie.ast.Body;
import boogie.ast.location.ILocation;
import boogie.ast.statement.Statement;

/**
 * @author schaef
 *
 */
public class CodeExpression extends Expression {

	Body body;
	
	public CodeExpression(ILocation loc, Body b) {
		super(loc);
		this.body = b;
	}

	public Body getBody() {
		return this.body;
	}
	
	/**
	 * Returns a textual description of this object.
	 */
	@Override
	public String toString() {
		return "CodeExpression";
	}
	
	
	/* (non-Javadoc)
	 * @see boogie.expression.Expression#substitute(java.util.HashMap)
	 */
	@Override
	public Expression substitute(HashMap<String, Expression> s) {
		throw new RuntimeException("Subsitution for CodeExpression not implemented!");
	}

	@Override
	public HashSet<IdentifierExpression> getFreeVariables() {
		HashSet<IdentifierExpression> ret = new HashSet<IdentifierExpression>();
		for (Statement s : this.body.getBlock()) {
			//TODO:
		}
		return ret;
	}
	
}

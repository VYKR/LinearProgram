package model;

/**
 * Saves the variable and the bounds of the variable. a bound is infinity if the
 * corresponding bollean field is true or the value of the corresponding float
 * field.
 * 
 */
public class Variable {

	public LPProgram source = null;

	public String name;
	public float lowerBound = 0;
	public boolean lowerIsInfinity = false;
	public float upperBound = 0;
	public boolean upperIsInfinity = true;
	public final VariableType type = VariableType.SEMI;

	public Variable(String name) {
		this.name = name;
	}

	public Variable(String name, float lowerBound, boolean lowerIsInfinity,
			float upperBound, boolean upperIsInfinity) {
		this.name = name;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.lowerIsInfinity = lowerIsInfinity;
		this.upperIsInfinity = upperIsInfinity;
	}

	public void setSource(LPProgram program) {
		if (program == null)
			return;
		program.addVariable(this);
		this.source = program;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Variable))
			return false;
		return ((Variable) obj).name.equals(name);
	}
}

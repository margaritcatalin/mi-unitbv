import java.io.Serializable;

class Arc implements Serializable{
private String st;
	private String simbolArc;
	private String dr;

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getSimbolArc() {
		return simbolArc;
	}

	public Arc(String st, String simbolArc, String dr) {
		super();
		this.st = st;
		this.simbolArc = simbolArc;
		this.dr = dr;
	}

	public Arc() {
		// TODO Auto-generated constructor stub
	}

	public void setSimbolArc(String simbolArc) {
		this.simbolArc = simbolArc;
	}

	public String getDr() {
		return dr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((simbolArc == null) ? 0 : simbolArc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arc other = (Arc) obj;
		if (simbolArc == null) {
			if (other.simbolArc != null)
				return false;
		} else if (!simbolArc.equals(other.simbolArc))
			return false;
		return true;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}
	@Override
	public String toString() {
		return "Arc [st=" + st + ", simbolArc=" + simbolArc + ", dr=" + dr + "]";
	}

}
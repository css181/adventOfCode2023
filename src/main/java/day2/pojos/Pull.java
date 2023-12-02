package day2.pojos;

public class Pull {

	private int reds;
	private int greens;
	private int blues;
	
	public Pull(int reds, int greens, int blues) {
		super();
		this.reds = reds;
		this.greens = greens;
		this.blues = blues;
	}
	protected int getReds() {
		return reds;
	}
	protected void setReds(int reds) {
		this.reds = reds;
	}
	protected int getGreens() {
		return greens;
	}
	protected void setGreens(int greens) {
		this.greens = greens;
	}
	protected int getBlues() {
		return blues;
	}
	protected void setBlues(int blues) {
		this.blues = blues;
	}
	
	@Override
	public String toString() {
		return "reds: " + reds + ", greens: " + greens + ", blues: " + blues;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        if(!(obj instanceof Pull)) { return false; }
        Pull other = (Pull) obj;

        if(this.reds != other.reds) { return false; }
        if(this.greens != other.greens) { return false; }
        if(this.blues != other.blues) { return false; }
        
        return true;
    }
}

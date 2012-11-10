// instances represent 2-dimensional pictures
// consisting of printable characters
public interface Pict {
	// returns the picture as String
	String toString();
	
	// 0.1 <= factor <= 10.0; resize the picture
	void scale(double factor);
}
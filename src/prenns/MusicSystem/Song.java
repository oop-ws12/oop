package prenns.MusicSystem;

/**
* @author Alexander Prennsberger
*/
public class Song {

	private String name;
	private int duration;
	
	public Song(String name, int duration) {
	
		this.name = name;
		this.duration = duration;
	}
	
	public String getName() {
		return name;	
	}
	
	public int getDuration() {
		return duration;	
	}
}

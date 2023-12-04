import java.util.Comparator;

public class CompareByMilesPerGallon implements Comparator<Automobile>{
	public int compare(Automobile automobile1, Automobile automobile2) {
		return Double.compare(automobile1.getMilesPerGallon(),automobile2.getMilesPerGallon());
	}
}

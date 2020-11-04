package journalplus.utility;

public class BasicUtility {
	public static double runden(final double wert, final int n) {
        return Math.round(Math.pow(10.0, n) * wert) / Math.pow(10.0, n);
    }
}

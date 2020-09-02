public class Helper {
    public static String convertValueToSeconds(String value) {
        // xx.yy.yy -> xx*60 + yy.yy
        int firstDot = value.indexOf('.');
        float minutes = Float.parseFloat(value.substring(0, firstDot));
        float seconds = Float.parseFloat(value.substring(firstDot + 1));
        return Float.toString((60 * minutes) + seconds);
    }

    public static String convertValueToMinutes(float value) {
        float seconds = value % 60;
        int minutes = (int) ((value - seconds) / 60);
        return String.format("%d:%.2f", minutes, seconds);
    }

    public static String prettyPerformanceValue(float value, String units) {
        String returnValue = null;
        String returnUnits = null;
        switch (units) {
            case "Seconds":
                returnUnits = " s";
                returnValue = String.valueOf(value);
                break;
            case "Metres":
                returnUnits = " m";
                returnValue = String.valueOf(value);
                break;
            case "Minutes:Seconds":
                returnUnits = " m:s";
                returnValue = convertValueToMinutes(value);
                break;
            default:
                // cia nieko nereikia
//                returnUnits = "";
//                returnValue = String.valueOf(value);
        }
        return returnValue + returnUnits;
    }
}

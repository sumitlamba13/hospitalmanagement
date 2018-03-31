package utility;

public class Validations {

    public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().isEmpty();
        }
        return false;
    }

    public static boolean isNumeric(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    public static boolean isFLoat(String value) {
        try {
            if (value != null) {
                Float.parseFloat(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {
        }
        return false;
    }

    public static void isPrimary(String value) {
        String message = "";
        try {
            if (value.contains("\'PRIMARY\'")) {
                message = "Record with such details is already present in database";
                //return message;
            }
        }catch(NumberFormatException ex){
        }
        //return null;
    }

    public static String isForeign(String value) {
        String message = "";
        if (value.contains("foreign")) {
            message += "Can not Update od Delete \n\n";
            message += "Updation or Deletion can resullt in loss of vital information \n\n";
            return message;
        }
        return null;
    }
}

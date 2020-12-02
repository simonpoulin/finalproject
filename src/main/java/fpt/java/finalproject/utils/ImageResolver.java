package fpt.java.finalproject.utils;

public class ImageResolver {
    private final String URL = "https://res.cloudinary.com/surfnshop/image/upload";

    public String solve(String imageName, String crop, Integer width, Integer height) {
        String str = this.URL;
        if (!crop.equals("") && width > 0 && height > 0) {
            str += "/c_";
            if (!crop.equals("")) {
                str += crop;
            } else {
                str += "fill";
            }
            
            if (width > 0) {
                str = str + ",w_" + width;
            }

            if (height > 0) {
                str = str + ",h_" + height;
            }
        }
        str = str + "/" + imageName;
        return str;
    }
}

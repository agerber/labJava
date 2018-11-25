/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lec08.glab.javafx;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam Gerber on 6/4/2014.
 * adam.gerber@yahoo.com
 */

// See an example or raw json results here: http://www.yelp.com/developers/documentation/v2/search_api#rValue
//copy and paste into here: //http://jsonviewer.stack.hu/  to see the structure
public class YelpSearchResults {

    public List<Business> businesses;
    public class Business {

        public String name;
        public String url;
        public String phone;
        public Location location;
        public String rating_img_url;
        public String image_url;

        public class Location {
            public List<String> address;

        }
    }

    
    //the rest of these methods are not necessary. they're just utilities to extract data

    public ArrayList<String> getSimpleValues() {
        ArrayList<String> simpleValues = new ArrayList<String>();


        for (Business biz : businesses) {
            try {
                simpleValues.add(biz.name + " | " + biz.location.address.get(0) + " | " + getStars(biz.rating_img_url));
            } catch (Exception e) {
                //will continue on its own
                if (biz.name != null) {
                    simpleValues.add(biz.name);
                } else {
                    simpleValues.add("");
                }
            }
        }

        return simpleValues;
    }

    private String getStars(String strUrl){

        int nHalfCode = Integer.parseInt("00BD", 16);
        char[] cChars = Character.toChars(nHalfCode);
        String strHalf = String.valueOf(cChars);


        //try the most specific conditions first
        if(strUrl.contains("stars_4_half")){
            return "****" + strHalf;
        } else if (strUrl.contains("stars_3_half")){
            return "***" + strHalf;
        } else if (strUrl.contains("stars_2_half")){
            return "**" + strHalf;
        } else if (strUrl.contains("stars_1_half")){
            return "*" + strHalf;
        }else if (strUrl.contains("stars_5")){
            return "*****" ;
        }else if (strUrl.contains("stars_4")){
            return "****" ;
        }else if (strUrl.contains("stars_3")){
            return "***" ;
        }else if (strUrl.contains("stars_2")){
            return "**" ;
        }else if (strUrl.contains("stars_1")){
            return "*" ;
        }else {
            return "";
        }
    }



}

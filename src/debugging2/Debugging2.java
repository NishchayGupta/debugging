/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debugging2;

import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author 1895314
 */
public class Debugging2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String json = FileReader.loadFileIntoString("json/jsonLint.json", "UTF-8");
        System.out.println(json);
        JSONObject student = JSONObject.fromObject(json);
        String firstName, lastName, DOB, street, zipCode, course, numbers="";
        int  number, mark;
        long studentId;
        double gpa;
        JSONObject address, marks;
        JSONArray phoneNumber;
        JSONArray results;
        String resultStr="";
           
            firstName = student.getString("FirstName");
            lastName = student.getString("LastName");
            DOB = student.getString("DOB");
            studentId = student.getLong("StudentID");
            gpa = student.getDouble("GPA");
            address = student.getJSONObject("Address");
            number = address.getInt("Number");
            street = address.getString("Street");
            zipCode = address.getString("Zip Code");
            phoneNumber = student.getJSONArray("PhoneNumber");
            
            System.out.println("--------------------------");
            for(int j=0; j<phoneNumber.size(); j++)
            {
                numbers += phoneNumber.getString(j)+ "\n";
                //System.out.println(numbers[j]);
            }
            results = student.getJSONArray("Results");
            for(int k=0; k<results.size(); k++)
            {
                marks = results.getJSONObject(k);
                course = marks.getString("Course");
                mark = marks.getInt("Mark");
                resultStr += course + " " + mark + "\n"; 
                //System.out.println(course + "     " + mark);
            }
            System.out.println("{\n" + firstName + ",\n" + lastName + ",\n" + DOB + ",\n" + studentId +
                    ",\n" + gpa + ",\n" + numbers + ",\n" + resultStr + ",\n}");
        }
    }
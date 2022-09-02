package org.acme;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    ServiceClass serviceClass;

    @GET
    @Path("/otp/{num}")
    public String OTP(@PathParam("num") int num) {
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[num];

        for (int i = 0; i < num; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        System.out.println(otp);
        return "otp";
    }

    @GET
    @Path("/password/{num}")
    public String password(@PathParam("num") int len) {

        String capAbc = "ABCDEFGHIJKHLMNOPQRSTUVWXYZ";
        String samAbc = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = capAbc + samAbc + numbers + symbols;

        Random random = new Random();

        char[] password = new char[len];

        for (int i = 0; i < len; i++) {

            password[i] = values.charAt(random.nextInt(values.length()));

        }

        System.out.print(password);
        return "password";
    }

    @GET
    @Path("/reverse")
    public String plandrome() {

        String name = "sadam";
        String newName = "";
        int len = name.length();

        for (int i = 0; i <= len - 1; i++) {
            char c[] = { name.charAt(i) };
            newName = c + newName;
        }
        return newName;
    }

    @GET
    @Path("/3rdHighestNumber")
    public int thirdHiestNumber() {

        int array[] = { 10, 88, 99, 36, 44, 12, 6, 2, 3 };
        int temp = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }

        return array[2];
    }

    @GET
    @Path("/getAll")
    public List<Employee> hello() throws SQLException {

        return serviceClass.showAllPersons();
    }

    @GET
    @Path("/getById/{id}")
    public Employee getById(@PathParam("id") int id) {
        return serviceClass.showById(id);
    }

    @PUT
    @Path("/update/{id}")
    public Integer insertByObject(@PathParam("id") int id, Employee employee) {
        System.out.println("   Update endpoint calls ");
        return serviceClass.updateByIdService(id, employee);
    }

    @POST
    @Path("/insert")
    public Integer insert(@PathParam("Personid") int id, @PathParam("FirstName") String fname,
            @PathParam("LastName") String lname, @PathParam("Age") int age) {
        System.out.println(fname);
        return serviceClass.insert(id, fname, lname, age);
    }

    @POST
    @Path("/insertByObject")
    public Integer insertByObject(Employee employee) {
        System.out.println(employee.getLastName());
        return serviceClass.insert(employee);
    }

    @GET
    @Path("/fibonic")
    public Integer showBibonic() {

        int num = 12;
        int previouse = 0;
        int current = 1;
        int next = 0;

        for (int i = 1; i < num; i++) {

            next = previouse + current;
            previouse = current;
            current = next;
        }
        System.out.println(" " + next);
        return next;
    }

    @GET
    @Path("/factorial")
    public Integer getFactorial() {

        int num = 5;
        int factorial = 1;
      

        for (int i = 1; i <= num; i++) {

            factorial = factorial * i;
          
        }
        System.out.println(" " + factorial);
        return factorial;
    }

    @GET
    @Path("/insertionSort")
    public String sortInsertion(){

        int [] array = { 9, 5, 1, 4, 3 };
        int size = array.length;

        for (int step = 1; step < size; step++) {
          int key = array[step];
          int j = step - 1;
          System.out.println((step - 1));
    
          // Compare key with each element on the left of it until an element smaller than
          // it is found.
          // For descending order, change key<array[j] to key>array[j].
          while (j >= 0 && key < array[j]) {
            System.out.println(" key : "+key + "  array[j] : "+ array[j]);
            array[j + 1] = array[j];
            --j;
          }
    
          // Place key at after the element just smaller than it.
          array[j + 1] = key;
        }  
     
         return "insertion Sort";
        }
}